package top.soft.class03response.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 86189
 * @description: 通过sc 获取文件内容
 * @date 2024/9/28 16:42
 */
@WebServlet("/servletContextDemo02")
public class ServletContextDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext=req.getServletContext();
        resp.setContentType("text/html;charset=utf-8");
        //获取Webapp目录下资源
        String path=servletContext.getRealPath("/a.txt");
        System.out.println(path);

        String path2=servletContext.getRealPath("/WEB-INF/b.txt");
        System.out.println(path2);

        String path3=servletContext.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(path3);

        File file=new File(path);
        InputStream in=new FileInputStream(file);
        ServletOutputStream out=resp.getOutputStream();
        int read=0;
        while ((read=in.read())!=-1){
            out.write(read);
        }
        in.close();
        out.flush();
        out.close();

    }
}
