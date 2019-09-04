<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<div class="wrapper">
<h1>

    <form method="post" action="login">
        <tr>
            <td><input type="text" name="email" placeholder="email address"></td>
        </tr>
        <br/><br/>
        <tr>
            <td><input type="password" name="password"placeholder="password"></td>
        </tr>
        <br/><br/>
        <input type="submit" value="Login">
    </form>
    <c:if test="${not empty error}">
        <c:out value="${error}"/>
    </c:if>
    <p class="redirect">Not registered? <a href="index.jsp">Register now!</a></p>

</h1>
</div>
</body>
</html>



