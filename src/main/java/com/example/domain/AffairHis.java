package com.example.domain;

import java.util.Date;

/**
 * 事务历史
 */
public class AffairHis {
    private Integer id;
    private String num;
    private String a_name;
    private long time;
    private Date o_time;

    public AffairHis(String num, String a_name, long time, Date o_time) {
        this.num = num;
        this.a_name = a_name;
        this.time = time;
        this.o_time = o_time;
    }

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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Date getO_time() {
        return o_time;
    }

    public void setO_time(Date o_time) {
        this.o_time = o_time;
    }
}
