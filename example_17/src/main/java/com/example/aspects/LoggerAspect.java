package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {
    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());
    @Around("execution(* com.example.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws  Throwable {
        logger.info(joinPoint.getSignature().toString()+ " Method Execution Starts");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start,finish).toMillis();
        logger.info("Time taken to complete this method : : " + timeElapsed+ " milliSeconds");
        logger.info(joinPoint.getSignature().toString() + " Method Execution completed");
    }

    @Around("@annotation(com.example.interfaces.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws  Throwable {
        logger.info(joinPoint.getSignature().toString()+ " Method Execution Starts");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start,finish).toMillis();
        logger.info("Time taken to complete this method : : " + timeElapsed+ " milliSeconds");
        logger.info(joinPoint.getSignature().toString() + " Method Execution completed");
    }
    @AfterThrowing( value = "execution(* com.example.services.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        logger.log(Level.SEVERE, joinPoint.getSignature() + " An Exception thrown with the help of "+
                "AfterThrowing Exception which happened due to "+ ex.getMessage());
    }
    @AfterReturning(value ="execution(* com.example.services.*.*(..))", returning = "retVal")
    public void logStatus (JoinPoint joinPoint, Object retVal) {
        logger.log(Level.SEVERE, joinPoint.getSignature() + " Method Successfully processed with status  " + retVal.toString());
    }
}
