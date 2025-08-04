package com.monish.Spring_Ecom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    //return-type   fully-qualified-class-name.method-name(args)
    //@Before("execution(* *.*(..))")  for all the return-type all-class.all-methods and (all args)
    @Before("execution(* com.monish.Spring_Ecom.service.ProductService.*(..))")
    public void logMethodCall(){
        logger.info("Method called");
    }

    @Before("execution(* com.monish.Spring_Ecom.service.ProductService.getAllProducts(..))")
    public void logMethodCalled(JoinPoint joinPoint){
        logger.info("Method called "+joinPoint.getSignature().getName());
    }

    @After("execution(* com.monish.Spring_Ecom.service.ProductService.getAllProducts(..)) || execution(* com.monish.Spring_Ecom.service.ProductService.getDetails(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        logger.info("Method Executed "+joinPoint.getSignature().getName());
    }
    @AfterThrowing("execution(* com.monish.Spring_Ecom.service.ProductService.getAllProducts(..)) || execution(* com.monish.Spring_Ecom.service.ProductService.getDetails(..))")
    public void logMethodFailed(JoinPoint joinPoint){
        logger.info("Method has some isses "+joinPoint.getSignature().getName());
    }
    @AfterReturning("execution(* com.monish.Spring_Ecom.service.ProductService.getAllProducts(..)) || execution(* com.monish.Spring_Ecom.service.ProductService.getDetails(..))")
    public void logMethodSuccess(JoinPoint joinPoint){
        logger.info("Method Executed successfully "+joinPoint.getSignature().getName());
    }
}
