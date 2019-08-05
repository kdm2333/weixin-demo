package com.kdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WeixinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinDemoApplication.class, args);
	}

}
