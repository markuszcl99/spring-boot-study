package com.example.springboot.autoconfigure;

import com.example.springboot.autoconfigure.config.UserConfiguration;
import com.markus.springboot.whitelist.autoconfigure.aspect.WhiteListJudgeAspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootAutoconfigureApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootAutoconfigureApplication.class, args);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }


        System.out.println("=================");

        UserConfiguration userConfiguration = context.getBean(UserConfiguration.class);
        System.out.println("userConfiguration is exist? result is " + (userConfiguration != null));

        System.out.println(context.getBean(AopAutoConfiguration.class));
        System.out.println(context.getBean("whitelist"));
        System.out.println(context.getBean(WhiteListJudgeAspect.class));


    }
}
