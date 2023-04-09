package com.markus.middleware.whitelist.config;

import com.markus.middleware.whitelist.aspect.WhiteListJudgeAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author: markus
 * @date: 2023/4/9 3:04 PM
 * @Description: 白名单自动配置
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Configuration
@EnableConfigurationProperties(WhiteListProperties.class)
@ConditionalOnClass(WhiteListProperties.class)
public class WhiteListAutoConfig {

    @Bean("whitelist")
    @ConditionalOnMissingBean
    public List<String> whitelist(WhiteListProperties whiteListProperties) {
        return whiteListProperties.getUsers();
    }
}
