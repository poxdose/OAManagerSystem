package com.qf.pojo;

public class Zhoubao {
    private int zid;
    private int sid;
    private String zbiaoti;
    private String zdate;
    private String text;
    private int score;

    public Zhoubao(int zid, int sid, String zbiaoti, String zdate, String text, int score) {
        this.zid = zid;
        this.sid = sid;
        this.zbiaoti = zbiaoti;
        this.zdate = zdate;
        this.text = text;
        this.score = score;
    }

    public Zhoubao() {
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

    public String getZdate() {
        return zdate;
    }

    public void setZdate(String zdate) {
        this.zdate = zdate;
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

    @Override
    public String toString() {
        return "Zhoubao{" +
                "zid=" + zid +
                ", sid=" + sid +
                ", zbiaoti='" + zbiaoti + '\'' +
                ", zdate='" + zdate + '\'' +
                ", text='" + text + '\'' +
                ", score=" + score +
                '}';
    }
}




