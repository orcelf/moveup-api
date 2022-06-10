package jp.co.vermore.controller;

import jp.co.vermore.common.Constant;
import jp.co.vermore.common.JsonObject;
import jp.co.vermore.common.JsonStatus;
import jp.co.vermore.common.mvc.BaseController;
import jp.co.vermore.common.util.DateUtil;
import jp.co.vermore.entity.*;
import jp.co.vermore.jsonparse.AnimeDetailJsonParse;
import jp.co.vermore.jsonparse.AnimeJsonParse;
import jp.co.vermore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class AnimeController extends BaseController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private PicService picService;

    @Autowired
    private WidgetService widgetService;

    @Value(value = "${hosturl}")
    private String hosturl;

    @RequestMapping(value = "/api/anime/list/{type}/{limit}/{offset}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getAnimeList(@PathVariable int type,@PathVariable int limit, @PathVariable int offset) {
        List<Anime> list = animeService.getAnimeAll(type,limit, offset);
        List<Anime> countlist = animeService.getAnimeAllByType(type);
        List<AnimeJsonParse> ejpList = new ArrayList<>();
        ejpList = list(ejpList, list);
        Map<String,Object> map = new HashMap<>();
        map.put("animeList",ejpList);
        map.put("count",countlist.size());
        jsonObject.setResultList(map);
        return jsonObject;
    }

    @RequestMapping(value = "/api/anime/list/{type1}/{type2}/{limit}/{offset}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getAnimeEventList(@PathVariable int type1,@PathVariable int type2,@PathVariable int limit, @PathVariable int offset) {
        List<Anime> list = animeService.getAnimeEventAll(type1,type2,limit, offset);
        List<AnimeJsonParse> ejpList = new ArrayList<>();
        ejpList = list(ejpList, list);
        Map<String,Object> map = new HashMap<>();
        map.put("animeList",ejpList);
        map.put("count",ejpList.size());
        jsonObject.setResultList(map);
        return jsonObject;
    }

    @RequestMapping(value = "/api/anime/detail/{uuid}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getAnimeDetailList(@PathVariable String uuid) {
        Anime anime = animeService.getAnimeByUuid(uuid);
        List<AnimeDetailJsonParse> ejpList = new ArrayList<>();
        List<AnimeDetail> list = animeService.getAnimeDetailAll(anime.getId());
        AnimeDetailJsonParse ejp = new AnimeDetailJsonParse();
        if(list.size()>0){
            for (AnimeDetail ed: list) {
                ejp.setAnimeId(ed.getAnimeId());
                ejp.setTitle(ed.getTitle());
                ejp.setDate(DateUtil.dateToStringyyyy_MM_dd(ed.getDate()));
                ejp.setTypeStr(widgetService.getAnimeType(ed.getType()));
                ejp.setType(ed.getType());
                ejp.setColor(widgetService.getAnimeColor(ed.getType()));
                ejp.setDetail(ed.getDetail());

                Pic topPic = new Pic();
                List<Pic> topPicList = picService.getPic(ed.getAnimeId(), Constant.EVENT_PIC_TYPE.ANIME_TOP);
                List<String> topList = new ArrayList<String>();
                for(Pic pic:topPicList){
                    topList.add(pic.getPicUrl());
                }
                ejp.setTopPic(topList);

                List<Pic> footPicList = picService.getPic(ed.getAnimeId(),Constant.EVENT_PIC_TYPE.ANIME_FOOT);
                List<String> footList = new ArrayList<String>();
                for(Pic pic:footPicList){
                    footList.add(pic.getPicUrl());
                }
                ejp.setFootPic(footList);
                List<Anime> listPre = animeService.getAnimePre(ed.getDate());
                List<Anime> listNext = animeService.getAnimeNext(ed.getDate());
                List<AnimeJsonParse> ejpListPre = new ArrayList<>();
                List<AnimeJsonParse> ejpListNext = new ArrayList<>();
                ejpListPre = list(ejpListPre, listPre);
                ejpListNext = list(ejpListNext, listNext);
                if(listPre.size()>0){
                    ejpListPre.get(0).setColor(widgetService.getAnimeDetailColor(listPre.get(0).getType()));
                }
                if(listNext.size()>0){
                    ejpListNext.get(0).setColor(widgetService.getAnimeDetailColor(listNext.get(0).getType()));
                }
                ejp.setAnimePre(ejpListPre);
                ejp.setAnimeNext(ejpListNext);
                ejpList.add(ejp);
            }

            int type =0;
            if(anime.getType().equals(Constant.ANIME_TYPE.END)){
                type =  Constant.ANIME_TYPE.SERIALIZATION;
            }else if(anime.getType().equals(Constant.ANIME_TYPE.SERIALIZATION)){
                type = Constant.ANIME_TYPE.END;
            }

            EntryMail entryMail = entryService.getEntryMailByEntryIdAndType(anime.getId(),type);
            if(entryMail != null){
                Date startTime = entryMail.getPublishStart();
                Date endTime = entryMail.getPublishEnd();
                Date nowTime = new Date(System.currentTimeMillis());
                if(nowTime.getTime() >= startTime.getTime() && nowTime.getTime() <= endTime.getTime()){
                    ejp.setEntry("1");//応募可能
                }else{
                    ejp.setEntry(null);
                }
            }else {
                ejp.setEntry(null);
            }
            jsonObject.setResultList(ejpList);
        }else{
            jsonObject.setResultList(null);
        }
        return jsonObject;
    }

    private List<AnimeJsonParse> list(List<AnimeJsonParse> jpList, List<Anime> list) {

        for (Anime nd: list) {
            AnimeJsonParse njp = new AnimeJsonParse();
            njp.setUuid(nd.getUuid());
            njp.setTitle(nd.getTitle());
            njp.setDate(DateUtil.dateToStringyyyy_MM_dd(nd.getDate()));
            njp.setType(widgetService.getAnimeType(nd.getType()));
            njp.setColor(widgetService.getAnimeColor(nd.getType()));
            njp.setExcerpt(nd.getExcerpt());
            jpList.add(njp);
        }
        return jpList;
    }


    @RequestMapping(value = "/sns/animeDetail/{uuid}/", method = RequestMethod.GET)
    public Object getAnimeSNSDetail(@PathVariable String uuid, Model model, HttpServletRequest hsr) {

        Anime anime = animeService.getAnimeByUuid(uuid);
        List<AnimeDetail> animeDetailList = animeService.getAnimeDetailAll(anime.getId());
        if(animeDetailList.size()>0){
            AnimeDetail animeDetail = animeDetailList.get(0);

            model.addAttribute("title", animeDetail.getTitle());
            model.addAttribute("url", "https://www.japanmoveupwest.com" + "/animeDetail/" + anime.getUuid() + "/");
            model.addAttribute("desc",  anime.getExcerpt());
            model.addAttribute("image",  "");
        }
        
        String userAgent = hsr.getHeader("User-Agent");
        logger.debug("-------user-agent=" + userAgent);

        String regex = "facebookexternalhit|Facebot|Twitterbot|Pinterest|Google.*snippet";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(userAgent);
        if (m.find()) {
            logger.debug("-------tosns");
            return "sns";
        } else {
            logger.debug("-------tourl");
            return "redirect:"+ hosturl + "/animeDetail/" + uuid + "/";
        }
    }

    @RequestMapping(value = "/api/sns/animeDetail/app/{uuid}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getAnimeDetailSNSForApp(@PathVariable String uuid) {

        Map<String, Object> urlMap = new HashMap<String, Object>();
        urlMap.put("twitter","https://twitter.com/share?url="+hosturl+"/animeDetail/"+uuid+"/");
        urlMap.put("facebook","https://www.facebook.com/sharer/sharer.php?u="+hosturl+"/animeDetail/"+uuid+"/");

        jsonObject.setResultList(urlMap);
        jsonObject.setStatus(JsonStatus.SUCCESS);
        return jsonObject;
    }
}