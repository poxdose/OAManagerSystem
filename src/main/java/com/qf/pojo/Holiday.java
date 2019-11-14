package com.qf.pojo;

public class Holiday {
    private int hid;
    private int uid;
    private String startdate;
    private String enddate;
    private String reason;
    private String tname;
    private int state;
    private User user;//假条申请人

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Holiday(int hid, int uid, String startdate, String enddate, String reason, int state, User user) {
        this.hid = hid;
        this.uid = uid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.reason = reason;
        this.state = state;
        this.user = user;
    }

    public Holiday(int hid, int uid, String startdate, String enddate, String reason, String tname, int state, User user) {
        this.hid = hid;
        this.uid = uid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.reason = reason;
        this.tname = tname;
        this.state = state;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
                ", user=" + user +
                '}';
    }
}





