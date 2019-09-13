<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.curriculum.Assignment" %>
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

<h2>Mentor assignments</h2>

<form action="view-assignment" method="get">
    <ul>
        <c:forEach var="assignment" items="${assignments}">
                <li> ${assignment.getTitle()}</li>
                <li> ${assignment.getQuestion()}</li>
                <li> Max score: ${assignment.getMaxScore()}</li>
                <li> Published? ${assignment.isPublished()}</li>
                <br>
                <br>
            </tr>
        </c:forEach>
    </ul>
</form>

</body>
</html>
