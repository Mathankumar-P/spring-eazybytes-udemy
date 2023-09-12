package com.springexercise.eazyschool.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
    @Around("execution(* com.springexercise.eazyschool..*.*(..))")
    public Object log (ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Yeah");
        log.info(joinPoint.getSignature().toString() + " / Method Execution Starts");
        Instant start = Instant.now();
        Object returnObj = joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log .info ("Time took to execute " + joinPoint.getSignature().toString() + " method is " + timeElapsed );
        log.info(joinPoint.getSignature().toString() + " / Method Execution Ends Here");
        return returnObj;
    }
    @AfterThrowing(value = "execution(* com.springexercise.eazyschool.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error(joinPoint.getSignature()+ " An exception happened due to : "+ex.getMessage());
    }

}
