<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.curriculum.Solution" %>
<%@ page import="com.codecool.web.model.curriculum.Answer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/style2.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Hicool-mentor-solution</title>
</head>
<body>
<jsp:include page="menu-header.jsp" />
<br>
<jsp:include page="header.jsp" />

<h2>${user.getName()} these are your solutions</h2>


<table>
    <tr>
        <th>Assignment title</th>
        <th>Solution</th>
        <th>Max score</th>
        <th>Achieved score</th>
    </tr>

    <c:forEach var="solution" items="${solutions}">
        <tr>
           <td> ${solution.getTitle()}</td>
           <td> ${solution.getMySolution()}</td>
           <td> ${solution.getMaxScore()}</td>
           <td><c:choose>
               <c:when test="${solution.score > solution.getMaxScore()}">
                    No score found.
               </c:when>
               <c:otherwise>
                    ${solution.getScore()}
               </c:otherwise>
           </c:choose></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>

