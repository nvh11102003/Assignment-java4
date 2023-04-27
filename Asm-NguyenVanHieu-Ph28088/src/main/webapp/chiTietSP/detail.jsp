<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 29/3/2023
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/chi-tiet-san-pham/update?id=${ctsp.id}" method="post" class="container">

    <div class="row mt-4">
    <div class="col-6">
        <label>Tên sản phẩm </label>
        <select name="tenSP">
            <c:forEach items="${listSP}" var="sp">
                <option value="${sp.tenSP}" ${sp.tenSP==ctsp.sanPham.tenSP?"selected":""}>${sp.tenSP}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-6">
        <label>Tên màu sắc </label>
        <select name="tenMauSac">
            <c:forEach items="${listMS}" var="ms">
                <option value="${ms.tenMauSac}" ${ms.tenMauSac==ctsp.mauSac.tenMauSac?"selected":""}>${ms.tenMauSac}</option>
            </c:forEach>
        </select>
    </div>
    </div>
    <div class="row mt-4">
    <div class="col-6">
        <label>Tên Dòng sản phẩm </label>
        <select name="tenDSP">
            <c:forEach items="${listDSP}" var="dsp">
                <option value="${dsp.tenDSP}" ${dsp.tenDSP==ctsp.dongSP.tenDSP?"selected":""}>${dsp.tenDSP}</option>
            </c:forEach>
        </select>
    </div>
        <br>
        <br>
    <div class="col-6">
        <label>Tên NSX </label>
        <select name="tenNSX">
            <c:forEach items="${listNSX}" var="nsx">
                <option value="${nsx.tenNSX}" ${nsx.tenNSX==ctsp.nSX.tenNSX?"selected":""}>${nsx.tenNSX}</option>
            </c:forEach>
        </select>
    </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Nam BH</label>
        <div class="col-sm-10">
            <input value="${ctsp.namBH}" class="form-control" type="text" name="namBH"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">MoTa</label>
        <div class="col-sm-10">
            <input value="${ctsp.moTa}" class="form-control" type="text" name="moTa"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">SoLuongTon</label>
        <div class="col-sm-10">
            <input value="${ctsp.soLuongTon}" class="form-control" type="text" name="soLuongTon"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">GiaNhap</label>
        <div class="col-sm-10">
            <input value="${ctsp.giaNhap}" class="form-control" type="text" name="giaNhap"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">GiaBan</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="giaBan" value="${ctsp.giaBan}"><br>
        </div>
    </div>

    </div>

    <button type="submit" class="btn btn-primary" role="button">
        update
    </button>
</form>
</body>
</html>
