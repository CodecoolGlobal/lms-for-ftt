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
    <link rel="stylesheet" href="../css/curriculum-mentor.css" type="text/css">
    <title>Hicool</title>
</head>
<body>
<h1>HiCool LMS</h1>
<div class="dropdown">
    <button class="dropbtn">Menu</button>
    <div class="dropdown-content">
        <a href="curriculum">Curriculum</a>
        <a href="profile">Profile</a>
        <a href="#">User list</a>
        <a href="#">Student solutions</a>
        <a href="add-text.jsp">Add text</a>
        <a href="add-assignment.jsp">Add assignment</a>
        <a href="#">Attendance</a>
    </div>
</div>
<h2>Text page list</h2>
<form action="curriculum" method="get">
    <ul>
        <c:forEach var="text" items="${texts}">
            <c:choose>
                 <c:when test="${text.isPublished()}">
                     <li><h3> ${text.getTitle()} </h3></li>
                     <li> ${text.getText()}</li>
                 </c:when>
            </c:choose>
            <br>
            <br>
        </c:forEach>
    </ul>
</form:form>

<h2>Assignment page list</h2>
    <ul>
        <c:forEach var="assignment" items="${assignments}">
            <c:choose>
               <c:when test="${assignment.isPublished()}">
                   <li><h3> ${assignment.getTitle()}<h3></li>
                   <li><b>Max score:</b> ${assignment.getMaxScore()}</li>
                   <li> ${assignment.getQuestion()}</li>
               </c:when>
            </c:choose>
        </c:forEach>
    </ul>

</body>
</html>

