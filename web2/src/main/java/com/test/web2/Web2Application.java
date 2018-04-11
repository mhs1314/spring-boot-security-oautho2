package com.test.web2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author mhs123
 *
 */
@SpringBootApplication
//使用@EnableZuulProxy来开启Zuul路由代理服务
@EnableZuulProxy
@ComponentScan(basePackages = "com.test")
public class Web2Application {
    public static void main(String[] args) {
        SpringApplication.run(Web2Application.class, args);
    }
}
