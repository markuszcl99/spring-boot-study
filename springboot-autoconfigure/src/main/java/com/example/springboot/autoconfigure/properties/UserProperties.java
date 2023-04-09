package com.example.springboot.autoconfigure.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author: markus
 * @date: 2023/4/9 12:45 PM
 * @Description: 用户配置
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@ConfigurationProperties(prefix = "user")
@Data
@ToString
public class UserProperties {
    private String username;
    private String password;
}
