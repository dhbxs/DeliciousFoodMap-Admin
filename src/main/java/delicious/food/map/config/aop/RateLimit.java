package delicious.food.map.config.aop;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;


/**
 * 限流注解
 *
 * @author: dhbxs
 * @since: 2025/06/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface RateLimit {
    /**
     * 资源的key,唯一
     * 作用：不同的接口，不同的流量控制
     */
    String key() default "";

    /**
     * 每秒派发多少个令牌，令牌桶容量与该值相同
     */
    double permitsPerSecond () ;

    /**
     * 获取令牌最大等待时间
     */
    long timeout();

    /**
     * 获取令牌最大等待时间的单位(例:分钟/秒/毫秒) 默认:毫秒
     */
    TimeUnit timeunit() default TimeUnit.MILLISECONDS;

    /**
     * 得不到令牌的提示语
     */
    String msg() default "系统繁忙，请稍后再试！";
}
