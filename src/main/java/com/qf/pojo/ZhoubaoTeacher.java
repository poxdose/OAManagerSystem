package com.qf.pojo;

/*
pojo类周报的拓展用于Teacher查找周报及学生信息
 */
public class ZhoubaoTeacher {
    private int zid;
    private int sid;
    private String zbiaoti;
    private String datetime;
    private String text;
    private int score;
    private Student student;

    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getZbiaoti() {
        return zbiaoti;
    }

    public void setZbiaoti(String zbiaoti) {
        this.zbiaoti = zbiaoti;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ZhoubaoTeacher(int zid, int sid, String zbiaoti, String datetime, String text, int score, Student student) {
        this.zid = zid;
        this.sid = sid;
        this.zbiaoti = zbiaoti;
        this.datetime=datetime;
        this.text = text;
        this.score = score;
        this.student = student;
    }

    public ZhoubaoTeacher() {
    }

    @Override
    public String toString() {
        return "ZhoubaoTeacher{" +
                "zid=" + zid +
                ", sid=" + sid +
                ", zbiaoti='" + zbiaoti + '\'' +
                ", datetime='" + datetime + '\'' +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", student=" + student +
                '}';
    }
}
