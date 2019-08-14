package com.kdm.qrsence.generateQR;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.kdm.qrsence.generateQR.bean.Qrscene;
import com.kdm.qrsence.generateQR.bean.action_info;
import com.kdm.qrsence.generateQR.bean.scene;

/**
 * @PackageName:com.sitech.echn.weixin.util.generateQR
 * @ClassName:QRgenerate
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/14 13:36
 */

public class QRgenerateUtil{

    //temp场景值，phoneNO手机号
    public String getQR(String temp, String phoneNO){
        Qrscene qrscene = new Qrscene();
        qrscene.setAction_name("QR_LIMIT_STR_SCENE");//永久的字符串二维码
        qrscene.setAction_info(new action_info((new scene(temp+"_"+phoneNO))));

        String jsonStr = JSON.toJSONString(qrscene);
        return jsonStr;//返回换取二维码拼接报文
    }


}
