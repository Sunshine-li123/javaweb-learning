package top.soft.class02request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method= req.getMethod();
        System.out.println("获取请求方法"+method);


        String servletPath=req.getServletPath();
        System.out.println("获取请求路径"+servletPath);


        String queryString=req.getQueryString();
        System.out.println("获取请求参数"+queryString);


        String requestURI=req.getRequestURI();
        System.out.println("获取请求URI"+requestURI);
        StringBuffer requestURL=req.getRequestURL();
        System.out.println("获取请求URL"+requestURL);


        String protocol=req.getProtocol();
        System.out.println("获取版本协议"+protocol);

        String contextPath=req.getContextPath();
        System.out.println("获取虚拟目录"+contextPath);

    }
}
