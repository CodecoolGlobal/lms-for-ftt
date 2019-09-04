<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.user.User" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>My Profile</title>
</head>

<html lang="en">
<body>

<div class="navbar" align="center">
    <a href="protected/profil.jsp">profile</a>
    <a href="userlist">List users</a>
    <a href="logout">Logout</a>
</div>
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
