package com.xiaohai;

import ch.qos.logback.core.db.DBHelper;
import com.xiaohai.beans.User;
import com.xiaohai.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        // 配置类在容器里也是一个组件 所以当我们在容器拿到配置类组件的时候 当开启@Configuration(proxyBeanMethods = true)
//            这个注解时候 配置类会变成代理 当他调用里面的getuser方法的时候会去容器里面找对应的Bean 当@Configuration(proxyBeanMethods = false)
//                的时候将不会在容器里面取得 而是直接调用此方法
        MyConfig myConfig = run.getBean("myConfig",MyConfig.class);
        User user = run.getBean("user01",User.class);
        User user01 = myConfig.getUser();
        User user02 = run.getBean("com.xiaohai.beans.User",User.class);
        System.out.println(user == user01);
        // 当我使用@Import({User.class, DBHelper.class})这个注解的时候 会在容器中创建以包名为key的User对象 他与MyConfig @Bean中的实例并不相同
        System.out.println(user == user02);
    }
}
