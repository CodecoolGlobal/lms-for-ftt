<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sbcontainer">
    <div class="containerhead">
        <div class="title">Current User</div>
    </div>
    <div class="desc">
        <p>Welcome ${user.getName()}! You can see and edit your basic data and track your progress here.</p>
        <p>Name: ${user.getName()}</p>
        <p>Role: <c:out value="${user.role}"/></p>

    </div>

</div>

