package com.xiexin.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AdminInfo {
    private String adminName;
    //因为前端传来的参数是个字符串 ， 所以这里要做个类型转换，之前校区学的是 xml配置
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adminTime;
    private String adminPwd;
    private List<Lover> loverList;
    private Integer[] aiHao; //1.写代码 2.看书 3.读报纸

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminName='" + adminName + '\'' +
                ", adminTime=" + adminTime +
                ", adminPwd='" + adminPwd + '\'' +
                ", loverList=" + loverList +
                ", aiHao=" + Arrays.toString(aiHao) +
                '}';
    }

    public Integer[] getAiHao() {
        return aiHao;
    }

    public void setAiHao(Integer[] aiHao) {
        this.aiHao = aiHao;
    }

    public List<Lover> getLoverList() {
        return loverList;
    }

    public void setLoverList(List<Lover> loverList) {
        this.loverList = loverList;
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
