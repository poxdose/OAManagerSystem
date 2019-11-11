package com.qf.pojo;

public class Role {
    private int role;
    private String roles;

    public Role(int role, String roles) {
        this.role = role;
        this.roles = roles;
    }

    public Role() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "role{" +
                "role=" + role +
                ", roles='" + roles + '\'' +
                '}';
    }
}





