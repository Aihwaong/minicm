package com.aihwaong.minicm.model;

import java.util.Date;
import java.util.List;

public class BuildingArea {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_building_area.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_building_area.pid
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Integer pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_building_area.area_name
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String areaName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_building_area.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_building_area.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_building_area.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_building_area.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    private String isDelete;

    private List<BuildingArea> children;

    public List<BuildingArea> getChildren() {
        return children;
    }

    public void setChildren(List<BuildingArea> children) {
        this.children = children;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_building_area.id
     *
     * @return the value of cm_building_area.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_building_area.id
     *
     * @param id the value for cm_building_area.id
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_building_area.pid
     *
     * @return the value of cm_building_area.pid
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_building_area.pid
     *
     * @param pid the value for cm_building_area.pid
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_building_area.area_name
     *
     * @return the value of cm_building_area.area_name
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_building_area.area_name
     *
     * @param areaName the value for cm_building_area.area_name
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_building_area.create_time
     *
     * @return the value of cm_building_area.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_building_area.create_time
     *
     * @param createTime the value for cm_building_area.create_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_building_area.update_time
     *
     * @return the value of cm_building_area.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_building_area.update_time
     *
     * @param updateTime the value for cm_building_area.update_time
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_building_area.status
     *
     * @return the value of cm_building_area.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_building_area.status
     *
     * @param status the value for cm_building_area.status
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_building_area.is_delete
     *
     * @return the value of cm_building_area.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_building_area.is_delete
     *
     * @param isDelete the value for cm_building_area.is_delete
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}