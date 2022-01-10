package p.hh.topics.tryaspectjload;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("set(* NamedService.*)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before setting " + joinPoint.getTarget());
    }

    @Before("set(* NamedService.*)")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After setting " + joinPoint.getTarget());
    }

}