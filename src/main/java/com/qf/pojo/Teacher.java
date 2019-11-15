package com.qf.pojo;

public class
Teacher {
    private int tid;
    private String tname;
    private int tage;
    private String tsex;
    private int role_id;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tage=" + tage +
                ", tsex='" + tsex + '\'' +
                ", role_id=" + role_id +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Teacher(int tid, String tname, int tage, String tsex, int role_id) {
        this.tid = tid;
        this.tname = tname;
        this.tage = tage;
        this.tsex = tsex;
        this.role_id = role_id;
    }

    public Teacher() {
    }
}




