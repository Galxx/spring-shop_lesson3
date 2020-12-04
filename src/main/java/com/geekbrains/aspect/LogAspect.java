package com.geekbrains.aspect;

import com.geekbrains.frontend.CartView;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Around("@annotation(log)")
    public void logAround(ProceedingJoinPoint p, Log log) throws Throwable {
        System.out.println(p);
        long start = System.currentTimeMillis();
        p.proceed();
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения ms: " + (finish - start));

    }

}
