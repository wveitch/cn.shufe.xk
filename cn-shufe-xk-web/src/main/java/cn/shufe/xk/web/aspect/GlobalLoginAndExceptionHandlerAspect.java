package cn.shufe.xk.web.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class GlobalLoginAndExceptionHandlerAspect {
    @Pointcut(value = "execution(* cn.shufe.xk.web.controller..*(..))")
    public void pointcut() {
    }

    /**
     * 方法执行前，进行参数校验
     */
    @Before("pointcut()")
    public void validate(JoinPoint joinPoint) {
        // todo 登录校验
        log.info("执行前。。。。。。");
    }

    @Around("pointcut()")
    public Object execute(ProceedingJoinPoint pjp) {
        String methodName = pjp.getSignature().getName();
        try {
            log.info(String.format("provider 执行前，调用方法 %s，参数 {%s}",
                    pjp.getSignature(), JSON.toJSONString(pjp.getArgs())));
            return pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    public JoinPoint ddd(JoinPoint joinPoint, Throwable exception) {
        log.info(joinPoint.getSignature().getName());
        throw new IllegalArgumentException("异常通知测试", exception.getCause());
    }
}
