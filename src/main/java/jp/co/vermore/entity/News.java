package jp.co.vermore.entity;

import jp.co.vermore.common.mvc.BaseEntity;

import java.util.Date;

public class News extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.id
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.uuid
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private String uuid;



    private Integer entryType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.date
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.type
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private Byte type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.title
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.excerpt
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private String excerpt;

    private int sortScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.publish_start
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private Date publishStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.publish_end
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private Date publishEnd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.create_datetime
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private Date createDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.update_datetime
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private Date updateDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.del_flg
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private Boolean delFlg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.note
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.id
     *
     * @return the value of news.id
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.id
     *
     * @param id the value for news.id
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.uuid
     *
     * @return the value of news.uuid
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.uuid
     *
     * @param uuid the value for news.uuid
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.date
     *
     * @return the value of news.date
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */

    public Integer getEntryType() {
        return entryType;
    }

    public void setEntryType(Integer entryType) {
        this.entryType = entryType;
    }

    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.date
     *
     * @param date the value for news.date
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.type
     *
     * @return the value of news.type
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.type
     *
     * @param type the value for news.type
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.title
     *
     * @return the value of news.title
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.title
     *
     * @param title the value for news.title
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.excerpt
     *
     * @return the value of news.excerpt
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public String getExcerpt() {
        return excerpt;
    }

    public int getSortScore() { return sortScore; }

    public void setSortScore(int sortScore) { this.sortScore = sortScore; }
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.excerpt
     *
     * @param excerpt the value for news.excerpt
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.publish_start
     *
     * @return the value of news.publish_start
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public Date getPublishStart() {
        return publishStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.publish_start
     *
     * @param publishStart the value for news.publish_start
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setPublishStart(Date publishStart) {
        this.publishStart = publishStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.publish_end
     *
     * @return the value of news.publish_end
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public Date getPublishEnd() {
        return publishEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.publish_end
     *
     * @param publishEnd the value for news.publish_end
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setPublishEnd(Date publishEnd) {
        this.publishEnd = publishEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.create_datetime
     *
     * @return the value of news.create_datetime
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.create_datetime
     *
     * @param createDatetime the value for news.create_datetime
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.update_datetime
     *
     * @return the value of news.update_datetime
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.update_datetime
     *
     * @param updateDatetime the value for news.update_datetime
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.del_flg
     *
     * @return the value of news.del_flg
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public Boolean getDelFlg() {
        return delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.del_flg
     *
     * @param delFlg the value for news.del_flg
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.note
     *
     * @return the value of news.note
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.note
     *
     * @param note the value for news.note
     *
     * @mbggenerated Wed Feb 28 15:42:55 CST 2018
     */
    public void setNote(String note) {
        this.note = note;
    }
}