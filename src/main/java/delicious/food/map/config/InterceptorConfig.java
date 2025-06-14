package delicious.food.map.config;

import delicious.food.map.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统拦截器配置
 *
 * @author dhbxs
 * @since 2024/3/19 10:40
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations and resource handler requests.
     * Interceptors can be registered to apply to all requests or be limited
     * to a subset of URL patterns.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor jwtInterceptor = new JwtInterceptor();

        List<String> patterns = new ArrayList<>();
        patterns.add("/health/**");
        patterns.add("/sys-user/**");
        patterns.add("/poi-data/search");
        patterns.add("/category/get-all");


        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns(patterns);
    }
}
