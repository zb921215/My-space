package com.company.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 拦截配置
        addInterceptor.addPathPatterns("/**");

        // 排除配置
        addInterceptor.excludePathPatterns("/");
        addInterceptor.excludePathPatterns("/checkSession");
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/doLogin");
    }

}
