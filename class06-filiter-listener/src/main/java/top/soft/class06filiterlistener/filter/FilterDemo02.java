package top.soft.class06filiterlistener.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


/**
 * @author 86189
 * @description: TODO
 * @date 2024/11/23 13:38
 */
//@WebFilter("/*")
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo02初始化");
    }

    @Override
    public void destroy() {
        System.out.println("Filter02过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行资源前Filter02执行");

        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行资源之后Filter02执行");
    }
}
