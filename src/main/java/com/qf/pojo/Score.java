package com.qf.pojo;

public class Score {
    private int scid;
    private Student student;
    private Class aclass;
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

    public Class getAclass() {
        return aclass;
    }

    public void setAclass(Class aclass) {
        this.aclass = aclass;
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

    public Score(int scid, Student student, Class aclass, Kecheng kecheng, String jieduan, int score) {
        this.scid = scid;
        this.student = student;
        this.aclass = aclass;
        this.kecheng = kecheng;
        this.jieduan = jieduan;
        this.score = score;
    }

    public Score() {
    }

    public Score(Student student, Class aclass, Kecheng kecheng, String jieduan, int score) {
        this.student = student;
        this.aclass = aclass;
        this.kecheng = kecheng;
        this.jieduan = jieduan;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scid=" + scid +
                ", student=" + student +
                ", aclass=" + aclass +
                ", kecheng=" + kecheng +
                ", jieduan='" + jieduan + '\'' +
                ", score=" + score +
                '}';
    }
}





