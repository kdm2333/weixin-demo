package com.kdm.message.util.bean;

/**
 * @PackageName:com.kdm.messageUtil
 * @ClassName:MessageBase
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/5 13:27
 */

public class MessageBase {

    protected String ToUserName;
    protected String FromUserName;
    protected long CreateTime;
    protected String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
