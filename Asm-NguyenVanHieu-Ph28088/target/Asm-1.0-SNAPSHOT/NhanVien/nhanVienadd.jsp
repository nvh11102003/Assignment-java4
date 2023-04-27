<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 31/3/2023
  Time: 2:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="/nhan-vien/add" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>Ma </label>
                <input type="text" class="form-control" name="ma"/>
            </div>
            <div class="col-6">
                <label>Ten </label>
                <input type="text" class="form-control" name="ten"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>tenDem </label>
                <input type="text" class="form-control" name="tenDem"/>
            </div>
            <div class="col-6">
                <label>ho</label>
                <input type="text" class="form-control" name="ho"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>gioiTinh </label>
                <input type="text" class="form-control" name="gioiTinh"/>
            </div>
            <div class="col-6">
                <label>NgaySinh</label>
                <input type="date" class="form-control" name="ngaySinh"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>diaChi </label>
                <input type="text" class="form-control" name="diaChi"/>
            </div>
            <div class="col-6">
                <label>sdt</label>
                <input type="text" class="form-control" name="sdt"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>matKhau </label>
                <input type="text" class="form-control" name="matkhau"/>
            </div>
            <div class="col-6">
                <label>TrangThai</label>
                <input type="text" class="form-control" name="trangThai"/>
            </div>
        </div>
        <div class="row mt-4" >
            <button class="btn btn-success col-1 m-3" type="submit">
                Add
            </button>
        </div>
    </form>
</section>
</body>
</html>
