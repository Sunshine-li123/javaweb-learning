package top.soft.class03response.response;

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
 * @description: TODO
 * @date 2024/9/28 14:54
 */
@WebServlet("/res")
public class ResponseTypeDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type){
            case "image":
                getImage(req,resp);
                break;
                case "pdf":
                getPdf(req,resp);
                break;
                case "word":
                getWord(req,resp);
                break;
            default:
               break;
        }
    }

    private void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/png");
        String realPath = this.getServletContext().getRealPath("/images/WPS拼图0.png");
        File file = new File(realPath);
        InputStream in=new FileInputStream(file);
        int read=0;
        ServletOutputStream out=resp.getOutputStream();
        while ((read=in.read())!=-1){
            out.write(read);
        }
        out.flush();
        out.close();
    }

    private void getPdf(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/pdf");
        String realPath = this.getServletContext().getRealPath("/pdf/大学生职业生涯报告_20231104090202.pdf");
        File file = new File(realPath);
        InputStream in=new FileInputStream(file);
        int read=0;
        ServletOutputStream out=resp.getOutputStream();
        while ((read=in.read())!=-1){
            out.write(read);
        }
        out.flush();
        out.close();
    }

    private void getWord(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/msword");
        String realPath = this.getServletContext().getRealPath("/words/ResponseTypeDemo测试文本.doc");
        File file = new File(realPath);
        InputStream in=new FileInputStream(file);
        int read=0;
        ServletOutputStream out=resp.getOutputStream();
        while ((read=in.read())!=-1){
            out.write(read);
        }
        out.flush();
        out.close();
    }

}
