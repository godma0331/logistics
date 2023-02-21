package com.mjj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration configuration = new CorsConfiguration();
        //configuration.addAllowedOriginPattern("http://localhost:8080");
        configuration.addAllowedOriginPattern("*");
        //是否允许发送Cookie信息
        configuration.setAllowCredentials(true);
        //允许哪些请求方式
        configuration.addAllowedMethod("*");
        //允许哪些header
        configuration.addAllowedHeader("*");
        //添加url映射路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(corsSource);
    }
}
