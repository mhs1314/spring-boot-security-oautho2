package com.test.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
/**
 * 共享资源模块
 * EnableResourceServer 标注这个应用是一个资源服务器
 * 一个应用被标注为资源服务器后，在浏览器中就不能直接访问，如果在浏览器访问会出现xml提示
 * 在客户端使用资源服务器的共享信息，可以使用spring-cloud-zuul提供的一个路由服务来实现
 * @author mhs123
 *
 */
@SpringBootApplication
//EnableResourceServer 标注这个应用是一个资源服务器
@EnableResourceServer
@ComponentScan(basePackages = "com.test")
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}
