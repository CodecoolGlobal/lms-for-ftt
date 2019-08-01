<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="login">
    <tr>
        <td>E-mail</td>
        <td><input type="text" name="email"></td>
    </tr>
    <br/><br/>
    <tr>
        <td>Password</td>
        <td><input type="password" name="password"></td>
    </tr>
    <br/><br/>
    <input type="submit" value="Login">
</form>
<c:if test="${not empty error}">
    <c:out value="${error}"/>
</c:if>
</body>
</html>



