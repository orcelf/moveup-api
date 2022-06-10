package jp.co.vermore.mapper;

import jp.co.vermore.entity.AnimeDetail;

import java.util.List;

public interface AnimeDetailMapper {

    int insertDetailAnime(AnimeDetail animeDetail);

    int deleteDetailAnime(AnimeDetail animeDetail);

    int updateDetailAnime(AnimeDetail animeDetail);

    String getAnimeDetail(long id);

    List<AnimeDetail> getAnimeDetailAll(Long id);

    AnimeDetail getStudioAnimeDetail(Long id);
}