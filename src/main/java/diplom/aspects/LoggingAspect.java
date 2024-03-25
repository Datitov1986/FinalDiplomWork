package diplom.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* diplom. *Controller.*(..))")
    public void logControllerMethods() {
        logger.info("Метод контроллера выполнен");
    }

    @Before("execution(* diplom. *Service.*(..))")
    public void logServiceMethods() {
        logger.info("Метод сервиса выполнен");
    }
}
