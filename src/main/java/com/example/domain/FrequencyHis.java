package com.example.domain;

import java.util.Date;

public class FrequencyHis {
    private  Integer id;
    private  String num;
    private  Date date;
    private String username;

    public FrequencyHis(Integer id, String num, Date date, String username) {
        this.id = id;
        this.num = num;
        this.date = date;
        this.username = username;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public Date getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }
}
