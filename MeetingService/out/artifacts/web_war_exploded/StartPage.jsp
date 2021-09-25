<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Searching for friends///</title>

  </head>
  <body>

  <center>

  <form action="StartP" method="get">
    <input type="text" name="search" size="50"
           value="<c:out value="${param.search}"/>" placeholder="Find a friend with similar interests///" />
    <input type="submit" value="Search" />
  </form>
  </center>


    <form action="${pageContext.request.contextPath}/Login" method="post">
      <input type="submit" value="Logout"> 
    </form>

  <form action="${pageContext.request.contextPath}/test">
    <input type="hidden" name="nameOfObj" value="${sessionScope.name}" />
    <input type="submit" value="My Profile">
  </form>


  <c:choose>
  <c:when test="${not (empty param.search)}">

    <c:forEach items="${UserSearch}" var = "nameOfObj">
      <center><figure>
        <p><c:out value="${param.nameofobj}"/>
          <c:if test="${nameOfObj.getName()!=sessionScope.name}">
          <img src="${nameOfObj.getPhoto()}" width=15% height=30%>

            <form action="test" method="get" name="nameOfObj">
        <input type="submit" name="nameOfObj" value="${nameOfObj.getName()}">
            </form>

    </c:if>
        </p>
      </figure></center></br>
    </c:forEach>

  </c:when>

  <c:otherwise>

    <c:forEach items="${UserList.getUserObject()}" var = "nameOfObj">
      <center><figure>
        <p>
          <c:if test="${nameOfObj.getName()!=sessionScope.name}">
          <img src="${nameOfObj.getPhoto()}" width=15% height=30%>

           <form action="test" method="get" name="nameOfObj">
        <input type="submit" name="nameOfObj" value="${nameOfObj.getName()}">
          </form>

        </c:if>
        </p>
      </figure></center></br>
    </c:forEach>

  </c:otherwise>
  </c:choose>








  </body>
</html>