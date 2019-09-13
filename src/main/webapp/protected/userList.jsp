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
<jsp:include page="menu-header.jsp" />
<br>
<jsp:include page="header.jsp" />

<h2>Users</h2>
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
                        ${user.userId}
                </td>
                <td>
                        ${user.name}
                </td>
                <td>
                        ${user.email}
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
