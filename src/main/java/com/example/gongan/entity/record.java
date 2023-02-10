package com.example.gongan.entity;

import java.util.Date;

public class record {
    private String id;
    private String idNumber; // 身份证号
    private Date time; // 打卡时间
    private String geo; // 位置信息
    private String face; // 人脸信息



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public record(String id, String idNumber, Date time, String geo, String face) {
        this.id = id;
        this.idNumber = idNumber;
        this.time = time;
        this.geo = geo;
        this.face = face;
    }
}
