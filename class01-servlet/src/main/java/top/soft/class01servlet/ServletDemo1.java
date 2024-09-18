package top.soft.class01servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class ServletDemo1 implements Servlet {

    /**
     * Servlet初始化
     * @param servletConfig
     * @throws ServletException
     */

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo1 初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 执行 Service方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("servletDemo1 执行");
        System.out.println("service 执行");
    }

    /**
     * 获取 servlet 信息
     * @return
     */

    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 执行销毁方法
     */

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
