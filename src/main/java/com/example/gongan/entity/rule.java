package com.example.gongan.entity;

import java.util.Date;

public class rule {
    private String id;
    private String name; // 姓名
    private String idNumber; // 身份证号
    private String phone; // 手机号码
    private int status; // 是否需要打卡标识
    private String cycle; // 打卡频次 season month week
    private Date startTime; // 打卡开始时间
    private Date endTime; // 打卡结束时间

    private String geo; // 规定打卡范围
    private String face; // 身份证人脸信息

    public rule() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public rule(String id, String name, String idNumber, String phone, int status, String cycle, Date startTime, Date endTime, String geo, String face) {
        this.id = id;
        this.name = name;
        this.idNumber = idNumber;
        this.phone = phone;
        this.status = status;
        this.cycle = cycle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.geo = geo;
        this.face = face;
    }
}
