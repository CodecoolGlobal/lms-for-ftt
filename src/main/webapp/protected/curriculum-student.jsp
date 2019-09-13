<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.curriculum.Text" %>
<%@ page import="com.codecool.web.model.curriculum.Assignment" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <<link rel="stylesheet" type="text/css" href="../css/style2.css">
    <title>Hicool</title>
</head>
<body>
<jsp:include page="menu-header.jsp" />
<br>
<jsp:include page="header.jsp" />

<h2>Text page list</h2>
<form action="curriculum" method="get">
    <ul>
        <c:forEach var="text" items="${texts}">
            <li><h3> ${text.getTitle()} </h3></li>
            <li> ${text.getText()}</li>
            <br>
            <br>
        </c:forEach>
    </ul>
</form:form>

<h2>Assignment page list</h2>
    <ul>
        <c:forEach var="assignment" items="${assignments}">
           <li><h3> ${assignment.getTitle()}<h3></li>
           <li><b>Max score:</b> ${assignment.getMaxScore()}</li>
           <li> ${assignment.getQuestion()}</li>
           <br>
           <br>
        </c:forEach>
    </ul>

</body>
</html>

