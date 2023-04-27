<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/14/2023
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%@include file="/layout/trangchu.jsp" %>
<br>
<center><h3>Bảng Chức Vụ</h3></center>
<table class="table ">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">ma</th>
        <th scope="col">ten</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tboby>
        <c:forEach items="${listCV}" var="l">
            <tr>
                <td>${l.id}</td>
                <td>${l.maCV}</td>
                <td>${l.tenCV}</td>
                <td>
                    <a href="/chuc-vu/detail?id=${l.id}" class="btn btn-primary " role="button" onclick="return confirm('Bạn có muốn xem chi tiết không?')">Detail</a>
                    <a href="/chuc-vu/delete?id=${l.id}" class="btn btn-danger " role="button" onclick="return confirm('Bạn có muốn xóa hay không')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tboby>
</table>
<button onclick="location.href ='/ChucVu/chucVuadd.jsp'">Add</button>
</body>
</html>
