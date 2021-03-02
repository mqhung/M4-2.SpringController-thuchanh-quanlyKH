
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update Customer</h1>
<form method="post">
    <input name="name" value="${customer.name}">
    <input name="email" value="${customer.email}">
    <input name="address" value="${customer.address}">
    <button type="submit">Edit</button>
</form>
</body>
</html>
