<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.curriculum.Assignment" %>
<%@ page import="com.codecool.web.model.curriculum.Answer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/style2.css">
    <title>Hicool</title>
</head>

<body>
<jsp:include page="menu-header.jsp" />
<br>
<jsp:include page="header.jsp" />

<h2>Solution View</h2>
<h3>Id: ${assignment.id}</h3>
<p>${assignment.question}</p>
    <form action="solution" method="post">
        Please enter your solution:
        <br>
        <input type="hidden" name="id" value="${assignment.id}">
            <textarea type="text" name="solution" rows="5" cols="30"></textarea>
            <br>
            <input type="SUBMIT" value="Submit">
    </form>
</body>

</html>
