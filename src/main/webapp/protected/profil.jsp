<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
</head>
<body>
<h1>Profile settings</h1>
<p>User ID: <c:out value="${user.userId}"/></p>
<p>Role: <c:out value="${user.role}"/></p>
<p>Email: <c:out value="${user.email}"/></p>
<p>Name: <c:out value="${user.name}"/></p>
<p>Password: <c:out value="${user.password}"/></p>
<form class="modify" method="post" action="myProfil">
    <%-- <input type="text" name="name" placeholder="${name}" readonly>--%>
    <input type="text" placeholder="Add new name" id = "username" name="fullname" pattern="[A-Za-z ]{0,32}">
    <input type="submit" value="Update"></a>
</form>
</form>
<form method="post" action="logout">
    <input type="submit" value="Logout">
</form>
<br>
<li><a href="curriculum">to mentors page</a></li>
</body>
</html>
