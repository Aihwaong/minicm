package com.aihwaong.minicm.model;

import java.util.Date;

public class HouseholdAccount {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_account.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_account.account
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String account;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_account.password
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_account.household_info_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer householdInfoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_account.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_account.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_account.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_household_account.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_account.id
     *
     * @return the value of cm_household_account.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_account.id
     *
     * @param id the value for cm_household_account.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_account.account
     *
     * @return the value of cm_household_account.account
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_account.account
     *
     * @param account the value for cm_household_account.account
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_account.password
     *
     * @return the value of cm_household_account.password
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_account.password
     *
     * @param password the value for cm_household_account.password
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_account.household_info_id
     *
     * @return the value of cm_household_account.household_info_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getHouseholdInfoId() {
        return householdInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_account.household_info_id
     *
     * @param householdInfoId the value for cm_household_account.household_info_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setHouseholdInfoId(Integer householdInfoId) {
        this.householdInfoId = householdInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_account.status
     *
     * @return the value of cm_household_account.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_account.status
     *
     * @param status the value for cm_household_account.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_account.create_time
     *
     * @return the value of cm_household_account.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_account.create_time
     *
     * @param createTime the value for cm_household_account.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_account.update_time
     *
     * @return the value of cm_household_account.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_account.update_time
     *
     * @param updateTime the value for cm_household_account.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_household_account.is_delete
     *
     * @return the value of cm_household_account.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_household_account.is_delete
     *
     * @param isDelete the value for cm_household_account.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}