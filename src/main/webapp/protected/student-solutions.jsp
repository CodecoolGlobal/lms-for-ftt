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
    <link rel="stylesheet" href="../css/curriculum-mentor.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Hicool-mentor-solution</title>
</head>
<body>
<h1>Hi...C.ool LMS</h1>

<h2>${user.getName()} these are your solutions</h2>


<table>
    <tr>
        <th>Question</th>
        <th>Solution</th>
        <th>Max score</th>
        <th>Achieved score</th>
    </tr>

    <c:forEach var="solution" items="${solutions}">
        <tr>
           <td> ${solution.getQuestion()}</td>
           <td> ${solution.getMySolution()}</td>
           <td> ${solution.getMaxScore()}</td>
           <c:choose>
              <c:when test="${solution.getScore() == 0}">
                  <td>No score found.</td>
              </c:when>
              <c:otherwise>
               <td>${solution.getScore()}</td>
               </c:otherwise>
           </c:choose>
        </tr>
    </c:forEach>
</table>


</body>
</html>

