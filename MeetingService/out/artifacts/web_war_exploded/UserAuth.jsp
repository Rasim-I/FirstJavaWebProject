<%--
  Created by IntelliJ IDEA.
  User: rasim_pie0rmx
  Date: 08.05.2020
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${not (empty error)}">
    <a>${error}</a>
</c:if>

<form action="${pageContext.request.contextPath}/PhotoUpload.jsp">
    <input type="submit" value="Register">
</form>


<form action="${pageContext.request.contextPath}/StartP" method="post">
    <br>Login:<select name ="name">
    <c:forEach items="${UserList.getUsers()}" var = "name">
        <option><c:out value="${name}"/></option>
    </c:forEach>
</select>
    <br>Password: <input type="text" name="password">
    <input type="submit" value="Login" /><br>
</form>
</body>
</html>
