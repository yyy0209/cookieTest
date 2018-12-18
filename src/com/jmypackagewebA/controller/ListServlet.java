package com.jmypackagewebA.controller;

import com.jmypackagewebA.pojo.Product;
import com.jmypackagewebA.service.IProductService;
import com.jmypackagewebA.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        List<Product> lists = service.getLists();
        req.setAttribute("lists", lists);
        req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
    }
    /*public Map<String,Cookie> getCookie(Cookie[] cookies){
        Map<String,Cookie> maps = new HashMap<>();
        if (cookies==null){

        }
    }*/
}
