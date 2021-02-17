<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17/02/2021
  Time: 8:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Create</title>
</head>
<body>
<h1>Tạo mới sản phẩm</h1>
<form method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" placeholder="Enter id"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" placeholder="Enter name"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" placeholder="Enter price"></td>
        </tr>
        <tr>
            <td><input type="submit" value="create"></td>
        </tr>
    </table>
</form>
</body>
</html>
