package com.example.springboot.autoconfigure.controller;

import com.example.springboot.autoconfigure.properties.Person;
import com.example.springboot.autoconfigure.properties.UserProperties;
import com.markus.springboot.whitelist.autoconfigure.annotation.WhiteList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: markus
 * @date: 2023/4/8 10:26 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@RestController
public class HelloController {

    @Autowired
    private UserProperties userProperties;

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/properties")
    public String properties() {
        return "use @EnableConfigurationProperties " + userProperties + " and use @Component " + person;
    }

    @WhiteList(responseJson = "{\n" +
            "    \"code\":\"500\",\n" +
            "    \"msg\":\"非白名单可访问用户拦截\",\n" +
            "    \"data\":\"null\"\n" +
            "}")
    @RequestMapping("/whitelist/test")
    public String whitelist(@RequestParam String userId) {
        return "Hello SpringBoot User " + userId;
    }

}
