<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/02/2021
  Time: 8:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<form action="/product">
    <input value="search" name="action" hidden>
    <input type="text" name="name" placeholder="nhập tên" >
    <input type="submit" value="tìm kiếm">
</form>

<table>
    <tr>
        <td>name</td>
        <td>price</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${p}" var="product">
        <tr>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
