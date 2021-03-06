package jp.co.vermore.entity;

import jp.co.vermore.common.mvc.BaseEntity;

import java.util.Date;

public class Inquire extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.id
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.user_id
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.type
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private Byte type;


    private Byte status;


    private String typeStr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.mail
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private String mail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.first_name
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private String firstName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.second_name
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private String secondName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.contents
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private String contents;

    private String content;

    private String date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.create_datetime
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private Date createDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.update_datetime
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private Date updateDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.del_flg
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private Boolean delFlg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inquire.note
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    private String note;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.type
     *
     * @return the value of inquire.type
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.type
     *
     * @param type the value for inquire.type
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.mail
     *
     * @return the value of inquire.mail
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.mail
     *
     * @param mail the value for inquire.mail
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.first_name
     *
     * @return the value of inquire.first_name
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.first_name
     *
     * @param firstName the value for inquire.first_name
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.second_name
     *
     * @return the value of inquire.second_name
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.second_name
     *
     * @param secondName the value for inquire.second_name
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.contents
     *
     * @return the value of inquire.contents
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public String getContents() {
        return contents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.contents
     *
     * @param contents the value for inquire.contents
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.create_datetime
     *
     * @return the value of inquire.create_datetime
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.create_datetime
     *
     * @param createDatetime the value for inquire.create_datetime
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.update_datetime
     *
     * @return the value of inquire.update_datetime
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.update_datetime
     *
     * @param updateDatetime the value for inquire.update_datetime
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.del_flg
     *
     * @return the value of inquire.del_flg
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public Boolean getDelFlg() {
        return delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.del_flg
     *
     * @param delFlg the value for inquire.del_flg
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inquire.note
     *
     * @return the value of inquire.note
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inquire.note
     *
     * @param note the value for inquire.note
     *
     * @mbggenerated Wed Apr 04 18:10:40 CST 2018
     */
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}