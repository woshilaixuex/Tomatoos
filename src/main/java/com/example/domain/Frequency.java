package com.example.domain;

import java.util.Date;

/**
 * 打卡频率
 */
public class Frequency {
    private  Integer id;
    private String num;
    private int clock_f;
    private Date fre_time;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getClock_f() {
        return clock_f;
    }

    public void setClock_f(int clock_f) {
        this.clock_f = clock_f;
    }

    public Date getFre_time() {
        return fre_time;
    }

    public void setFre_time(Date fre_time) {
        this.fre_time = fre_time;
    }
}
