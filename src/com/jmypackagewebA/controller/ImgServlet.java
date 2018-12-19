package com.jmypackagewebA.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.Field;
@MultipartConfig   //需要加这个才能接收
@WebServlet("/img")
public class ImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");   //接收
        //System.out.println(part.getName());
        //System.out.println(part.getSubmittedFileName());  //获取提交文件名
        /*文件上传后的存储路径和名称*/
        String str = "E:\\myjavacode1\\cookieTest\\web\\img\\"+part.getSubmittedFileName();
        File file = new File(str);
        String url = str.substring(str.indexOf("img"));  //截取
        System.out.println(url);
        /*输出流向指定位置写*/
        OutputStream os = new FileOutputStream(file);
        /*文件接收*/
        byte[] b = new byte[1024];
        InputStream is = part.getInputStream();
        int a = is.read(b, 0, b.length);  //读到b数组
        while (a!=-1){
            os.write(b);
            a=is.read(b, 0, b.length);
        }
    }
}
