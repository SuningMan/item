package com.kuang.edu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统日志(Log)实体类
 *
 * @author makejava
 * @since 2020-05-08 11:15:16
 */
public class Log implements Serializable {
    private static final long serialVersionUID = -38476938671830516L;
    
    private Long id;
    
    private Date createTime;
    
    private String description;
    
    private String exceptionDetail;
    
    private String logType;
    
    private String method;
    
    private String params;
    
    private String requestIp;
    
    private Long time;
    
    private String username;
    
    private String address;
    
    private String browser;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

}