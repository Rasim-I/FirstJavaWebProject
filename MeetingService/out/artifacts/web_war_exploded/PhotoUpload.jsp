<%--
  Created by IntelliJ IDEA.
  User: rasim_pie0rmx
  Date: 18.05.2020
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload a photo</title>
</head>
<body>
Download profile photo:<br>
<form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype = "multipart/form-data">
    <input type = "file" name = "file" size = "50" />
    <input type="submit" value="Download" /><br>
    <br />
</form>
</body>
</html>
