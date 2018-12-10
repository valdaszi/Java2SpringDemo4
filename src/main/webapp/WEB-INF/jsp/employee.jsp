<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

    <div class="container">
        <h2>Employees</h2>

        <%@ include file="pagination.jsp" %>

        <table class="table">
            <tr>
                <th>#</th>
                <th>Emp No</th>
                <th>First name</th>
                <th>Last name</th>
            </tr>

            <c:set var="index" scope="page" value="${offset + 1}"/>
            <c:forEach var="emp" items="${employees}">

                <tr>
                    <td>${index}</td>
                    <td>${emp.empNo}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                </tr>

                <c:set var="index" value="${index + 1}" scope="page"/>

            </c:forEach>

        </table>
    </div>

</body>
</html>
