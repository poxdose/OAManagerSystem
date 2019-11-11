package com.qf.pojo;

public class User {
    private int uid;
    private String uname;
    private String upwd;
    private int role_id;

    public User(int uid, String uname, String upwd, int role_id) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.role_id = role_id;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}

