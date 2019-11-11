package com.qf.pojo;

public class Holiday {
    private int hid;
    private int uid;
    private String startdate;
    private String enddate;
    private String reason;
    private int state;

    public Holiday(int hid, int uid, String startdate, String enddate, String reason, int state) {
        this.hid = hid;
        this.uid = uid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.reason = reason;
        this.state = state;
    }

    public Holiday() {
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "hid=" + hid +
                ", uid=" + uid +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                '}';
    }
}

