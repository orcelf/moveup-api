package jp.co.vermore.service;

import jp.co.vermore.common.Constant;
import jp.co.vermore.common.util.DateUtil;
import jp.co.vermore.common.util.StringUtil;
import jp.co.vermore.entity.Anime;
import jp.co.vermore.entity.AnimeDetail;
import jp.co.vermore.form.admin.AnimeForm;
import jp.co.vermore.form.admin.AnimeListForm;
import jp.co.vermore.mapper.AnimeDetailMapper;
import jp.co.vermore.mapper.AnimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeMapper animeMapper;

    public Anime getAnimeByUuid(String uuid) {
        Anime entity = animeMapper.getAnimeByUuid(uuid);
        return entity;
    }

    public List<Anime> getAnimeAll() {
        List<Anime> animeList = animeMapper.getAnimeAll();
        return animeList;
    }

    public List<Anime> getAnimeAllForTop() {
        String nowMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Anime> animeList = animeMapper.getAnimeAllForTop(nowMin,nextMin);
        return animeList;
    }

    public List<Anime> getAnimeCategory(int type,int limit,int offset) {
        List<Anime> animeList = animeMapper.getAnimeCategory(type,limit,offset);
        return animeList;
    }

    public List<Anime>getAnimePre(Date date) {
        String nowMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Anime> anime = animeMapper.getAnimePre(date,nowMin,nextMin);
        return anime;
    }

    public List<Anime> getAnimeNext(Date date) {
        String nowMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Anime> anime = animeMapper.getAnimeNext(date,nowMin,nextMin);
        return anime;
    }

    public List<Anime> getAnimeAll(int type,int limit,int offset) {
        String nowMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Anime> animeList = animeMapper.getAnimeJsonAll(type,nowMin,nextMin,limit, offset);
        return animeList;
    }

    public List<Anime> getAnimeAllByType(int type) {
        String nowMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin= DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Anime> animeList = animeMapper.getAnimeJsonAllByType(type,nowMin,nextMin);
        return animeList;
    }

    public Anime getAnimeByIdAndType(long id,int type) {
        Anime anime = animeMapper.getAnimeByIdAndType(id,type);
        return anime;
    }

    public List<Anime> getAnimeEventAll(int type1,int type2,int limit,int offset) {
        String today = DateUtil.getYyyyMMdd();
        String tomorrow = DateUtil.getTomorrow();
        List<Anime> animeList = animeMapper.getAnimeEventAll(type1,type2,tomorrow,today,limit, offset);
        return animeList;
    }

    private List<Anime> convertTo(List<Anime> demoList) {
        List<Anime> resultList = new LinkedList<Anime>();
        for (Anime entity : demoList) {
            resultList.add(entity);
        }
        return resultList;
    }

    @Autowired
    private AnimeMapper addAnimeMapper;
    //TODO
    public long insertAnime(AnimeForm animeForm) {
        Anime anime = new Anime();
        String uuid = "";
        int flagUuid = 0;
        int cntSelect = 0;
        while (flagUuid != 1 && cntSelect < 100){
            uuid = StringUtil.getUuid();
            if (getAnimeByUuid(uuid) == null){
                flagUuid = 1;
            }
            cntSelect++;
        }

        anime.setUuid(uuid);
        String date = animeForm.getDate();
        anime.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T"," ")));
        anime.setTitle(animeForm.getTitle());
        anime.setType(animeForm.getType());
        anime.setSortScore(animeForm.getSortScore());
        anime.setExcerpt(animeForm.getExcerpt());
        if(animeForm.getPublishStart() == null || "".equals(animeForm.getPublishStart())){
            anime.setPublishStart(DateUtil.getDefaultDate());
        }else{
            anime.setPublishStart(DateUtil.stringToDateyyyy_MM_dd_HH_mm(animeForm.getPublishStart().replace("T"," ")));
        }
        if(animeForm.getPublishEnd() == null || "".equals(animeForm.getPublishEnd())){
            anime.setPublishEnd(DateUtil.getDefaultPublishEnd());
        }else{
            anime.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd_HH_mm(animeForm.getPublishEnd().replace("T"," ")));
        }
        anime.setCreateDatetime(new Date(System.currentTimeMillis()));
        anime.setDelFlg(Boolean.FALSE);
        anime.setNote(Constant.EMPTY_STRING);
        addAnimeMapper.insertAnime(anime);
        return anime.getId();
    }

    public long insertStudioAnime(AnimeForm animeForm) {
        Anime anime = new Anime();
        String uuid = "";
        int flagUuid = 0;
        int cntSelect = 0;
        while (flagUuid != 1 && cntSelect < 100){
            uuid = StringUtil.getUuid();
            if (getAnimeByUuid(uuid) == null){
                flagUuid = 1;
            }
            cntSelect++;
        }

        anime.setUuid(uuid);
        String date = animeForm.getDate();
        anime.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        anime.setTitle(animeForm.getTitle());
        anime.setType(animeForm.getType());
        anime.setSortScore(animeForm.getSortScore());
        anime.setExcerpt(animeForm.getExcerpt());
        if(animeForm.getPublishStart() == null || "".equals(animeForm.getPublishStart())){
            anime.setPublishStart(DateUtil.getDefaultDate());
        }else{
            anime.setPublishStart(DateUtil.stringToDateyyyy_MM_dd(animeForm.getPublishStart()));
        }
        if(animeForm.getPublishEnd() == null || "".equals(animeForm.getPublishEnd())){
            anime.setPublishEnd(DateUtil.getDefaultPublishEnd());
        }else{
            anime.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd(animeForm.getPublishEnd()));
        }
        anime.setCreateDatetime(new Date(System.currentTimeMillis()));
        anime.setDelFlg(Boolean.FALSE);
        anime.setNote(Constant.EMPTY_STRING);
        addAnimeMapper.insertAnime(anime);
        return anime.getId();
    }

    @Autowired
    private AnimeDetailMapper animeDetailMapper;

    public long insertDetailAnime(AnimeForm animeForm,long animeId) {
        AnimeDetail animeDetail = new AnimeDetail();
        animeDetail.setAnimeId(animeId);
        String date = animeForm.getDate();
        animeDetail.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T"," ")));
        animeDetail.setTitle(animeForm.getTitle());
        animeDetail.setType(animeForm.getType());
        animeDetail.setDetail(animeForm.getDetail());
        animeDetail.setCreateDatetime(new Date(System.currentTimeMillis()));
        animeDetail.setDelFlg(Boolean.FALSE);
        animeDetail.setNote(Constant.EMPTY_STRING);
        animeDetailMapper.insertDetailAnime(animeDetail);
        return animeDetail.getId();
    }

    public long insertDetailStudioAnime(AnimeForm animeForm,long animeId) {
        AnimeDetail animeDetail = new AnimeDetail();
        animeDetail.setAnimeId(animeId);
        String date = animeForm.getDate();
        animeDetail.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        animeDetail.setTitle(animeForm.getTitle());
        animeDetail.setType(animeForm.getType());
        animeDetail.setDetail(animeForm.getDetail());
        animeDetail.setCreateDatetime(new Date(System.currentTimeMillis()));
        animeDetail.setDelFlg(Boolean.FALSE);
        animeDetail.setNote(Constant.EMPTY_STRING);
        animeDetailMapper.insertDetailAnime(animeDetail);
        return animeDetail.getId();
    }

    public int deleteAnime(AnimeForm animeForm) {
        Anime anime = new Anime();
        anime.setId(animeForm.getId());
        anime.setDelFlg(Boolean.TRUE);
        int count = animeMapper.deleteAnime(anime);
        System.out.println(count);
        return count;
    }

    public int deleteDetailAnime(AnimeForm animeForm) {
        AnimeDetail animeDetail = new AnimeDetail();
        animeDetail.setAnimeId(animeForm.getId());
        animeDetail.setDelFlg(Boolean.TRUE);
        int count = animeDetailMapper.deleteDetailAnime(animeDetail);
        return count;
    }

    public int updateAnime(AnimeForm animeForm) {
        Anime anime = new Anime();
        anime.setId(animeForm.getId());
        String date = animeForm.getDate();
        anime.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T"," ")));
        anime.setTitle(animeForm.getTitle());
        anime.setType(animeForm.getType());
        anime.setSortScore(animeForm.getSortScore());
        anime.setExcerpt(animeForm.getExcerpt());
        if(animeForm.getPublishStart() == null || "".equals(animeForm.getPublishStart())){
            anime.setPublishStart(DateUtil.getDefaultDate());
        }else{
            anime.setPublishStart(DateUtil.stringToDateyyyy_MM_dd_HH_mm(animeForm.getPublishStart().replace("T"," ")));
        }
        if(animeForm.getPublishEnd() == null || "".equals(animeForm.getPublishEnd())){
            anime.setPublishEnd(DateUtil.getDefaultPublishEnd());
        }else{
            anime.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd_HH_mm(animeForm.getPublishEnd().replace("T"," ")));
        }
        anime.setUpdateDatetime(new Date(System.currentTimeMillis()));
        anime.setDelFlg(Boolean.FALSE);
        anime.setNote(Constant.EMPTY_STRING);
        int count = animeMapper.updateAnime(anime);
        return count;
    }

    public int updateStudioAnime(AnimeForm animeForm) {
        Anime anime = new Anime();
        anime.setId(animeForm.getId());
        String date = animeForm.getDate();
        anime.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        anime.setTitle(animeForm.getTitle());
        anime.setType(animeForm.getType());
        anime.setSortScore(animeForm.getSortScore());
        anime.setExcerpt(animeForm.getExcerpt());
        if(animeForm.getPublishStart() == null || "".equals(animeForm.getPublishStart())){
            anime.setPublishStart(DateUtil.getDefaultDate());
        }else{
            anime.setPublishStart(DateUtil.stringToDateyyyy_MM_dd(animeForm.getPublishStart()));
        }
        if(animeForm.getPublishEnd() == null || "".equals(animeForm.getPublishEnd())){
            anime.setPublishEnd(DateUtil.getDefaultPublishEnd());
        }else{
            anime.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd(animeForm.getPublishEnd()));
        }
        anime.setUpdateDatetime(new Date(System.currentTimeMillis()));
        anime.setDelFlg(Boolean.FALSE);
        anime.setNote(Constant.EMPTY_STRING);
        int count = animeMapper.updateAnime(anime);
        return count;
    }

    public int updateDetailAnime(AnimeForm animeForm) {
        AnimeDetail animeDetail = new AnimeDetail();
        animeDetail.setAnimeId(animeForm.getId());
        String date = animeForm.getDate();
        animeDetail.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T"," ")));
        animeDetail.setTitle(animeForm.getTitle());
        animeDetail.setType(animeForm.getType());
        animeDetail.setDetail(animeForm.getDetail());
        animeDetail.setUpdateDatetime(new Date(System.currentTimeMillis()));
        animeDetail.setDelFlg(Boolean.FALSE);
        animeDetail.setNote(Constant.EMPTY_STRING);
        int count = animeDetailMapper.updateDetailAnime(animeDetail);
        return count;
    }

    public int updateDetailStudioAnime(AnimeForm animeForm) {
        AnimeDetail animeDetail = new AnimeDetail();
        animeDetail.setAnimeId(animeForm.getId());
        String date = animeForm.getDate();
        animeDetail.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        animeDetail.setTitle(animeForm.getTitle());
        animeDetail.setType(animeForm.getType());
        animeDetail.setDetail(animeForm.getDetail());
        animeDetail.setUpdateDatetime(new Date(System.currentTimeMillis()));
        animeDetail.setDelFlg(Boolean.FALSE);
        animeDetail.setNote(Constant.EMPTY_STRING);
        int count = animeDetailMapper.updateDetailAnime(animeDetail);
        return count;
    }

    public List<Anime> getAnimeList(long id) {
        List<Anime> animeList = animeMapper.getAnimeList(id);
        return animeList;
    }

    public String getAnimeDetail(long id) {
        String detail = animeDetailMapper.getAnimeDetail(id);
        return detail;
    }

    public List<AnimeDetail> getAnimeDetailAll(Long id) {
        List<AnimeDetail> animeDetail = animeDetailMapper.getAnimeDetailAll(id);
        List<AnimeDetail> resultList = convertToDetail(animeDetail);
        return resultList;
    }

    private List<AnimeDetail> convertToDetail(List<AnimeDetail> demoList) {
        List<AnimeDetail> resultList = new LinkedList<AnimeDetail>();
        for (AnimeDetail entity : demoList) {
            resultList.add(entity);
        }
        return resultList;
    }

    public List<Anime> getAnimeAllByCondition(AnimeListForm form) {
        List<Anime> anime = animeMapper.getAnimeAllByCondition(form);
        return anime;
    }

    public int getAnimeCountByCondition(AnimeListForm form) {
        return animeMapper.getAnimeCountByCondition(form);
    }

    public int getAnimeCount() {
        return animeMapper.getAnimeCount();
    }

    public List<Anime> getStudioAnimeALL(int type) {
        List<Anime> anime = animeMapper.getStudioAnimeALL(type);
        return anime;
    }
}