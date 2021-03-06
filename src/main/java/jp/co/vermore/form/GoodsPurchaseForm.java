package jp.co.vermore.form;

import jp.co.vermore.common.mvc.BaseForm;

import java.util.Date;

public class GoodsPurchaseForm extends BaseForm {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.id
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Integer id;

    private  Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.goods_id
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Integer goodsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.size
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Byte size;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.price
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Integer price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.quantity
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.status
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.create_datetime
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Date createDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.update_datetime
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Date updateDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.del_flg
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private Boolean delFlg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_purchase.note
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.id
     *
     * @return the value of goods_purchase.id
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.id
     *
     * @param id the value for goods_purchase.id
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.goods_id
     *
     * @return the value of goods_purchase.goods_id
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.goods_id
     *
     * @param goodsId the value for goods_purchase.goods_id
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.size
     *
     * @return the value of goods_purchase.size
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Byte getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.size
     *
     * @param size the value for goods_purchase.size
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setSize(Byte size) {
        this.size = size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.price
     *
     * @return the value of goods_purchase.price
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.price
     *
     * @param price the value for goods_purchase.price
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.quantity
     *
     * @return the value of goods_purchase.quantity
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.quantity
     *
     * @param quantity the value for goods_purchase.quantity
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.status
     *
     * @return the value of goods_purchase.status
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.status
     *
     * @param status the value for goods_purchase.status
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.create_datetime
     *
     * @return the value of goods_purchase.create_datetime
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.create_datetime
     *
     * @param createDatetime the value for goods_purchase.create_datetime
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.update_datetime
     *
     * @return the value of goods_purchase.update_datetime
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.update_datetime
     *
     * @param updateDatetime the value for goods_purchase.update_datetime
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.del_flg
     *
     * @return the value of goods_purchase.del_flg
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public Boolean getDelFlg() {
        return delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.del_flg
     *
     * @param delFlg the value for goods_purchase.del_flg
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_purchase.note
     *
     * @return the value of goods_purchase.note
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_purchase.note
     *
     * @param note the value for goods_purchase.note
     *
     * @mbggenerated Tue Mar 06 17:20:28 CST 2018
     */
    public void setNote(String note) {
        this.note = note;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}