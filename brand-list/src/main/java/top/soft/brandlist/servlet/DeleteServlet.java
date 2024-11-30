package top.soft.brandlist.servlet;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.brandlist.entity.Brand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 86189
 * @description: TODO
 * @date 2024/11/16 14:13
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Brand> brands = new ArrayList<>((List<Brand>) req.getServletContext().getAttribute("brands"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream(),"UTF-8"));
        String jsonData = reader.lines().collect(Collectors.joining());

        com.google.gson.Gson gson = new com.google.gson.Gson();
        Brand brand = gson.fromJson(jsonData, Brand.class);
        System.out.println(brand);
        brands.remove(brand);
        req.getServletContext().setAttribute("brands",brands);

    }

}
