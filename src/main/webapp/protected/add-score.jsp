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

<h2>Add score to solution</h2>
<h3>Assignment ID: ${solution.assignmentId}</h3>
<p>Assignment title: ${solution.title}</p>
<br>
<p> Student name: ${solution.userName}</p>
<br>
<p>Solution: ${solution.mySolution}</p>
<br>
    <form action="save-score" method="post">
        Please enter your score:
        <br>
        <input type="hidden" name="assignmentId" value="${solution.getAssignmentId()}">
        <input type="hidden" name="userId" value="${solution.userId}">
        <p><input type="number" name="score" min=0 max=${solution.getMaxScore()} placeholder="${solution.getMaxScore()}"></p>
        <br>
        <input type="Submit" value="SUBMIT">
    </form>
</body>

</html>
