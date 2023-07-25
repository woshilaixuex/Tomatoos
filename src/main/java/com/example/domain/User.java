package com.example.domain;

/**
 * 个人账户
 */
public class User {
    private String num;
    private Integer account;
    private String password;

    public User(String num, Integer account, String password) {
        this.num = num;
        this.account = account;
        this.password = password;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "num='" + num + '\'' +
                ", account=" + account +
                ", password='" + password + '\'' +
                '}';
    }
}
