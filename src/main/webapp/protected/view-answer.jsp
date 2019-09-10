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
    <title>Hicool</title>
</head>

<body>
<h1>HiCool LMS</h1>
<p>Assignment ID: ${singleAnswer.getAssignmentID()}</p>
<p>Question: ${assignment.getQuestion()}</p>
<p>Solution: ${singleAnswer.getSolution()}</p>

</body>

</html>
