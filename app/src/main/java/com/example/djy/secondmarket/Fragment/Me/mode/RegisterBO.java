package com.example.djy.secondmarket.Fragment.Me.mode;

/**
 * Created by djy on 2019/3/24.
 */

public class RegisterBO {

    private int flag;
    private String message;
    private String token;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "RegisterBO{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
