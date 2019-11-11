package com.qf.pojo;

public class Quanxian {
    private int qid;
    private int role_id;
    private String permission;

    public Quanxian(int qid, int role_id, String permission) {
        this.qid = qid;
        this.role_id = role_id;
        this.permission = permission;
    }

    public Quanxian() {
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Quanxian{" +
                "qid=" + qid +
                ", role_id=" + role_id +
                ", permission='" + permission + '\'' +
                '}';
    }
}


