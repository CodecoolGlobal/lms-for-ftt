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

<h2>Student assignments</h2>

<table>
        <tr>
            <th>Question</th>
            <th>Max score</th>
            <th>View Assignment</th>
        </tr>
        <c:forEach var="as" items="${assignment}">
            <tr>
                <td>${as.getTitle()}</td>
                <td>${as.getMaxScore()}</td>
                <td>
                    <form class="" action="post-assignment" method="post">
                        <input type="hidden" name="id" value="${as.id}">
                        <input type="submit" value="Accomplish">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
