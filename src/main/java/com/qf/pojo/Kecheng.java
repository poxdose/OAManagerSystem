package com.qf.pojo;

public class Kecheng {
    private int kid;
    private String kname;

    public Kecheng(int kid, String kname) {
        this.kid = kid;
        this.kname = kname;
    }

    public Kecheng() {
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    @Override
    public String toString() {
        return "Kecheng{" +
                "kid=" + kid +
                ", kname='" + kname + '\'' +
                '}';
    }
}




