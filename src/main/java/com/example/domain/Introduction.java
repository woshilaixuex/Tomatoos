package com.example.domain;


/**
 * 简介
 */
public class Introduction {
    private String num;
    private String username;
    private String email;
    private String message;
    private String ava_image;
    private String back_image;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage(String s) {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAva_image() {
        return ava_image;
    }

    public void setAva_image(String ava_image) {
        this.ava_image = ava_image;
    }

    public String getBack_image() {
        return back_image;
    }

    public void setBack_image(String back_image) {
        this.back_image = back_image;
    }

    @Override
    public String toString() {
        return "Introduction{" +
                "num='" + num + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", ava_image='" + ava_image + '\'' +
                ", back_image='" + back_image + '\'' +
                '}';
    }
}
