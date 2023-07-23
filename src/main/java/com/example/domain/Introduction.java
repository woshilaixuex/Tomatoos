package com.example.domain;

import java.awt.image.BufferedImage;

/**
 * 简介
 */
public class Introduction {
    private String id;
    private String email;
    private String message;
    private BufferedImage ava_image;
    private BufferedImage back_image;

    public Introduction(String id, String email, String message, BufferedImage ava_image, BufferedImage back_image) {
        this.id = id;
        this.email = email;
        this.message = message;
        this.ava_image = ava_image;
        this.back_image = back_image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BufferedImage getAva_image() {
        return ava_image;
    }

    public void setAva_image(BufferedImage ava_image) {
        this.ava_image = ava_image;
    }

    public BufferedImage getBack_image() {
        return back_image;
    }

    public void setBack_image(BufferedImage back_image) {
        this.back_image = back_image;
    }
}
