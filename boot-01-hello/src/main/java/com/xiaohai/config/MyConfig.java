package com.xiaohai.config;

import ch.qos.logback.core.db.DBHelper;
import com.xiaohai.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false)
public class MyConfig {
    // 默认是以方法名字为id创建的bean 像这样@Bean("user")则以user为id
    @Bean("user01")
    public User getUser() {
        return new User("小明",18);
    }
}
