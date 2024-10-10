package top.soft.class03response.pratice;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 86189
 * @description: TODO
 * @date 2024/9/29 10:04
 */

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，文件名
        String filename = req.getParameter("filename");

        String str=null;
        if(filename.contains(".NEF")){
            str="/images/"+filename;
        } else if (filename.contains(".txt")) {
            str="/WEB-INF/"+filename;
        }

        //找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath(str);

        //用字节流关联
        FileInputStream fis=new FileInputStream(realPath);

        //获取文件mime类型
        String mimeType = servletContext.getMimeType(filename);

        //设置响应头类型
        resp.setHeader("content-type",mimeType);

        //设置响应头打开方式
        resp.setHeader("Content-Disposition","attachment;filename="+filename);

        //获取输出流
        ServletOutputStream sos=resp.getOutputStream();
        byte[] bytes=new byte[1024*8];
        int len;
        while ((len=fis.read(bytes))!=-1){
            sos.write(bytes,0,len);
        }
        fis.close();
    }


}
