<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 30/3/2023
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%@include file="/layout/trangchu.jsp" %>
<br>
<form action="/Sanpham/update?id=${sanPham.id}" method="post" class="container">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ma SP</label>
        <div class="col-sm-10">
            <input value="${sanPham.maSP}" class="form-control" type="text" name="maSP"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ten SP</label>
        <div class="col-sm-10">
            <input value="${sanPham.tenSP}" class="form-control" type="text" name="tenSP"><br>
        </div>
    </div>
    </div>
    <button type="submit">
        update
    </button>
</form>

</body>
</html>
