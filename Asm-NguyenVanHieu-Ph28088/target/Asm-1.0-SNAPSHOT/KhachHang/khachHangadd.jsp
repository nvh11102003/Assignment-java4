<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/22/2023
  Time: 7:34 PM
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
    <form action="/khach-hang/add" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>id</label>
                <input type="text" class="form-control" name="id"/>
            </div>
            <div class="col-6">
                <label>Tên </label>
                <input type="text" class="form-control" name="ten"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Mã Kh </label>
                <input type="text" class="form-control" name="ma"/>
            </div>
            <div class="col-6">
                <label>Tên Đệm </label>
                <input type="text" class="form-control" name="tenDem"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Họ </label>
                <input type="text" class="form-control" name="ho"/>
            </div>
            <div class="col-6">
                <label>Ngày Sinh </label>
                <input type="text" class="form-control" name="ngaySinh"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>SĐT </label>
                <input type="text" class="form-control" name="sdt"/>
            </div>
            <div class="col-6">
                <label>Địa chỉ </label>
                <input type="text" class="form-control" name="diaChi"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Thành Phố  </label>
                <input type="text" class="form-control" name="thanhPho"/>
            </div>
            <div class="col-6">
                <label>Quốc Gia </label>
                <input type="text" class="form-control" name="quocGia"/>
            </div>
        </div>
            <div class="col-6">
                <label>Mật khẩu  </label>
                <input type="text" class="form-control" name="matKhau"/>
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
