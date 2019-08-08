<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/curriculum-mentor.css" type="text/css">
    <title>Hicool</title>
</head>
<body>
<h1>HiCool LMS</h1>
<div class="dropdown">
    <button class="dropbtn">Menu</button>
    <div class="dropdown-content">
        <a href="#">Curriculum</a>
        <a href="#">Profile</a>
        <a href="#">User list</a>
        <a href="#">Student solutions</a>
        <a href="#">Add text</a>
        <a href="#">Add assignment</a>
        <a href="#">Attendance</a>
    </div>
</div>
<h2>Page list</h2>
<form action="curriculum" method="get">
    <table>
        <tr>
            <th>Title</th>
            <th>Text</th>
            <th>Is published</th>
        </tr>
        <c:forEach var="page" items="pages ">
            <tr>
                <td>${page.getTitle}</td>
                <td>${page.getText}</td>
                <td>${page.isIsPublished}</td>
            </tr>

        </c:forEach>


    </table>
</form>


</body>
</html>
