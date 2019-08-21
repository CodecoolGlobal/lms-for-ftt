<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Data</title>
    <link rel="stylesheet" type="text/css" href="css/regstyle.css">
</head>

<body>
<h1>Registration Form</h1>
<div class="ex">
    <form action="RegistrationServlet" method="post">

        <p>Name: <input class="tab" type="text" name="user_name" ></p>
        <p>E-mail: <input class="tab" type="text" name="email" ></p>
        <p>Password: <input class="tab" type="password" name="password" ></p>
        <select class="button" name = "role">
            <option>MENTOR</option>
            <option>STUDENT</option>
        </select>
        <input class="lbutton" type="submit" value="register" />
        <br>
        <br>
    </form>
</div>
<li><a href="login.jsp">LOGIN</a> </li>
</body>
</html>
