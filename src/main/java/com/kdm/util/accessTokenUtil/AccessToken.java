package com.kdm.util.accessTokenUtil;

/**
 * @Author: 裴佳琦
 * @CreateDate: 2019/8/7 0:24
 * @Description:
 */
public class AccessToken {

    private String access_Token;

    private int expires_in;

    public String getAccess_Token() {
        return access_Token;
    }

    public void setAccess_Token(String access_Token) {
        this.access_Token = access_Token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
