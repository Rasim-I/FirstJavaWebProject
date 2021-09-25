<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rasim_pie0rmx
  Date: 17.05.2020
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/Reg" method="post">
        Enter your name:
        <br>
        <input type="text" name ="name"
                    value="<c:out value="${param.name}"/>" placeholder="Peter">
        <br>
        Your age:<br>
        <input type="text" name="age"
                   value="<c:out value="${param.age}"/>" placeholder="98" /><br />
        Few words about yourself:<br>
        <input type="text" name="info"
               value="<c:out value="${param.info}"/>" placeholder="I like reading and swimming..." /><br />
        <br>
        Your phone number:<br>
        <input type="text" name="number"
               value="<c:out value="${param.number}"/>" placeholder="Your phone nubmer" /><br />
        <br>
        Pick a password:<br>
        <input type="text" name="password"
               value="<c:out value="${param.password}"/>" placeholder="1111" /><br />
        <br>
        <c:if test="${not(empty param.name and param.age and param.info and param.number and param.password)}">
        <input type="submit" value="Register" /><br>
    </form>
    </c:if>
</center>

</body>
</html>
