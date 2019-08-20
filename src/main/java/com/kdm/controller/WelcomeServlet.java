package com.kdm.controller;/**
 * Created by 57180 on 2019/7/29.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

/**
 * @program: weixin-demo
 * @description:
 * @author: 李柏君
 * @create: 2019-07-29 16:07
 **/
@RestController
public class WelcomeServlet extends HttpServlet {

    @RequestMapping("/user")
    public String getTest(){
        return "测试";
    }
}


