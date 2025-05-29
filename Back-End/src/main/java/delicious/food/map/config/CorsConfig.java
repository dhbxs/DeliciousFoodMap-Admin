package delicious.food.map.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 开启跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 设置允许的请求头类型
                .allowedHeaders("*")
                // 设置允许跨域请求的方法
                .allowedMethods("GET", "POST")
                // 是否允许证书（cookies）
                .allowCredentials(true)
                // 跨域允许的时间
                .maxAge(3600);
    }
}
