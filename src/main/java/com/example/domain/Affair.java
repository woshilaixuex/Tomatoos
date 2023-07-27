package com.example.domain;

import java.util.Date;

/**
 * 事务
 *
 */
public class Affair {
    private Integer id;
    private String A_name;
    private String num;
    private Integer open;
    private Date o_time;

    public Integer getId() {
        return id;
    }

    public String getA_name() {
        return A_name;
    }

    public String getNum() {
        return num;
    }

    public Integer getOpen() {
        return open;
    }

    public Date getO_time() {
        return o_time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setA_name(String a_name) {
        A_name = a_name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public void setO_time(Date o_time) {
        this.o_time = o_time;
    }

    @Override
    public String toString() {
        return "Affair{" +
                "id='" + id + '\'' +
                ", A_name='" + A_name + '\'' +
                ", num='" + num + '\'' +
                ", open=" + open +
                ", o_time=" + o_time +
                '}';
    }
}
