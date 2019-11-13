package com.qf.pojo;

public class Score {
    private int scid;
    private Student student;
    private Clazz clazz;
    private Kecheng kecheng;
    private String jieduan;
    private int score;

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Kecheng getKecheng() {
        return kecheng;
    }

    public void setKecheng(Kecheng kecheng) {
        this.kecheng = kecheng;
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

    public Score() {
    }

    public Score(int scid, Student student, Clazz clazz, Kecheng kecheng, String jieduan, int score) {
        this.scid = scid;
        this.student = student;
        this.clazz = clazz;
        this.kecheng = kecheng;
        this.jieduan = jieduan;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scid=" + scid +
                ", student=" + student +
                ", clazz=" + clazz +
                ", kecheng=" + kecheng +
                ", jieduan='" + jieduan + '\'' +
                ", score=" + score +
                '}';
    }

    public Score(Student student, Clazz clazz, Kecheng kecheng, String jieduan, int score) {
        this.student = student;
        this.clazz = clazz;
        this.kecheng = kecheng;
        this.jieduan = jieduan;
        this.score = score;
    }
}





