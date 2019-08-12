package com.kdm.message.util.impl;

import com.kdm.message.util.BaseMessageUtil;
import com.kdm.message.util.bean.MessageText;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

/**
 * @PackageName:com.kdm.messageUtil
 * @ClassName:TextMessageUtil
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/5 14:03
 */
public class TextMessageUtil implements BaseMessageUtil<MessageText> {


    @Override
    public String messageToXml(MessageText message) {
        XStream xStream = new XStream();
        xStream.alias("xml",message.getClass());
        return xStream.toXML(message);
    }

    @Override
    public String init(String FromUserName, String ToUserName, String Content) {
        MessageText messageText = new MessageText();
        messageText.setFromUserName(ToUserName);
        messageText.setToUserName(FromUserName);
        messageText.setCreateTime(new Date().getTime());
        messageText.setMsgType("text");
        messageText.setContent(Content+"牛逼嗷");
        return messageToXml(messageText);
    }

    public String init(String FromUserName, String ToUserName) {
        MessageText messageText = new MessageText();
        messageText.setFromUserName(ToUserName);
        messageText.setToUserName(FromUserName);
        messageText.setCreateTime(new Date().getTime());
        messageText.setMsgType("text");
        messageText.setContent("欢迎来到奇奇不怪");
        return messageToXml(messageText);
    }

    public String returnSuccess(String FromUserName, String ToUserName) {
        MessageText messageText = new MessageText();
        messageText.setFromUserName(ToUserName);
        messageText.setToUserName(FromUserName);
        messageText.setCreateTime(new Date().getTime());
        messageText.setMsgType("text");
        messageText.setContent("success");
        return messageToXml(messageText);
    }

}
