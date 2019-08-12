package com.kdm.message.service;

import com.kdm.message.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MessageOperation {

    public void messageOperaction(HttpServletRequest request){
        MessageUtil messageUtil = new MessageUtil();
        Map<String,String> map = messageUtil.xmlToMap(request);

    }
}
