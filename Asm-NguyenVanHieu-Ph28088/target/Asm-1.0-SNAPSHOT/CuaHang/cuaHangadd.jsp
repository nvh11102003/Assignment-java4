<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 30/3/2023
  Time: 3:22 PM
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
    <form action="/cua-hang/add" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>Ma CH</label>
                <input type="text" class="form-control" name="maCH"/>
            </div>
            <div class="col-6">
                <label>Ten CH</label>
                <input type="text" class="form-control" name="tenCH"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Dia Chi</label>
                <input type="text" class="form-control" name="diaChi"/>
            </div>
            <div class="col-6">
                <label>Thanh Pho</label>
                <input type="text" class="form-control" name="thanhPho"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Quoc Gia</label>
                <input type="text" class="form-control" name="quocGia"/>
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
