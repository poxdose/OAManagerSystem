package com.qf.pojo;

public class
Teacher {
    private int tid;
    private String tname;
    private int tage;
    private String tsex;
    private int roel_id;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tage=" + tage +
                ", tsex='" + tsex + '\'' +
                ", roel_id=" + roel_id +
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

    public int getRoel_id() {
        return roel_id;
    }

    public void setRoel_id(int roel_id) {
        this.roel_id = roel_id;
    }

    public Teacher(int tid, String tname, int tage, String tsex, int roel_id) {
        this.tid = tid;
        this.tname = tname;
        this.tage = tage;
        this.tsex = tsex;
        this.roel_id = roel_id;
    }

    public Teacher() {
    }
}




