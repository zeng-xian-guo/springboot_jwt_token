package com.example.demo.Interceptor;

import com.example.demo.Annotation.UnInterception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class MyInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断请求是否属于方法的请求
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            String methodName = method.getName();
            logger.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);

            // 判断用户有没有登陆，一般登陆之后的用户都有一个对应的token
            String token = request.getParameter("token");
            if (null == token || "".equals(token)) {
                logger.info("用户未登录，没有权限执行……请登录");
                return false;
            }

            // @UnInterception 是我们自定义的注解，通过方法上的自定义注解来判断该方法是否要被拦截
            UnInterception unInterception = method.getAnnotation(UnInterception.class);
            if (null != unInterception) {
                return true;
            }

            //-----------------------------拦截处理逻辑开始-----------------------------
            //-----------------------------拦截处理逻辑结束-----------------------------

        }
        // 返回true才会继续执行，返回false则取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("执行完方法之后进执行(Controller方法调用之后)，但是此时还没进行视图渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("整个请求都处理完咯，DispatcherServlet也渲染了对应的视图咯，此时我可以做一些清理的工作了");
    }
}
