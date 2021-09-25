<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rasim_pie0rmx
  Date: 08.05.2020
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Profile</title>
</head>
<body>

<c:if test="${(nameOfPage==null) or (sessionScope.name==null)}">
    <%
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
        requestDispatcher.forward(request, response);
    %>
</c:if>

<form action="StartPage.jsp">
    <input type="submit" value="Back">
</form>

<div style="text-align: center;">
<a><img src="${pageContext.request.contextPath}/${nameOfPage.getPhoto()}" width=30% height=60%></a>
<br>


<br>My name is ${nameOfPage.getName()}<br>
<br>There is few words about me:<br> ${nameOfPage.getInfo()}<br>
<br>I'm ${nameOfPage.getAge()} years old.<br>
<br>
    <c:if test="${nameOfPage.getFriends().get(sessionScope.name)==true}">
        My number: ${nameOfPage.getNumber()}
    </c:if>
<br><br>


<c:if test="${sessionScope.name==nameOfPage.getName()}">
    My friends: <br>

    <c:forEach items="${UserList.friendList(nameOfPage)}" var = "nameOfObj">


            <form action="test" method="get" name="nameOfObj">
                <input type="submit" name="nameOfObj" value="${nameOfObj.getName()}">
            </form>

    </c:forEach>


    <table border="2">
    <tr bgcolor="aqua">You can edit your profile:</tr>

    <form action="UserPage" method="post"><br>
        <tr>Change info:</tr>
        <br><input type="text" name="changeInfo"><br>
        <tr>Change phone number:</tr>
        <br><input type="text" name="changePhone"><br>
        <tr>Change password:</tr>
        <br><input type="text" name="changePass"><br>
        <br><input type="submit" value="Edit">
    </form>
    </table>
</c:if>
</div>


<c:if test="${UserList.findUser(sessionScope.name).getFriends().get(nameOfPage.getName())==false}">
<form action="FriendRequest" method="get">
    <input type="hidden" name="request" value="true">
    <input type="hidden" name="nameOfPage" value="${nameOfPage.getName()}">
    <input type="submit" value="Send request to friend list">
</form>
</c:if>


<c:if test="${UserList.findUser(sessionScope.name).getFriends().get(nameOfPage.getName())==true}">
<form action="FriendRequest" method="get">
    <input type="hidden" name="request" value="false">
    <input type="hidden" name="nameOfPage" value="${nameOfPage.getName()}">
    <input type="submit" value="Delete from friends">
</form>
</c:if>

</body>
</html>
