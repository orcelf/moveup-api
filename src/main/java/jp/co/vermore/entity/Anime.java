package jp.co.vermore.entity;

import jp.co.vermore.common.mvc.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
public class Anime extends BaseEntity {
    private Long id;

    private String uuid;

    private Integer entryType;

    private Date date;

    private Byte type;

    private String title;

    private String excerpt;

    private int sortScore;

    private Date publishStart;

    private Date publishEnd;

    private Date createDatetime;

    private Date updateDatetime;

    private Boolean delFlg;

    private String note;
}