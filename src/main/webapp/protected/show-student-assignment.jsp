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
        <a href="view-assignment">Accomplish assignment</a>
        <a href="#">Attendance</a>
    </div>
</div>
<h2>Student assignments</h2>

<table>
        <tr>
            <th>Question</th>
            <th>Max score</th>
            <th>View Assignment</th>
        </tr>
        <c:forEach var="as" items="${assignment}">
            <tr>
                <td>${as.getTitle()}</td>
                <td>${as.getMaxScore()}</td>
                <td>
                    <form class="" action="post-assignment" method="post">
                        <input type="hidden" name="id" value="${as.id}">
                        <input type="submit" value="Accomplish">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
