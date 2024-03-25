package diplom.aspects;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {

    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    public ExceptionHandlerAspect exceptionHandlerAspect() {
        return new ExceptionHandlerAspect();
    }
}
