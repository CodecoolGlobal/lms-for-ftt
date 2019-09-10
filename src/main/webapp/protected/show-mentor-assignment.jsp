<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.curriculum.Assignment" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="../css/curriculum-mentor.css" type="text/css"
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
        <a href="show-mentor-assignment.jsp">Accomplish assignment</a>
        <a href="#">Attendance</a>
    </div>
</div>
<h2>Mentor assignments</h2>

<form action="view-assignment" method="get">
    <ul>
        <c:forEach var="assignment" items="${assignments}">
                <li> ${assignment.getTitle()}</li>
                <li> ${assignment.getQuestion()}</li>
                <li> Max score: ${assignment.getMaxScore()}</li>
                <li> Published? ${assignment.isPublished()}</li>
                <br>
                <br>
            </tr>
        </c:forEach>
    </ul>
</form>

</body>
</html>
