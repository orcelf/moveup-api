package jp.co.vermore.controller.admin;

import jp.co.vermore.common.Constant;
import jp.co.vermore.common.DatatablesJsonObject;
import jp.co.vermore.common.mvc.BaseController;
import jp.co.vermore.common.util.DateUtil;
import jp.co.vermore.entity.Anime;
import jp.co.vermore.entity.EntryMail;
import jp.co.vermore.entity.Pic;
import jp.co.vermore.form.admin.AnimeForm;
import jp.co.vermore.form.admin.AnimeListForm;
import jp.co.vermore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
public class AdminAnimeController extends BaseController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private AWSService awsService;

    @Autowired
    private PicService picService;

    @Autowired
    PlatformTransactionManager txManager;

    @RequestMapping(value = "/admin/anime/list/", method = RequestMethod.GET)
    public String animeAll(Model model,HttpServletRequest request) {

        int errorCode = 0;
        if(!request.getSession().isNew()){
            if(request.getSession().getAttribute("error") != null && request.getSession().getAttribute("error") != ""){
                errorCode = (int)request.getSession().getAttribute("error");
                request.getSession().setAttribute("error",0);
            }
        }
        model.addAttribute("errorCode", errorCode);

        List<Anime> anime = animeService.getAnimeAll();
        AnimeForm form = new AnimeForm();
        model.addAttribute("animeDeleteForm", form);
        model.addAttribute("anime_all", anime);
        return "admin/animeList";
    }

    @RequestMapping(value = "/admin/anime/list/", method = RequestMethod.POST)
    @ResponseBody
    public DatatablesJsonObject animeList(@RequestBody AnimeListForm form){
        logger.debug("----1----");
        // set order statement
        if(form.getOrder().size() > 0
                && form.getColumns().get(form.getOrder().get(0).getColumn()).getName() != null
                && form.getColumns().get(form.getOrder().get(0).getColumn()).getName().length() > 0){
            form.setOrderStatement(form.getColumns().get(form.getOrder().get(0).getColumn()).getName() + " " + form.getOrder().get(0).getDir());
            logger.debug("----2----order statement="+form.getOrderStatement());
        }else{
            form.setOrderStatement("id");
            logger.debug("----2----order statement="+form.getOrderStatement());
        }
        logger.debug("----3----");

        // query data
        List<Anime> dataList = animeService.getAnimeAllByCondition(form);

        for(Anime anime:dataList){
            int type =0;
            //it's my faults
            if(anime.getType() == Constant.ANIME_TYPE.SERIALIZATION){
                type =  Constant.ANIME_TYPE.SERIALIZATION;
            }else if(anime.getType() == Constant.ANIME_TYPE.END){
                type = Constant.ANIME_TYPE.END;
            }
            EntryMail entity = entryService.getEntryMailByEntryIdAndType( anime.getId(),type);
            if(entity != null){
                anime.setEntryType(1);
            }else{
                anime.setEntryType(0);
            }
        }

        int totalCountFiltered = animeService.getAnimeCountByCondition(form);
        int totalCount = animeService.getAnimeCount();
        logger.debug("----4----data count="+dataList.size());
        logger.debug("----5----total filtered="+totalCountFiltered);
        logger.debug("----6----total count="+totalCount);
        logger.debug("----7----page="+form.getDraw());

        // return json data
        DatatablesJsonObject jsonparse = new DatatablesJsonObject();
        jsonparse.setDraw(form.getDraw());
        jsonparse.setRecordsFiltered(totalCountFiltered);
        jsonparse.setRecordsTotal(totalCount);
        jsonparse.setData(dataList);
        logger.debug("----8----");
        return jsonparse;
    }

    @RequestMapping(value = "/admin/anime/regist/", method = RequestMethod.GET)
    public String animeInsert(Model model) {
        AnimeForm form = new AnimeForm();
        model.addAttribute("animeForm", form);
        return "admin/animeRegist";
    }

    @RequestMapping(value = "/admin/anime/regist/", method = RequestMethod.POST)
    public String animeInsert(@ModelAttribute AnimeForm form ,HttpServletRequest request) {
        HttpSession session = request.getSession();
        // トランザクション管理の開始
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        try {
            long animeId = animeService.insertAnime(form);
            animeService.insertDetailAnime(form,animeId);
            MultipartFile[] top = form.getPicFile1();
            MultipartFile[] foot = form.getPicFile2();

            if(!form.getPicFile1()[0].isEmpty()) {
                Pic topPic = new Pic();
                if (top.length>0) {
                    for(int i = 0 ; i < top.length; i++){
                        topPic.setPicUrl(awsService.postFile(top[i]));
                        topPic.setItemId(animeId);
                        topPic.setItemType(Constant.EVENT_PIC_TYPE.ANIME_TOP);
                        picService.insertPic(topPic);
                    }
                }
            }

            if(!form.getPicFile2()[0].isEmpty()) {
                Pic footPic = new Pic();
                if (foot.length>0) {
                    for(int i = 0 ; i < foot.length; i++){
                        footPic.setPicUrl(awsService.postFile(foot[i]));
                        footPic.setItemId(animeId);
                        footPic.setItemType(Constant.EVENT_PIC_TYPE.ANIME_FOOT);
                        picService.insertPic(footPic);
                    }
                }
            }

            txManager.commit(txStatus);
            session.setAttribute("error",0);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            session.setAttribute("error",1);
            logger.error("insert anime failed!, error=" + e.getMessage());
            logger.error("insert anime failed!, error=" + e.toString());
            e.printStackTrace();
        }
        return "redirect:/admin/anime/list/";
    }

    @RequestMapping(value = "/admin/anime/delete/", method = RequestMethod.POST)
    public String animeDetailDelete(@ModelAttribute AnimeForm form,HttpServletRequest request) {
        HttpSession session = request.getSession();
        // トランザクション管理の開始
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        try {
            animeService.deleteAnime(form);
            animeService.deleteDetailAnime(form);
            picService.deleteAnimePicUrl(form.getId(),Constant.EVENT_PIC_TYPE.ANIME_TOP);
            picService.deleteAnimePicUrl(form.getId(),Constant.EVENT_PIC_TYPE.ANIME_FOOT);
            txManager.commit(txStatus);
            session.setAttribute("error",0);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            session.setAttribute("error",1);
            logger.error("delete anime failed!, error=" + e.getMessage());
            logger.error("delete anime failed!, error=" + e.toString());
            e.printStackTrace();
        }
        return "redirect:/admin/anime/list/";
    }

    @RequestMapping(value = "/admin/anime/edit/{id}/", method = RequestMethod.GET)
    public String animeUpdate(Model model , @PathVariable long id) {
        AnimeForm animeForm = new AnimeForm();
        List<Anime> list = animeService.getAnimeList(id);
        String detail = animeService.getAnimeDetail(id);

        List<Pic> topPicList = picService.getPic(id,Constant.EVENT_PIC_TYPE.ANIME_TOP);
        List<String> topList = new ArrayList<String>();
        for(Pic pic:topPicList){
            topList.add(pic.getPicUrl());
        }

        List<Pic> footPicList = picService.getPic(id,Constant.EVENT_PIC_TYPE.ANIME_FOOT);
        List<String> footList = new ArrayList<String>();
        for(Pic pic:footPicList){
            footList.add(pic.getPicUrl());
        }

        animeForm.setPicUrl1(topList);
        animeForm.setPicUrl2(footList);

        if(list != null && list.size() > 0){
            animeForm.setId(list.get(0).getId());
            animeForm.setDetail(detail);
            animeForm.setTitle(list.get(0).getTitle());
            animeForm.setType(list.get(0).getType());
            animeForm.setExcerpt(list.get(0).getExcerpt());
            animeForm.setPublishStart(DateUtil.dateToStringyyyy_MM_dd_HH_mm(list.get(0).getPublishStart()));
            animeForm.setPublishEnd(DateUtil.dateToStringyyyy_MM_dd_HH_mm(list.get(0).getPublishEnd()));
            String date = DateUtil.dateToStringyyyy_MM_dd_HH_mm(list.get(0).getDate());
            animeForm.setDate(date);
            animeForm.setSortScore(list.get(0).getSortScore());

            model.addAttribute("animeForm", animeForm);
            return "admin/animeEdit";
        }else {
            return "redirect:/admin/anime/list/";
        }
    }

    @RequestMapping(value = "/admin/anime/update/", method = RequestMethod.POST)
    public String animeUpdate1(@ModelAttribute AnimeForm form,HttpServletRequest request) {
        HttpSession session = request.getSession();
        // トランザクション管理の開始
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        try {
            List<String> picUrl1 = form.getPicUrl1();
            animeService.updateAnime(form);
            animeService.updateDetailAnime(form);

            if(form.getPicUrl1().size()==0 && form.getPicFile1()[0].isEmpty()){
                picService.deleteAnimePicUrl(form.getId(),Constant.EVENT_PIC_TYPE.ANIME_TOP);
            }

            if(form.getPicUrl2().size()==0 && form.getPicFile2()[0].isEmpty()){
                picService.deleteAnimePicUrl(form.getId(),Constant.EVENT_PIC_TYPE.ANIME_FOOT);
            }

            if(!form.getPicFile1()[0].isEmpty()) {
                picService.deleteAnimePicUrl(form.getId(),Constant.EVENT_PIC_TYPE.ANIME_TOP);
                MultipartFile[] top = form.getPicFile1();
                Pic topPic = new Pic();
                if (top.length>0) {
                    for(int i = 0 ; i < top.length; i++){
                        topPic.setPicUrl(awsService.postFile(top[i]));
                        topPic.setItemId(form.getId());
                        topPic.setItemType(Constant.EVENT_PIC_TYPE.ANIME_TOP);
                        picService.insertPic(topPic);
                    }
                }
            }

            if(!form.getPicFile2()[0].isEmpty()){
                picService.deleteAnimePicUrl(form.getId(),Constant.EVENT_PIC_TYPE.ANIME_FOOT);
                MultipartFile[] foot = form.getPicFile2();
                Pic footPic = new Pic();
                if (foot.length>0) {
                    for(int i = 0 ; i < foot.length; i++){
                        footPic.setPicUrl(awsService.postFile(foot[i]));
                        footPic.setItemId(form.getId());
                        footPic.setItemType(Constant.EVENT_PIC_TYPE.ANIME_FOOT);
                        picService.insertPic(footPic);
                    }
                }
            }

            txManager.commit(txStatus);
            session.setAttribute("error",0);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            session.setAttribute("error",1);
            logger.error("update anime failed!, error=" + e.getMessage());
            logger.error("update anime failed!, error=" + e.toString());
            e.printStackTrace();
        }
        return "redirect:/admin/anime/list/";
    }
}
