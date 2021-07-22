package com.example.demo.Config;

import com.example.demo.Interceptor.AuthenticationInterceptor;
import com.example.demo.Interceptor.FangshuaInterceptor;
import com.example.demo.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器
        registry.addInterceptor(new FangshuaInterceptor()).addPathPatterns("/**");
        // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**");
        //拦截器 demo
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/interceptor/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源放行
        registry.addResourceHandler("/**").addResourceLocations(new String[]{"classpath:/static/","classpath:/META-INF/resources/"});
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/v2/api-docs", "/v2/api-docs").setKeepQueryParams(true);
        registry.addRedirectViewController("/swagger-resources/configuration/ui","/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/swagger-resources/configuration/security","/swagger-resources/configuration/security");
        registry.addRedirectViewController("/swagger-resources", "/swagger-resources");
    }

}
