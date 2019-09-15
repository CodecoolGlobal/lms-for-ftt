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

<h2>List of all solutions</h2>


<table>
    <tr>
        <th>Assignment title</th>
        <th>Student</th>
        <th>Max score</th>
        <th>Given score</th>
    </tr>

    <c:forEach var="solution" items="${solutions}">
        <tr>
           <td> ${solution.getTitle()}</td>
           <td> ${solution.getUserName()}</td>
           <td> ${solution.getMaxScore()}</td>
           <td>
                <c:choose>
                     <c:when test="${not empty solution.getScore()}">
                          ${solution.getScore()}
                     </c:when>
                </c:choose>
           </td>
           <td>
               <form action="scoring" method="post">
                   <input type="hidden" name="assignmentID" value="${solution.assignmentId}">
                   <input type="hidden" name="userID" value="${solution.userId}">
                   <td><input type="Submit" value="Add score"></td>
                </form>
           </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
