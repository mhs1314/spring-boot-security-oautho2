package com.test.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 权限管理规则
 * logoutsuccessurl:用来定义退出成功的链接
 * permitall:用来定义允许访问的URL列表
 * deniedpage:用来设定拒绝访问的信息提示链接
 * urlroles:这是一个权限管理规则，是链接地址与角色权限的配置列表
 * @author mhs123
 *
 */
@ConfigurationProperties(prefix="securityconfig")
public class SecuritySettings {
    private String logoutsuccssurl = "/logout";
    private String permitall = "/api";
    private String deniedpage = "/deny";
    private String urlroles;

    public String getLogoutsuccssurl() {
        return logoutsuccssurl;
    }

    public void setLogoutsuccssurl(String logoutsuccssurl) {
        this.logoutsuccssurl = logoutsuccssurl;
    }

    public String getPermitall() {
        return permitall;
    }

    public void setPermitall(String permitall) {
        this.permitall = permitall;
    }

    public String getDeniedpage() {
        return deniedpage;
    }

    public void setDeniedpage(String deniedpage) {
        this.deniedpage = deniedpage;
    }

    public String getUrlroles() {
        return urlroles;
    }

    public void setUrlroles(String urlroles) {
        this.urlroles = urlroles;
    }
}
