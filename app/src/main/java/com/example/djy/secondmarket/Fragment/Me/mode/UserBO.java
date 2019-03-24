package com.example.djy.secondmarket.Fragment.Me.mode;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by djy on 2019/2/23.
 */

public class UserBO implements Serializable {
    private String opType;
    private String uid;
    private String uname;
    private String upassword;
    private byte[] uimage;
    private String uphone;


    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public byte[] getUimage() {
        return uimage;
    }

    public void setUimage(byte[] uimage) {
        this.uimage = uimage;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    @Override
    public String toString() {
        return "UserBO{" +
                "opType='" + opType + '\'' +
                ", uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uimage=" + Arrays.toString(uimage) +
                ", uphone='" + uphone + '\'' +
                '}';
    }
}
