package com.example.demo.Interceptor;

import com.example.demo.Annotation.AccessLimit;
import com.example.demo.Redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FangshuaInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        //判断请求是否属于方法的请求
        if(handler instanceof HandlerMethod){

            HandlerMethod hm = (HandlerMethod) handler;

            //获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if(accessLimit == null){
                return true;
            }

            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean login = accessLimit.needLogin();
            String key = request.getRequestURI();
            HttpSession session = request.getSession();
            //如果需要登录
            if(login){
                System.out.println("sessionId : " + session.getId());
                redisUtil.set(session.getId(),0,seconds);
            }

            Integer count = (Integer) redisUtil.get(session.getId());
            if(count < maxCount){
                redisUtil.incr(session.getId(),1);
            }else{
                return false;
            }
        }

        return true;

    }

}
