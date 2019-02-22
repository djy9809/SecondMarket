package com.example.djy.secondmarket.Fragment.Me.mode;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by djy on 2019/2/23.
 */

public class UserBO implements Serializable {
    private String uid;
    private String uname;
    private String upassword;
    private byte[] uimage;

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

    @Override
    public String toString() {
        return "UserBO{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uimage=" + Arrays.toString(uimage) +
                '}';
    }
}
