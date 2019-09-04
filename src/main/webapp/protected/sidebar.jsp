<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sbcontainer">
    <div class="containerhead">
        <div class="title">Current User</div>
    </div>
    <div class="desc">
        <p>Welcome ${user.getName()}! You can see and edit your basic data and track your progress here.</p>
        <p>Name: ${user.getName()}</p>
        <c:choose>
            <c:when test="${user.getClass().simpleName == 'Student'}">
                <p>Role: Student</p>
            </c:when>
            <c:otherwise>
                <p>Role: Mentor</p>
            </c:otherwise>
        </c:choose>
        <form action="logout" method="post">
            <input class="button" type="submit" value="Logout">
        </form>
    </div>

</div>

