package com.xiexin.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AdminInfo {
    private String adminName;
    //因为前端传来的参数是个字符串 ， 所以这里要做个类型转换，之前校区学的是 xml配置
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adminTime;
    private String adminPwd;

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminName='" + adminName + '\'' +
                ", adminTime=" + adminTime +
                ", adminPwd='" + adminPwd + '\'' +
                '}';
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(Date adminTime) {
        this.adminTime = adminTime;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }
}
