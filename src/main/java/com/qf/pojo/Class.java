package com.qf.pojo;

public class Class {
    private int cid;
    private String cname;
    private int kid;
    private int tid;


    public Class(int cid, String cname, int kid, int tid) {
        this.cid = cid;
        this.cname = cname;
        this.kid = kid;
        this.tid = tid;
    }

    public Class() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Class{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", kid=" + kid +
                ", tid=" + tid +
                '}';
    }
}




