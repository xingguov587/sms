package com.sms.provider.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author chengxing
 * @date 2021/04/02
 * @decription aop日志管理
 */
@Slf4j
@Aspect
@Component
public class LogServiceImpl {

    private static int size = 0;

    @Pointcut("execution(* com.sms.provider.service.impl.*.*(..))")
    public void pointcut(){
    }

    @Before("pointcut()")
    public void before(JoinPoint point){
        size++;
        log.info("执行[" + size + "]" + point.getThis() + "." + point.getSignature().getName()+"方法");
        Object[] args = point.getArgs();
        log.info("目标参数列表[" + size + "]: " + JSON.toJSONString(args));
    }

    @AfterReturning(pointcut = "pointcut()", returning = "returnObj")
    public void afterReturning(Object returnObj){
        log.info("返回结果[" + size + "] "+ JSON.toJSONString(returnObj));
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint point, Exception e){
        String methodName = point.getSignature().getName();
        log.error("The method " + methodName + "occurs Exception: " + e);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.nanoTime();
        Object o = pjp.proceed();
        long end = System.nanoTime();
        log.warn("{" + pjp.getTarget().getClass() + "." + "}:{" + pjp.getSignature().getName() + "}" + (end - begin) / 1000000);
        return o;
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void handle(JoinPoint point, Exception e){
        Object[] args = point.getArgs();
        log.error("目标参数列表[" + size + "]" + JSON.toJSONString(args));
        log.error(e.toString());
    }
}
