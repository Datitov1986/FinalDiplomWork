package diplom.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionHandlerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);

    @AfterThrowing(pointcut = "execution(* diplom.*.*(..))", throwing = "ex")
    public void logException(Exception ex) {
        logger.error("Произошло исключение: {}", ex.getMessage());
    }
}
