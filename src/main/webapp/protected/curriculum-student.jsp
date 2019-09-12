<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.curriculum.Text" %>
<%@ page import="com.codecool.web.model.curriculum.Assignment" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/style2.css">
    <title>Hicool</title>
</head>
<body>
<h1>HiCool LMS</h1>

<nav>
    <ul>
        <a href="profil.jsp"><li class="marked">Profile</li></a>
        <a href="userList.jsp"><li>UserList</li></a>
        <a href="curriculum"><li>Curriculum</li></a>
        <c:choose>
            <c:when test="${user.role == 'STUDENT'}">
                <a href="view-assignment"><li>Assignments</li></a>
                <a href="stats"><li>Statistics</li></a>
            </c:when>
            <c:otherwise>
                <a href="#"><li>Attendance</li></a>
                <a href="add-text.jsp"><li>Add text</li></a>
                <a href="add-assignment.jsp"><li>Add assignment</li></a>
                <a href="solutions"><li>Student Solutions</li></a>
            </c:otherwise>
        </c:choose>
        <a href="logout"><li>Logout</li></a>
    </ul>
</nav>
<jsp:include page="header.jsp" />


<h2>Text page list</h2>
<form action="curriculum" method="get">
    <ul>
        <c:forEach var="text" items="${texts}">
            <li><h3> ${text.getTitle()} </h3></li>
            <li> ${text.getText()}</li>
            <br>
            <br>
        </c:forEach>
    </ul>
</form>

<h2>Assignment page list</h2>
    <ul>
        <c:forEach var="assignment" items="${assignments}">
           <li><h3> ${assignment.getTitle()}</h3></li>
           <li><b>Max score:</b> ${assignment.getMaxScore()}</li>
           <li> ${assignment.getQuestion()}</li>
           <br>
           <br>
        </c:forEach>
    </ul>

</body>
</html>

