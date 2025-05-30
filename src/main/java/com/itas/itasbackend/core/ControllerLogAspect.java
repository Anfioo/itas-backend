package com.itas.itasbackend.core;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;


/**
 * 全局 Controller 层日志记录切面
 */
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {

    // 切入所有 controller 包及子包下的公共方法
    @Pointcut("execution(public * com.itas.itasbackend.system.controller..*(..))")
    public void controllerMethods() {
    }

    //
//    @Around("controllerMethods()")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//
//        ServletRequestAttributes attributes =
//                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 获取请求信息
//        String url = request.getRequestURL().toString();
//        String method = request.getMethod();
//        String ip = request.getRemoteAddr();
//        String classMethod = joinPoint.getSignature().toShortString();
//        Object[] args = joinPoint.getArgs();
//
//        log.info("➡ [{} {}]| Handler: {} | Args: {}", method, url, classMethod, Arrays.toString(args));
//
//        Object result;
//        try {
//            result = joinPoint.proceed();
//        } catch (Exception e) {
//            log.error("❌ 异常发生 - {} {}", classMethod, e.getMessage(), e);
//            throw e;
//        }
//
//        long end = System.currentTimeMillis();
//        log.info("✅ 响应: {} | 耗时: {} ms", result, end - start);
//        return result;
//    }
    @Around("controllerMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // 获取当前执行的目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        Logger logger = LoggerFactory.getLogger(targetClass);

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        logger.info("{}-{}  | Handler: {} ", method, url, classMethod);
        System.out.println("Args: " + Arrays.toString(args));

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            logger.error("❌ 异常发生 - {} {}", classMethod, e.getMessage(), e);
            throw e;
        }

        long end = System.currentTimeMillis();
        System.out.println("✅ 响应: " + result + "\n耗时: {" + (end - start) + "} ms");
        return result;
    }

}

