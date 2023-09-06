package com.example.domain;

import java.util.Date;

/**
 * 事务
 *
 */
public class Affair {
    private Integer id;
    private String num;
    private String a_name;
    private long ReTime;
    private Date o_time;
    private Integer open;//0关1开

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public long getReTime() {
        return ReTime;
    }

    public void setReTime(long reTime) {
        ReTime = reTime;
    }

    public Date getO_time() {
        return o_time;
    }

    public void setO_time(Date o_time) {
        this.o_time = o_time;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Affair{" +
                "id='" + id + '\'' +
                ", A_name='" + a_name + '\'' +
                ", num='" + num + '\'' +
                ", open=" + open +
                ", o_time=" + o_time +
                '}';
    }
}
