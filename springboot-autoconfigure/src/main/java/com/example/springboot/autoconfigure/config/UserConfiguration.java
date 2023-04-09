package com.example.springboot.autoconfigure.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author: markus
 * @date: 2023/4/9 1:45 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Configuration
@ConditionalOnClass(AppConfiguration.class)
@ConditionalOnProperty(prefix = "user", name = "enable", havingValue = "true")
public class UserConfiguration {
}
