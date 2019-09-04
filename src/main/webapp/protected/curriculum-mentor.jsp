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
    <link rel="stylesheet" href="../css/curriculum-mentor.css" type="text/css">
    <title>Hicool</title>
</head>
<body>
<h1>HiCool LMS</h1>
<div class="dropdown">
    <button class="dropbtn">Menu</button>
    <div class="dropdown-content">
        <a href="curriculum">Curriculum</a>
        <a href="profile">Profile</a>
        <a href="userlist">User list</a>
        <a href="#">Student solutions</a>
        <a href="add-text.jsp">Add text</a>
        <a href="add-assignment.jsp">Add assignment</a>
        <a href="#">Attendance</a>
    </div>
</div>
<h2>Text page list</h2>
<form action="publishServlet" method="post">
    <table>
        <tr>
            <th>Title</th>
            <th>Published</th>
            <th> Set to change</th>
        </tr>

        <c:forEach var="text" items="${texts}">
            <tr>
                <td> ${text.getTitle()}</td>
                <td> ${text.isPublished()}</td>
                <td>
                    <c:choose>
                         <c:when test="${text.isPublished()}">
                             <input type="checkbox" name="publish_text" value= "${text.getId()}"
                                    unchecked/>
                         </c:when>
                         <c:otherwise>
                              <input type="checkbox" name="publish_text" value= "${text.getId()}"
                                     unchecked/>
                         </c:otherwise>
                    </c:choose></td>
            </tr>
        </c:forEach>
    </table>
    <td><input type="submit" value="Submit"></td>
</form:form>

<h2>Assignment page list</h2>
<table>
    <tr>
        <th>Title</th>
        <th>Maximum score</th>
        <th>Is published</th>
        <th> Set to change</th>
    </tr>

    <c:forEach var="assignment" items="${assignments}">
        <tr>
            <td> ${assignment.getTitle()}</td>
            <td> ${assignment.getMaxScore()}</td>
            <td> ${assignment.isPublished()}</td>

            <td> <c:choose>
                       <c:when test="${assignment.isPublished()}">
                           <input type="checkbox" name="publish_assignment" value="${assignment.getId()}"
                                  unchecked/>
                       </c:when>
                       <c:otherwise>
                           <input type="checkbox" name="publish_assignment" value="${assignment.getId()}"
                                  unchecked/>
                       </c:otherwise>
                  </c:choose></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
