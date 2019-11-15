package com.qf.service;

public interface UserService {

    public String getUpwdByUname(String uname);

    public String getRoleByUname(String uname);
   // public  String getsalt(String username);
   public int editupwd(String upwd,String uname);

    public String getRoleByRoleId(int roleid);

}
