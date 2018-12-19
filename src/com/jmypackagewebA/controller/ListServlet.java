package com.jmypackagewebA.controller;

import com.jmypackagewebA.pojo.Product;
import com.jmypackagewebA.pojo.User;
import com.jmypackagewebA.service.IProductService;
import com.jmypackagewebA.service.IUserService;
import com.jmypackagewebA.service.ProductServiceImpl;
import com.jmypackagewebA.service.UserServiceImpl;
import com.jmypackagewebA.utilTest.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    private IUserService uservice = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Map<String,Cookie> maps = CookieUtil.getCookie(cookies);
        //System.out.println(maps);
        Cookie coo = maps.get("username");  //找到这个cookie对象
        /*System.out.println(coo.getName());
        System.out.println(coo);*/
        String uname = coo.getValue();
        //System.out.println(uname);
        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("user");
        List<Product> lists = service.getLists();
        req.setAttribute("lists",lists);
        if (u==null){
            User user = uservice.getOne(uname);
            session.setAttribute("user",user);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }
    }
}
