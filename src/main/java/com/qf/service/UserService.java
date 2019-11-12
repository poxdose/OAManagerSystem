package com.qf.service;

public interface UserService {

    public String getUpwdByUname(String uname);

    public String getRoleByUname(String uname);
    public  String getsalt(String username);
}
