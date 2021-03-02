<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách Khách Hàng</h1>
<table>
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>

    </tr>
    <c:forEach items="${list}" var="customer">
        <tr>
            <td><a href="/customers/edit/${customer.id}">${customer.name}</a></td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
