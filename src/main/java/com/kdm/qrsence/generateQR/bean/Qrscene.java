package com.kdm.qrsence.generateQR.bean;

/**
 * @PackageName:com.sitech.echn.weixin.util.generateQR.bean
 * @ClassName:Qrscene
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/14 13:43
 */
public class Qrscene {

    private String action_name;
    private action_info action_info;

    public com.kdm.qrsence.generateQR.bean.action_info getAction_info() {
        return action_info;
    }

    public void setAction_info(com.kdm.qrsence.generateQR.bean.action_info action_info) {
        this.action_info = action_info;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }
}
