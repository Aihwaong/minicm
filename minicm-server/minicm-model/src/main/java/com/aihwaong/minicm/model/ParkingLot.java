package com.aihwaong.minicm.model;

import java.util.Date;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.cm.model
 * +-------------------------------------------------------
 * | @Title:
 * +-------------------------------------------------------
 * | @ProjectName:   minicm
 * +-------------------------------------------------------
 * | @Description:   功能描述
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/6/29 16:07
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
public class ParkingLot {

    private Integer id;

    private String number;

    private Integer parkingAreaId;

    private Long measure;

    private Byte business;

    private Date createTime;

    private Date updateTime;

    private Byte status;

    private String isDelete;

    private String areaName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getParkingAreaId() {
        return parkingAreaId;
    }

    public void setParkingAreaId(Integer parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }

    public Long getMeasure() {
        return measure;
    }

    public void setMeasure(Long measure) {
        this.measure = measure;
    }

    public Byte getBusiness() {
        return business;
    }

    public void setBusiness(Byte business) {
        this.business = business;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
