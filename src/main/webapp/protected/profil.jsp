<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style2.css">
    <title>User profil</title>

</head>
<body>
<script type="text/javascript">
    function editName() {
        var popup = document.getElementById("editName");
        popup.classList.toggle("show");
    }
    function editMail() {
        var popup = document.getElementById("editMail");
        popup.classList.toggle("show");
    }
    function editPassword() {
        var popup = document.getElementById("editPassword");
        popup.classList.toggle("show");
    }
    function editRole() {
        var popup = document.getElementById("editRole");
        popup.classList.toggle("show");

    }
</script>
<nav>
    <ul>
        <a href="profile.jsp"><li class="marked">Profile</li></a>
        <a href="userlist"><li>UserList</li></a>
        <a href="curriculum"><li>Curriculum</li></a>
        <c:choose>
            <c:when test="${user.role == 'STUDENT'}">
                <a href="assignments"><li>Assignments</li></a>
                <a href="stats"><li>Stats</li></a>
            </c:when>
            <c:otherwise>
                <a href="attendance"><li>Attendance</li></a>
                <a href="solutions"><li>Student Solutions</li></a>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>
<jsp:include page="header.jsp" />

<div class="wrapper">
    <div class="content">

        <div class="container">
            <div class="containerhead">
                <div class="title">Profile</div>
            </div>
            <div class="second-piece">
                <table class="profil">
                    <tr>
                        <td>
                            <p>User ID: <c:out value="${user.userId}"/></p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>Role: <c:out value="${user.role}"/></p>
                            <form id="editRole" action="editRole" method="post" class="hide_form">
                                <label for="mentor" name=rbutton>Mentor</label>
                                <input type="radio" name="position" value="mentor" id="radio1">
                                <label for="student" name=rbutton>Student</label>
                                <input type="radio" name="position" value="student" id="radio2">
                                <input class="popupbutton" type = "submit" value = "Save" />
                            </form>
                        <td><i class="fa fa-spinner fa-spin fa-3x fa-fw" onclick="editRole()" style="font-size:24px; cursor:pointer"></i></td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>E-mail: <c:out value="${user.email}"/></p>
                            <form id="editMail" action="editMail" method="post" class="hide_form">
                                <input class="popupbox" type = "text" name = "mail">
                                <input class="popupbutton" type = "submit" value = "Save" />
                            </form>
                        <td><i class="fa fa-spinner fa-spin fa-3x fa-fw" onclick="editMail()" style="font-size:24px; cursor:pointer"></i></td>
                        </td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>Name: <c:out value="${user.name}"/></p>
                            <form id="editName" action="myProfil" method="post" class="hide_form">
                                <input class="popupbox" type = "text" name = "fullname">
                                <input class="popupbutton" type = "submit" value = "Save"/>
                            </form>
                        <td><i class="fa fa-spinner fa-spin fa-3x fa-fw" onclick="editName()" style="font-size:24px; cursor:pointer"></i></td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>Password: <c:out value="${user.password}"/></p>
                            <form id="editPassword" action="editPassword" method="post" class="hide_form">
                                <input class="popupbox" type = "text" name = "passw">
                                <input class="popupbutton" type = "submit" value = "Save" />
                            </form>
                        <td><i class="fa fa-spinner fa-spin fa-3x fa-fw" onclick="editPassword()" style="font-size:24px; cursor:pointer"></i></td>
                        </td>
                    </tr>
                </table>
            </div>

            <%--
            <h1>Profile settings</h1>
            <p>User ID: <c:out value="${user.userId}"/></p>
            <p>Role: <c:out value="${user.role}"/></p>
            <p>Email: <c:out value="${user.email}"/></p>
            <p>Name: <c:out value="${user.name}"/></p>
            <p>Password: <c:out value="${user.password}"/></p>
            <form class="modify" method="post" action="myProfil">
            -->
                <%-- <input type="text" name="name" placeholder="${name}" readonly>--%>
            <%--
                    <input type="text" placeholder="Add new name" id = "username" name="fullname" pattern="[A-Za-z ]{0,32}">
                    <input type="submit" value="Update"></a>
                </form>
                --%>
            <div>
                <td>
                    <form method="post" action="curriculum">
                        <input type="submit" value="To curriculum">
                    </form>
                </td>
            </div>
        </div>
    </div>
    <div class="sidebar">
        <jsp:include page="sidebar.jsp" />
    </div>
</div>

</body>
</html>
