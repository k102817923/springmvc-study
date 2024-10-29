package com.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// SpringMVC 的处理器拦截器类似于 Servlet 开发中的过滤器 Filter，用于对处理器进行预处理和后处理。开发者可以自己定义一些拦截器来实现特定的功能
// 过滤器与拦截器的区别：拦截器是 AOP 思想的具体应用
// 过滤器：Servlet 规范中的一部分，任何 Java Web 工程都可以使用；在 url-pattern 中配置了 /* 之后，可以对所有要访问的资源进行拦截
// 拦截器：拦截器是 SpringMVC 框架自己的，只有使用了 SpringMVC 框架的工程才能使用；拦截器只会拦截访问的控制器方法，如果访问的是 jsp、html、css、image、js，是不会进行拦截的
public class MyInterceptor implements HandlerInterceptor {


    // 在请求处理的方法之前执行
    // 如果返回 true，执行下一个拦截器
    // 如果返回 false，不执行下一个拦截器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("======处理前======");
        return true;
    }

    // 在请求处理的方法执行之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("======处理后======");
    }

    // 在 dispatcherServlet 处理后执行，做清理工作
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("======清理中======");
    }

}
