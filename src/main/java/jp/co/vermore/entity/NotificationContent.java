package jp.co.vermore.entity;

import java.util.Date;

public class NotificationContent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_content.id
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_content.title
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_content.content
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_content.create_datetime
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    private Date createDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_content.update_datetime
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    private Date updateDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_content.del_flg
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    private Boolean delFlg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_content.note
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_content.id
     *
     * @return the value of notification_content.id
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_content.id
     *
     * @param id the value for notification_content.id
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_content.title
     *
     * @return the value of notification_content.title
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_content.title
     *
     * @param title the value for notification_content.title
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_content.content
     *
     * @return the value of notification_content.content
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_content.content
     *
     * @param content the value for notification_content.content
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_content.create_datetime
     *
     * @return the value of notification_content.create_datetime
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_content.create_datetime
     *
     * @param createDatetime the value for notification_content.create_datetime
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_content.update_datetime
     *
     * @return the value of notification_content.update_datetime
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_content.update_datetime
     *
     * @param updateDatetime the value for notification_content.update_datetime
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_content.del_flg
     *
     * @return the value of notification_content.del_flg
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public Boolean getDelFlg() {
        return delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_content.del_flg
     *
     * @param delFlg the value for notification_content.del_flg
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_content.note
     *
     * @return the value of notification_content.note
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_content.note
     *
     * @param note the value for notification_content.note
     *
     * @mbggenerated Wed Apr 18 18:28:51 CST 2018
     */
    public void setNote(String note) {
        this.note = note;
    }
}