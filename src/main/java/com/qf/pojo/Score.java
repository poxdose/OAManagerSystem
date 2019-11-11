package com.qf.pojo;

public class Score {
    private int scid;
    private int sid;
    private int cid;
    private int kid;
    private String jieduan;
    private int score;

    public Score(int scid, int sid, int cid, int kid, String jieduan, int score) {
        this.scid = scid;
        this.sid = sid;
        this.cid = cid;
        this.kid = kid;
        this.jieduan = jieduan;
        this.score = score;
    }

    public Score() {
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getJieduan() {
        return jieduan;
    }

    public void setJieduan(String jieduan) {
        this.jieduan = jieduan;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scid=" + scid +
                ", sid=" + sid +
                ", cid=" + cid +
                ", kid=" + kid +
                ", jieduan='" + jieduan + '\'' +
                ", score=" + score +
                '}';
    }
}




