package com.example.springboot.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebLogAcpect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAcpect.class);

    /**
     * 定义切入点，切入点为com.example.springboot.springboot.controller下的所有函数
     */
    @Pointcut("execution(public * com.example.springboot.springboot.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("===Before我是前置通知:{}", joinPoint);
    }

    @AfterReturning("webLog()")
    public void doAfterReturning() {
        logger.info("===AfterReturning我是返回通知");
    }

    @After("webLog()")
    public void doAfter() {
        logger.info("===After我是后置通知");
    }

    @AfterThrowing(pointcut = "webLog()")
    public void doAfterThrowing(JoinPoint joinPoint) {
        logger.info("===AfterThrowing我是异常通知:{}",joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知必须返回，如果不返回导致url返回的信息为空
     *
     * @param joinPoint 代理入参
     * @return 返回信息
     * @throws Throwable 异常
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("===Around我是环绕通知");
        return joinPoint.proceed();
    }
}
