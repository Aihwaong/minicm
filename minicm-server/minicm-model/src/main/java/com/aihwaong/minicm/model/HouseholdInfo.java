package com.aihwaong.minicm.model;

import java.util.Date;

public class HouseholdInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.real_name
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.identity_document
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String identityDocument;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.telephone
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String telephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.nation
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Byte nation;

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    private String nationName;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.remark
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_info.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.id
     *
     * @return the value of cm_household_info.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.id
     *
     * @param id the value for cm_household_info.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.real_name
     *
     * @return the value of cm_household_info.real_name
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.real_name
     *
     * @param realName the value for cm_household_info.real_name
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.identity_document
     *
     * @return the value of cm_household_info.identity_document
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getIdentityDocument() {
        return identityDocument;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.identity_document
     *
     * @param identityDocument the value for cm_household_info.identity_document
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument == null ? null : identityDocument.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.telephone
     *
     * @return the value of cm_household_info.telephone
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.telephone
     *
     * @param telephone the value for cm_household_info.telephone
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.nation
     *
     * @return the value of cm_household_info.nation
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Byte getNation() {
        return nation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.nation
     *
     * @param nation the value for cm_household_info.nation
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setNation(Byte nation) {
        this.nation = nation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.remark
     *
     * @return the value of cm_household_info.remark
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.remark
     *
     * @param remark the value for cm_household_info.remark
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.status
     *
     * @return the value of cm_household_info.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.status
     *
     * @param status the value for cm_household_info.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.create_time
     *
     * @return the value of cm_household_info.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.create_time
     *
     * @param createTime the value for cm_household_info.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.update_time
     *
     * @return the value of cm_household_info.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.update_time
     *
     * @param updateTime the value for cm_household_info.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_info.is_delete
     *
     * @return the value of cm_household_info.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_info.is_delete
     *
     * @param isDelete the value for cm_household_info.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}