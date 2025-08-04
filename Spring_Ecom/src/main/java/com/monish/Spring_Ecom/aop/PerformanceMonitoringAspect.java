package com.monish.Spring_Ecom.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {

    public static final Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.monish.Spring_Ecom.service.ProductService.*(..))")
    public Object monitoringTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long end =System.currentTimeMillis();
        logger.info("Time taken by : "+joinPoint.getSignature().getName()+" Method is "+(end-start)+"ms");
        return obj;
    }
}
