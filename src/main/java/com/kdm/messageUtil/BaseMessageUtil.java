package com.kdm.messageUtil;

public interface BaseMessageUtil<T> {

    public abstract  String messageToXml(T t);

    public abstract String init(String FromUserName,String ToUserName,String Content);

    public abstract String init(String FromUserName,String ToUserName);

}
