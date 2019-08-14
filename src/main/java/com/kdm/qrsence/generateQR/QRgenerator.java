package com.kdm.qrsence.generateQR;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.kdm.util.accessTokenUtil.WeixinUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:com.sitech.echn.weixin.util.generateQR
 * @ClassName:QRgenerator
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/14 14:21
 */
public class QRgenerator {

    private String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
    private String TOKEN;

    public String qrgenerator(String temp, String phoneNo){
        QRgenerateUtil qRgenerateUtil = new QRgenerateUtil();
        String qr = qRgenerateUtil.getQR(temp,phoneNo);


        TOKEN = WeixinUtil.getAccess_Token();


        String weixin_url = url.replace("TOKEN",TOKEN);

        JSONObject jsonObject = doPoststr(weixin_url,qr);


        Map<String, String> map = new HashMap<String, String>();
        map = (Map<String, String>) JSON.parse(jsonObject.toJSONString());

        String ticket = map.get("ticket");

        return ticket;
    }

    public static JSONObject doPoststr(String url, String outStr){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null){
                String result = EntityUtils.toString(entity);
                jsonObject = JSON.parseObject(result);
            }
        }catch (Exception e){

            e.printStackTrace();
        }

        return jsonObject;
    }

}
