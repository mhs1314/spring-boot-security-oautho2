package com.test.login;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
/**
 * 登录认证模块
 * 使用keytool创建数字证书
 * c:\\users\Alan>keytool -genkey -keystore keystore.jks -alias tycoonclent -keyalg RSA
 * 此sso-demo工程分
 * 数据管理模块 -mysql-作为jar包被引用
 * 安全配置模块-security
 * 登录认证模块-login-包含mysql
 * 共享资源模块-resource
 * 客户端应用-web1-包含msyql
 * 客户端应用-web2-包含mysql
 * @author mhs123
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.test")
public class LoginApplication implements ServletContextInitializer {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    public void onStartup(ServletContext servletContext)
            throws ServletException {
        servletContext.getSessionCookieConfig().setName("SESSIONID");
    }
}
