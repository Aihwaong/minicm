package com.aihwaong.minicm.model;

import java.util.Date;

public class ParkingSpaceRegistration {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_parking_space_registration.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_parking_space_registration.household_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer householdId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_parking_space_registration.parking_area_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer parkingLotId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_parking_space_registration.register_way
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String registerWay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_parking_space_registration.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_parking_space_registration.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_parking_space_registration.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_parking_space_registration.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_parking_space_registration.id
     *
     * @return the value of cm_parking_space_registration.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_parking_space_registration.id
     *
     * @param id the value for cm_parking_space_registration.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_parking_space_registration.household_id
     *
     * @return the value of cm_parking_space_registration.household_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_parking_space_registration.register_way
     *
     * @return the value of cm_parking_space_registration.register_way
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getRegisterWay() {
        return registerWay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_parking_space_registration.register_way
     *
     * @param registerWay the value for cm_parking_space_registration.register_way
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setRegisterWay(String registerWay) {
        this.registerWay = registerWay == null ? null : registerWay.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_parking_space_registration.create_time
     *
     * @return the value of cm_parking_space_registration.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_parking_space_registration.create_time
     *
     * @param createTime the value for cm_parking_space_registration.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_parking_space_registration.update_time
     *
     * @return the value of cm_parking_space_registration.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_parking_space_registration.update_time
     *
     * @param updateTime the value for cm_parking_space_registration.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_parking_space_registration.status
     *
     * @return the value of cm_parking_space_registration.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_parking_space_registration.status
     *
     * @param status the value for cm_parking_space_registration.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_parking_space_registration.is_delete
     *
     * @return the value of cm_parking_space_registration.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_parking_space_registration.is_delete
     *
     * @param isDelete the value for cm_parking_space_registration.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}