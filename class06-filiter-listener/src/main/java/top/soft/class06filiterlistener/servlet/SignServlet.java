package top.soft.class06filiterlistener.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author 86189
 * @description: TODO
 * @date 2024/11/23 16:40
 */
@WebServlet("/signServlet")
public class SignServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        System.out.println(name);
        resp.setContentType("text/html;charset=utf-8");
        req.getSession().setAttribute("username",name);
        resp.sendRedirect("/detail.jsp");
    }
}
