package com.qf.mapper;

public interface UserMapper {

    public String getUpwdByUname(String uname);

    public String getRoleByUname(String uname);

    //public  String getsalt(String username);
    public int editupwd(String upwd,String uname);
}
