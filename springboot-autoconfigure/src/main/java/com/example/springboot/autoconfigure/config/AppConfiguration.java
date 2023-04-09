package com.example.springboot.autoconfigure.config;

import com.example.springboot.autoconfigure.properties.UserProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author: markus
 * @date: 2023/4/9 12:46 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Configuration
@EnableConfigurationProperties(UserProperties.class)
@ComponentScan("com.markus.middleware.*")
public class AppConfiguration {
}
