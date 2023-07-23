package com.example.domain;

/**
 * 个人账户
 */
public class User {
    private String id;
    private String username;
    private Integer account;
    private String password;

    public User(String id, String username, Integer account, String password) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", account=" + account +
                ", password='" + password + '\'' +
                '}';
    }
}
