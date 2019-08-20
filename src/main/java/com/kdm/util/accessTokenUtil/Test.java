package com.kdm.util.accessTokenUtil;

/**
 * @PackageName:com.kdm.util.accessTokenUtil
 * @ClassName:Test
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/7 17:27
 */
public class Test {

    public static void main(String[] args){
        System.out.println("测试开启");
        String access_token;
        access_token = WeixinUtil.getAccess_Token();
        System.out.println("调用成功access_token："+access_token);
    }
}
