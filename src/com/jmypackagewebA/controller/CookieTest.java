package com.jmypackagewebA.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieTest extends HttpServlet {   //和session一样都是做状态管理的

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("username", "admin");  //创建cookie，有key和value
        cookie.setMaxAge(60*60*24*7); //最大存储时间，单位秒,正数有（相当于硬盘上存储），0不存储，负数会话结束
        cookie.setPath("/");  //设置匹配路径（以前版本）
        resp.addCookie(cookie);   //添加到浏览器，浏览器发送到服务器加set头再传到浏览器
        req.getRequestDispatcher("ckTest.jsp").forward(req,resp);
    }
}
