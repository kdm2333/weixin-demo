package com.kdm.qrsence.generateQR.bean;

/**
 * @PackageName:com.sitech.echn.weixin.util.generateQR.bean
 * @ClassName:action_info
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/14 13:46
 */
public class action_info {


    private scene scene;

    public action_info(scene scene){
        this.scene = scene;
    }

    public com.kdm.qrsence.generateQR.bean.scene getScene() {
        return scene;
    }

    public void setScene(com.kdm.qrsence.generateQR.bean.scene scene) {
        this.scene = scene;
    }
}
