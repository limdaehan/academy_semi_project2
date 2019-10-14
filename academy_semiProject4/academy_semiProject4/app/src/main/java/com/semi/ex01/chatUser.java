package com.semi.ex01;

public class chatUser {

    private String listid;
    private String userid;

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public chatUser(String listid, String userid) {
        this.listid = listid;
        this.userid = userid;
    }
}
