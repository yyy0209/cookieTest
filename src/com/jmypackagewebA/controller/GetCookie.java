package com.jmypackagewebA.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/coo/getCookie")
public class GetCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies(); //获取浏览器上所有cookie
        HttpSession session = req.getSession();  //获取session信息
        session.setMaxInactiveInterval(20); //最大活跃时间，到时间不动就结束
        session.invalidate();  //消除会话
        session.getId(); //获取sessionID
        /*req.getSession(true);  //flase  */
        for (Cookie c:cookies
             ) {
            System.out.println(c.getName());
            System.out.println(c.getValue());
        }
    }
}
