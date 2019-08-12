package com.kdm.servlet;/**
 * Created by 57180 on 2019/7/29.
 */

import com.kdm.messageUtil.MessageUtil;
import com.kdm.messageUtil.impl.MessageText;
import com.kdm.messageUtil.impl.TextMessageUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * @program: weixin-demo
 * @description:
 * @author: 李柏君
 * @create: 2019-07-29 14:23
 **/
@WebServlet(name = "WeChatServlet",urlPatterns ="/WeChatServlet")
/*@RequestMapping(value = "WeChatServlet")*/
public class WeChatServlet extends HttpServlet {

    public static Logger logger = Logger.getLogger(WeChatServlet.class);

    private final String TOKEN = "kdm1";
    private String signature;//微信加密签名
    private String timestamp;//时间戳
    private String nonce;//随机数
    private String echostr;//随机字符串

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始校验签名");

        signature = req.getParameter("signature");
        timestamp = req.getParameter("timestamp");
        nonce = req.getParameter("nonce");
        echostr = req.getParameter("echostr");
        //对TOKEN,时间戳，随机数进行字典排序
        String sortString =  sort(TOKEN,timestamp,nonce);
        //加密
        String mySignature = sha1(sortString);
        //校验签名
        if (mySignature!=null&&mySignature!=""&&mySignature.equals(signature)){
            System.out.println("签名校验通过");
            //校验通过后输出echostr，微信服务器接到此输出才会确认校验完成
            resp.getWriter().write(echostr);
        }else {
            System.out.println("校验签名失败");
        }

    }

    public String sort(String token,String timestamp,String noce){
        String[] strArray = {token,timestamp,noce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str:strArray){
            sb.append(str);
        }

        return sb.toString();
    }

    public String sha1(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++){
                String shaHex = Integer.toHexString(messageDigest[i]&0xFF);
                    if (shaHex.length()<2){
                        hexString.append(0);
                    }
                    hexString.append(shaHex);
                }
                return hexString.toString();
            }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "";
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = null;

        MessageUtil messageUtil = new MessageUtil();
        Map<String,String> map = messageUtil.xmlToMap(req);
        System.out.println(map.toString());
        String ToUserName = map.get("ToUserName");
        String FromUserName = map.get("FromUserName");
        String MsgType = map.get("MsgType");
        String Content = map.get("Content");

        String message = null;

        if ("text".equals(MsgType)){
            if ("1".equals(Content)){
                TextMessageUtil textMessageUtil = new TextMessageUtil();
                message = textMessageUtil.init(FromUserName,ToUserName);
                System.out.printf(message.toString());
            }else{
                TextMessageUtil textMessageUtil = new TextMessageUtil();
                message = textMessageUtil.init(FromUserName,ToUserName,Content);
                System.out.println(message.toString());
            }
        }else{
            TextMessageUtil textMessageUtil = new TextMessageUtil();
            message = "success";
            System.out.println(message.toString());
        }
        try {
            out = resp.getWriter();
            out.write(message);
        }catch (IOException e){
            e.printStackTrace();
        }
        out.close();
    }
}
