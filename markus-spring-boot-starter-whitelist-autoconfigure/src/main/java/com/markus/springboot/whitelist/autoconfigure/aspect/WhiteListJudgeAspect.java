package com.markus.springboot.whitelist.autoconfigure.aspect;

import com.markus.springboot.whitelist.autoconfigure.annotation.WhiteList;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: markus
 * @date: 2023/4/9 3:03 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
@Component
public class WhiteListJudgeAspect {

    @Resource
    private List<String> whitelist;

    @Pointcut("@annotation(com.markus.springboot.whitelist.autoconfigure.annotation.WhiteList)")
    public void pointcut() {

    }

    @Around(value = "pointcut()")
    public Object proceed(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = pjp.getTarget().getClass().getMethod(signature.getName(), signature.getParameterTypes());

        WhiteList whiteList = method.getAnnotation(WhiteList.class);
        if (whiteList == null) {
            return pjp.proceed();
        }

        Object[] args = pjp.getArgs();
        if (args.length == 0) {
            return pjp.proceed();
        }

        // 我们假定选择第一个参数就是用户名
        if (whitelist.contains(args[0])) {
            // 放行
            return pjp.proceed();
        } else {
            return whiteList.responseJson();
        }
    }
}
