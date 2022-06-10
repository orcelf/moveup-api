package jp.co.vermore.mapper;

import jp.co.vermore.entity.Anime;
import jp.co.vermore.form.admin.AnimeListForm;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AnimeMapper {

    int insertAnime(Anime anime);

    int deleteAnime(Anime anime);

    int updateAnime(Anime anime);

    Anime getAnimeByUuid(String uuid);

    List<Anime> getAnimeAll();
    
    List<Anime> getAnimeAllForTop( String nowMin,String nextMin);

    List<Anime> getAnimeJsonAll(int type,String nowMin,String nextMin,int limit, int offset);

    List<Anime> getAnimeJsonAllByType(int type,String nowMin,String nextMin);

    Anime getAnimeByIdAndType(long id,int type);

    List<Anime> getAnimeEventAll(int type1,int type2,String tomorrow,String today,int limit, int offset);

    List<Anime> getAnimeList(long id);

    List<Anime> getAnimePre(Date date, String nowMin,String nextMin);

    List<Anime> getAnimeNext(Date date,String nowMin,String nextMin);

    List<Anime> getAnimeCategory(int type,int limit,int offset);

    List<Anime> getAnimeAllByCondition(AnimeListForm form);

    int getAnimeCountByCondition(AnimeListForm form);

    int getAnimeCount();

    List<Anime> getStudioAnimeList(int type, int sortScore, String tomorrow,String today);

    List<Anime> getStudioAnimeListAll(Byte type, int limit, int offset);

    List<Anime> getStudioAnimeALL(int type);

    List<Anime> getStudioAllByCondition(AnimeListForm form);

    int getStudioCountByCondition(AnimeListForm form);

    int getStudioCount();

    Anime getAnimeById(@Param("id") Long id);

}