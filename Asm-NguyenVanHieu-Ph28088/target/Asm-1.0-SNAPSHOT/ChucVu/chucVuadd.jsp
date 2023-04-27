<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27/3/2023
  Time: 10:46 AM
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
<body class="container">
<%@include file="/layout/trangchu.jsp" %>
<br>
<section>
    <form action="/chuc-vu/add" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>Ma CV</label>
                <input type="text" class="form-control" name="maCV"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Ten CV</label>
                <input type="text" class="form-control" name="tenCV"/>
            </div>
        </div>
        <div class="row mt-4">
            <button onclick="location.href ='/ChucVu/chucVuadd.jsp'">Add</button>
        </div>
    </form>

</section>
</body>
</html>
