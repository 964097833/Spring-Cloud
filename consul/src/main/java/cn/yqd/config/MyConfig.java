package cn.yqd.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@RefreshScope
@ConfigurationProperties(prefix = "jdbc")
public class MyConfig {

    private String username;
    private String password;
    private My my;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public My getMy() {
        return my;
    }

    public void setMy(My my) {
        this.my = my;
    }
}
