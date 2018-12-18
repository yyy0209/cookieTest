<%--
  Created by IntelliJ IDEA.
  User: abd
  Date: 2018/12/11
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            width: 100px;
            height: 100px;
            background-color: aqua;
        }
    </style>
</head>
<body>
    <%--这个是a的jsp测试--%>
    <div>
        <%
           /* request.getAttribute("key"); //这个是取内容*/
            System.out.println(request.getAttribute("key"));
        %><%--这个符号里面可以直接写java代码--%>
    </div>
</body>
</html>
