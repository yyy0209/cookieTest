<%--
  Created by IntelliJ IDEA.
  User: abd
  Date: 2018/12/18
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="img" method="post" enctype="multipart/form-data"> <%--指定传输类型--%>
        <input type="file" name="file">  <%--文件选择按钮--%>
        <input type="submit">
    </form>
</body>
</html>
