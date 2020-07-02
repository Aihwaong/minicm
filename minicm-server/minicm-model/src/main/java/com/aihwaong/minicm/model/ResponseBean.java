package com.aihwaong.minicm.model;

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
 * | @date:          2020/6/17 22:41
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
public class ResponseBean {

    private Integer status;
    private String message;
    private Object object;

    private ResponseBean() {
    }

    public static ResponseBean buildResponseBean() {
        return new ResponseBean();
    }

    public ResponseBean success() {
        this.status = 200;
        this.message = "操作成功";
        this.object = null;
        return this;
    }

    public ResponseBean success(String message) {
        this.status = 200;
        this.message = message;
        this.object = null;
        return this;
    }

    public ResponseBean success(String message, Object object) {
        this.status = 200;
        this.message = message;
        this.object = object;
        return this;
    }

    public ResponseBean success(Integer status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
        return this;
    }

    public ResponseBean fail() {
        this.status = 500;
        this.message = "操作失败";
        this.object = null;
        return this;
    }

    public ResponseBean fail(String message) {
        this.status = 500;
        this.message = message;
        this.object = null;
        return this;
    }

    public ResponseBean fail(String message, Object object) {
        this.status = 500;
        this.message = message;
        this.object = object;
        return this;
    }

    public ResponseBean fail(Integer status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return object;
    }

    public ResponseBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public ResponseBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseBean setObject(Object object) {
        this.object = object;
        return this;
    }

}
