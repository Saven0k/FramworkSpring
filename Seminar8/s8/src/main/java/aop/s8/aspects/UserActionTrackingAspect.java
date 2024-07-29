package aop.s8.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionTrackingAspect {
    private static final Logger logger =
            LoggerFactory.getLogger(UserActionTrackingAspect.class);

    @Before("@annotation(aop.s8.aspects.TrackUserAction)")
    public void trackUserAction(JoinPoint joinPoint) {
        String user = "currentUser";
        Object[] args = joinPoint.getArgs();
        String methodName = "";
        logger.info("User " + user + " invoked " + methodName + " witharguments: " + Arrays.toString(args));
    }
}
