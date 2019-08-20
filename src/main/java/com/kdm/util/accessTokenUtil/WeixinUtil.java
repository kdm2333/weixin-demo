package com.kdm.util.accessTokenUtil;

import com.alibaba.fastjson.JSONObject;
import com.kdm.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * @PackageName:com.kdm.util.accessTokenUtil
 * @ClassName:WeixinUtil
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/5 16:59
 */
@Slf4j
public class WeixinUtil {

    private static final String APPID = "wx8971117db79ce400";
    private static final String APPSERCRET = "93a56736de3f7702cb3f16e9d13d1bb5";
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static JSONObject doGetstr(String url){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        JSONObject jsonObject = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity!=null) {
                String result = EntityUtils.toString(entity);
                jsonObject = JSONObject.parseObject(result);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONObject doPoststr(String url,String outStr){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity!=null) {
                String result = EntityUtils.toString(entity);
                jsonObject = JSONObject.parseObject(result);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static AccessToken getAccessToken(){
        System.out.println("从接口中获取");
        Jedis jedis = RedisUtil.getJedis();
        AccessToken accessToken = new AccessToken();
        String url = ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSERCRET);
        JSONObject jsonObject = doGetstr(url);
        if (jsonObject!=null){
            accessToken.setAccess_Token(jsonObject.getString("access_token"));
            //accessToken.setExpires_in(jsonObject.getInteger("expires_in"));
            jedis.set("access_token",jsonObject.getString("access_token"));
            jedis.expire("access_token",60*60*2);
        }
        RedisUtil.returnResource(jedis);
        return accessToken;
    }

    public static String getAccess_Token(){
        System.out.println("从缓存中读取");
        Jedis jedis = RedisUtil.getJedis();
        String access_token = jedis.get("access_token");
        if (access_token==null){
            AccessToken accessToken = getAccessToken();
            access_token = accessToken.getAccess_Token();
        }
        RedisUtil.returnResource(jedis);
        return access_token;
    }
}
