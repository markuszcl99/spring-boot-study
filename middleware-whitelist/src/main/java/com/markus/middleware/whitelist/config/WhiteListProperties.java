package com.markus.middleware.whitelist.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author: markus
 * @date: 2023/4/9 3:08 PM
 * @Description: 白名单配置绑定
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@ConfigurationProperties(prefix = "whitelist")
@Data
public class WhiteListProperties {
    private List<String> users;
}
