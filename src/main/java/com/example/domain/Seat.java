package com.example.domain;

/**
 * 座位
 */
public class Seat  {
    private Integer id;
    private Integer state;
    private Integer attributes;
    private String a_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAttributes() {
        return attributes;
    }

    public void setAttributes(Integer attributes) {
        this.attributes = attributes;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }
}
