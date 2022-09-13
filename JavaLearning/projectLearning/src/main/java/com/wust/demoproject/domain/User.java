package com.wust.demoproject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int id;

    @JsonProperty("USERNAME")//取别名，返回时显示该别名，后端获取JSon格式数据时，加上该标签后也只能获取USERNAME的属性
    private String username;

//    @JsonIgnore//过滤属性，免得显示给前端,后端获取JSon格式数据时，加上该标签会获取不到
    private String pwd;

    public User() {
    }

    public User(int id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
