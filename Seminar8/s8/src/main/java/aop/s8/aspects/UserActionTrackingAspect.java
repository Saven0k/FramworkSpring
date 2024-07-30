package aop.s8.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionTrackingAspect {
//    private static final Logger logger =
//            LoggerFactory.getLogger(UserActionTrackingAspect.class);

    @Around("@annotation(aop.s8.aspects.TrackUserAction)")
    public Object trackUserAction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("User вызвал метод: " + joinPoint.getSignature().getName());
        Object pr = joinPoint.proceed();
        System.out.println("Метод завершил работу");
        return pr;
    }
}
