package com.xiexin.bean;

public class Dog {
    private int dadId;
    private String dogSex;

    @Override
    public String toString() {
        return "Dog{" +
                "dadId=" + dadId +
                ", dogSex='" + dogSex + '\'' +
                '}';
    }

    public int getDadId() {
        return dadId;
    }

    public void setDadId(int dadId) {
        this.dadId = dadId;
    }

    public String getDogSex() {
        return dogSex;
    }

    public void setDogSex(String dogSex) {
        this.dogSex = dogSex;
    }
}
