package com.kdm.message.service;

import com.kdm.message.service.impl.Message;
import com.kdm.message.util.MessageUtil;
import com.kdm.message.util.bean.Image;
import com.kdm.message.util.impl.ImageMessageUtil;
import com.kdm.message.util.impl.TextMessageUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Log4j2
@Service
public class MessageOperation {


    public String messageOperaction(Map<String,String> map){

        String message = null;
        String MsgType = map.get("MsgType");
        if("text".equals(MsgType)){
            message = textOperation(map);
        }else if ("image".equals(MsgType)){
            message = imageOperation(map);
        }else {
            message = "success";
        }

        log.info(message);

        return message;
    }

    public String textOperation(Map<String,String> map){

        String  message = null;

        String ToUserName = map.get("ToUserName");
        String FromUserName = map.get("FromUserName");
        String MsgType = map.get("MsgType");
        String Content = map.get("Content");
        if ("1".equals(Content)){
            TextMessageUtil textMessageUtil = new TextMessageUtil();
            message = textMessageUtil.init(FromUserName,ToUserName,new String("欢迎关注"));
        }else {
            TextMessageUtil textMessageUtil = new TextMessageUtil();
            message = textMessageUtil.init(FromUserName,ToUserName);
        }

        return message;
    }

    public String imageOperation(Map<String,String> map){
        String  message = null;

        String ToUserName = map.get("ToUserName");
        String FromUserName = map.get("FromUserName");
        String MsgType = map.get("MsgType");
        String Content = map.get("Content");
        String MediaId = map.get("MediaId");

        ImageMessageUtil imageMessageUtil = new ImageMessageUtil();
        message = imageMessageUtil.init(FromUserName,ToUserName,MediaId);

        return message;
    }

    private String voiceOperation(Map<String,String> map){

        return null;
    }


}
