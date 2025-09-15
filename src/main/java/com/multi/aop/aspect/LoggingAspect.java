package com.multi.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // AOP 애스펙트임을 선언
@Component // Spring Bean으로 등록
public class LoggingAspect {

    // 대상 메서드 실행 "전"에 실행
    @Before("execution(* com.multi.aop.service.SampleService.*(..))")
    public void before(JoinPoint jp) {
        System.out.println("[B] " + jp.getSignature().toShortString());
    }

    // 대상 메서드가 "정상적으로 값(ret)을 반환한 후"에 실행
    @AfterReturning(pointcut = "execution(* com.multi.aop.service.SampleService.*(..))", returning = "ret")
    public void afterReturning(JoinPoint jp, Object ret) {
        System.out.println("[AR] " + jp.getSignature().toShortString() + " => " + ret);
    }

    // 대상 메서드에서 "예외(ex)가 발생한 후"에 실행
    @AfterThrowing(pointcut = "execution(* com.multi.aop.service.SampleService.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("[AT] " + jp.getSignature().toShortString() + " !! " + ex.getClass().getSimpleName());
    }

    // 대상 메서드 실행 "후"에 실행 (정상/예외 상관없이 항상 실행)
    @After("execution(* com.multi.aop.service.SampleService.*(..))")
    public void after(JoinPoint jp) {
        System.out.println("[A] " + jp.getSignature().toShortString());
    }
}