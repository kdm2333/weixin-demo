package com.kdm.message.util.impl;

import com.kdm.message.util.BaseMessageUtil;
import com.kdm.message.util.bean.Image;
import com.kdm.message.util.bean.MessageImage;
import com.kdm.message.util.bean.MessageText;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

/**
 * @PackageName:com.kdm.message.util.impl
 * @ClassName:ImageMessageUtil
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/13 13:46
 */
public class ImageMessageUtil implements BaseMessageUtil<MessageImage> {

    @Override
    public String messageToXml(MessageImage message) {
            XStream xStream = new XStream();
            xStream.alias("xml",message.getClass());
            return xStream.toXML(message);
    }


    @Override
    public String init(String FromUserName, String ToUserName, String MediaId) {
        MessageImage messageImage = new MessageImage();
        messageImage.setToUserName(FromUserName);
        messageImage.setFromUserName(ToUserName);
        messageImage.setImage(new Image(MediaId));
        messageImage.setCreateTime(new Date().getTime());
        messageImage.setMsgType("image");

        return messageToXml(messageImage);
    }

    @Override
    public String init(String FromUserName, String ToUserName) {
        return null;
    }
}
