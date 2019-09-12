<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.user.User" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style2.css">
    <meta charset="UTF-8">
    <title>My Profile</title>
</head>

<html lang="en">
<body>

<nav>
    <ul>
        <a href="profil.jsp"><li class="marked">Profile</li></a>
        <a href="userlist"><li>UserList</li></a>
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
<h1>Users</h1>
<br>
<div class="table-wrapper">
    <table class="table-container">
        <tr>
            <th>ID</th>
            <th>User</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>
                        ${user.userId}<br>
                </td>
                <td>
                        ${user.name}<br>
                </td>
                <td>
                        ${user.email}<br>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
