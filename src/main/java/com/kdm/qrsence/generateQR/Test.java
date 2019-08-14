package com.kdm.qrsence.generateQR;

/**
 * @PackageName:com.kdm.demo.generateQR
 * @ClassName:Test
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/14 14:09
 */
public class Test {

    public static void main(String[] args){
        QRgenerateUtil qRgenerate = new QRgenerateUtil();

        String go = qRgenerate.getQR("1000","13293333");

        System.out.println(go);
    }
}
