package com.monish.Spring_Ecom.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    public static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);
//Creating a validation if the id is negative, if negative convert it to positive
    @Around("execution(* com.monish.Spring_Ecom.service.ProductService.getDetails(..)) && args(id)")
    public Object validating(ProceedingJoinPoint jp, int id) throws Throwable {
        if(id<0){
            System.out.println("Id is negative, Updating it");
            id=-id;
            logger.info("Id is : "+id);
        }
        Object obj = jp.proceed(new Object[]{id});
        return obj;
    }

}
