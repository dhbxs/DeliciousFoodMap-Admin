package delicious.food.map.config.aop;


import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import delicious.food.map.common.StatusCode;
import delicious.food.map.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 限流切面
 *
 * @author dhbxs
 * @since 2025/06/16 14:27
 */
@Slf4j
@Aspect
@Component
public class RateLimitAspect {

    /**
     * 不同的接口，不同的流量控制
     * map的key为 Limiter.key
     */
    private final Map<String, RateLimiter> limitMap = Maps.newConcurrentMap();

    @Order(1)
    @Around("@annotation(rateLimit)")
    public Object around(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable{

        if (rateLimit != null) {
            //key作用：不同的接口，不同的流量控制
            String key=rateLimit.key();
            RateLimiter rateLimiter = null;
            //验证缓存是否有命中key
            if (!limitMap.containsKey(key)) {
                // 创建令牌桶
                rateLimiter = RateLimiter.create(rateLimit.permitsPerSecond());
                limitMap.put(key, rateLimiter);
                log.info("新建了令牌桶={}，容量={}",key,rateLimit.permitsPerSecond());
            }
            rateLimiter = limitMap.get(key);
            // 拿令牌
            boolean acquire = rateLimiter.tryAcquire(rateLimit.timeout(), rateLimit.timeunit());
            // 拿不到命令，直接返回异常提示
            if (!acquire) {
                log.debug("令牌桶={}，获取令牌失败",key);
                throw new BusinessException(StatusCode.SYSTEM_ERROR, rateLimit.msg());
            }
        }
        return joinPoint.proceed();
    }
}
