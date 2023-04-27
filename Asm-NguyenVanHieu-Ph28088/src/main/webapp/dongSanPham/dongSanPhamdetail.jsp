<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 30/3/2023
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<%@include file="/layout/trangchu.jsp" %>
<br>
<form action="/DongSanPham/update?id=${dongSanPham.id}" method="post" class="container">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ma DSP</label>
        <div class="col-sm-10">
            <input value="${dongSanPham.maDSP}" class="form-control" type="text" name="maDSP"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ten DSP</label>
        <div class="col-sm-10">
            <input value="${dongSanPham.tenDSP}" class="form-control" type="text" name="tenDSP"><br>
        </div>
    </div>
    </div>
    <button type="submit">
        update
    </button>
</form>
</body>
</html>
