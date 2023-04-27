<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 30/3/2023
  Time: 3:22 PM
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
<form action="/cua-hang/update?id=${cuaHang.idCH}" method="post" class="container">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ma CH</label>
        <div class="col-sm-10">
            <input value="${cuaHang.maCH}" class="form-control" type="text" name="maCH"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ten CH</label>
        <div class="col-sm-10">
            <input value="${cuaHang.tenCH}" class="form-control" type="text" name="tenCH"><br>
        </div>
    </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Dia Chi</label>
        <div class="col-sm-10">
            <input value="${cuaHang.diaChi}" class="form-control" type="text" name="diaChi"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Thanh Pho</label>
        <div class="col-sm-10">
            <input value="${cuaHang.thanhPho}" class="form-control" type="text" name="thanhPho"><br>
        </div>
    </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Quoc Gia</label>
        <div class="col-sm-10">
            <input value="${cuaHang.quocGia}" class="form-control" type="text" name="quocGia"><br>
        </div>
    </div>
    </div>
    <button type="submit">
        update
    </button>
</form>
</body>
</html>
