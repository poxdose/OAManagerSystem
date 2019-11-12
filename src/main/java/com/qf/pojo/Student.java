package com.qf.pojo;

public class Student {
    private int sid;
    private String sname;
    private int sage;
    private String ssex;
    private int cid;

    public Student(int sid, String sname, int cid) {
        this.sid = sid;
        this.sname = sname;
        this.cid = cid;
    }

    public Student(int sid, String sname, int sage, String ssex, int cid) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.cid = cid;
    }

    public Student() {
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", cid=" + cid +
                '}';
    }
}





