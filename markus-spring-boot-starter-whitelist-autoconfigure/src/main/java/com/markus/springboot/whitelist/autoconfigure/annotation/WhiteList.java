package com.markus.springboot.whitelist.autoconfigure.annotation;

import java.lang.annotation.*;

/**
 * @author: markus
 * @date: 2023/4/9 2:59 PM
 * @Description: 白名单注解
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WhiteList {
    /**
     * 白名单命中时，是否通过此方法，如果不准入，则返回responseJson 否则正常执行目标方法
     *
     * @return
     */
    boolean passAfterHit() default true;

    /**
     * 不执行目标方法时返回的内容
     *
     * @return
     */
    String responseJson() default "";
}
