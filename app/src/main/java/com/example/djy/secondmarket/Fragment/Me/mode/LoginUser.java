package com.example.djy.secondmarket.Fragment.Me.mode;

/**
 * Created by djy on 2019/3/26.
 */

public class LoginUser {

    private String OpType;
    private String Uname;
    private String Upassword;

    public String getOpType() {
        return OpType;
    }

    public void setOpType(String opType) {
        OpType = opType;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "OpType='" + OpType + '\'' +
                ", Uname='" + Uname + '\'' +
                ", Upassword='" + Upassword + '\'' +
                '}';
    }
}
