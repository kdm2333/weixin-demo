package com.kdm.util.accessTokenUtil;

/**
 * @Author: 裴佳琦
 * @CreateDate: 2019/8/7 0:24
 * @Description:
 */
public class AccessToken {

    private String accessToken;

    private int expires_in;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
