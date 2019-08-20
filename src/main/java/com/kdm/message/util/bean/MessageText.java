package com.kdm.message.util.bean;

import com.kdm.message.util.bean.MessageBase;

/**
 * @PackageName:com.kdm.messageUtil.impl
 * @ClassName:MessageTest
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/5 13:32
 */
public class MessageText extends MessageBase {

    private String Content;
    private String MsgId;

    public MessageText(){

    }

    public MessageText(String toUserName,String fromUserName,long createTime,String msgType,String content,String msgId){
        super();
        ToUserName = toUserName;
        FromUserName =fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        Content = content;
        MsgId = msgId;
    }


    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
