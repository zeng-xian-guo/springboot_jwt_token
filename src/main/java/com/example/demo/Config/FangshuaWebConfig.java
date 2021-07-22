package com.example.demo.Config;

import com.example.demo.Interceptor.FangshuaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FangshuaWebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private FangshuaInterceptor fangshuaInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(fangshuaInterceptor);
    }

}
