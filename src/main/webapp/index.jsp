<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Demo</title>
</head>
<body>
    <h2>Spring Demo 4 - Security</h2>

    <sec:authorize access="isAuthenticated()">
        <h3>Welcome Back, <sec:authentication property="name"/></h3>
    </sec:authorize>

    <a href="employee">List of Employees</a>

    <sec:authorize access="hasRole('USER')">
        <a href="secure">Only for users</a>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <a href="admin">Administrator</a>
    </sec:authorize>

    <hr>

    <!-- c:url naudojamas gauti url pagal konteksta -->
    <sec:authorize access="!isAuthenticated()">
        <c:url var="loginUrl" value="/login"/>
        <a href="${loginUrl}">Login</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <c:url var="logoutUrl" value="/logout"/>
        <a href="${logoutUrl}">Logout</a>
    </sec:authorize>

</body>
</html>
