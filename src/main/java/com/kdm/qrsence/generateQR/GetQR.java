package com.kdm.qrsence.generateQR;

/**
 * @PackageName:com.sitech.echn.weixin.util.generateQR
 * @ClassName:GetQR
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/14 16:51
 */
public class GetQR {
    private String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";


    public String qrgenerator(String ticekt){
        String weixin_url = url.replace("TICKET",ticekt);

        return weixin_url;
    }

}