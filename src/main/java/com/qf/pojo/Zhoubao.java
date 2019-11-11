package com.qf.pojo;

public class Zhoubao {
    private int zid;
    private int sid;
    private String zbiaoti;
    private String datetime;
    private String text;
    private int score;

    public Zhoubao(int zid, int sid, String zbiaoti, String datetime, String text, int score) {
        this.zid = zid;
        this.sid = sid;
        this.zbiaoti = zbiaoti;
        this.datetime = datetime;
        this.text = text;
        this.score = score;
    }

    public Zhoubao() {
    }

    @Override
    public String toString() {
        return "Zhoubao{" +
                "zid=" + zid +
                ", sid=" + sid +
                ", zbiaoti='" + zbiaoti + '\'' +
                ", datetime='" + datetime + '\'' +
                ", text='" + text + '\'' +
                ", score=" + score +
                '}';
    }

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
}
