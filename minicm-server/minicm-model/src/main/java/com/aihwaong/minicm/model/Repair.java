package com.aihwaong.minicm.model;

import java.util.Date;

public class Repair {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_repair.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_repair.repair_type_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer repairTypeId;

    private String repairTypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_repair.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_repair.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_repair.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_repair.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_repair.description
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String description;

    public String getRepairTypeName() {
        return repairTypeName;
    }

    public void setRepairTypeName(String repairTypeName) {
        this.repairTypeName = repairTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_repair.id
     *
     * @return the value of cm_repair.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_repair.id
     *
     * @param id the value for cm_repair.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_repair.repair_type_id
     *
     * @return the value of cm_repair.repair_type_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getRepairTypeId() {
        return repairTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_repair.repair_type_id
     *
     * @param repairTypeId the value for cm_repair.repair_type_id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setRepairTypeId(Integer repairTypeId) {
        this.repairTypeId = repairTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_repair.create_time
     *
     * @return the value of cm_repair.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_repair.create_time
     *
     * @param createTime the value for cm_repair.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_repair.update_time
     *
     * @return the value of cm_repair.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_repair.update_time
     *
     * @param updateTime the value for cm_repair.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_repair.status
     *
     * @return the value of cm_repair.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_repair.status
     *
     * @param status the value for cm_repair.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_repair.is_delete
     *
     * @return the value of cm_repair.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_repair.is_delete
     *
     * @param isDelete the value for cm_repair.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_repair.description
     *
     * @return the value of cm_repair.description
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_repair.description
     *
     * @param description the value for cm_repair.description
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}