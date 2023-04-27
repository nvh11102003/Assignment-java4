<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/14/2023
  Time: 4:15 PM
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
<h3 class="text-center">Nhân Viên</h3>
<form action="/nhan-vien/add" method="post">
    <div class="row mt-4">
        <div class="col-6">
            <label>Tên Cửa Hàng </label>
            <select name="tenCH">
                <c:forEach items="${listCH}" var="ch">
                    <option value="${ch.tenCH}">${ch.tenCH}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6">
            <label>Tên Chức Vụ </label>
            <select name="tenCV">
                <c:forEach items="${listCV}" var="cv">
                    <option value="${cv.tenCV}">${cv.tenCV}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row mt-4">

        <div class="col-6">
            <label class="col-sm-2 col-form-label">Giới Tính</label>

            <label><input type="radio" name="gioiTinh" value="0" checked>Nam</label>


            <label><input type="radio" name="gioiTinh" value="1">Nu</label>

        </div>
        <div class="col-6">
            <label>Trạng thái </label>
            <select name="trangThai" class="col-sm-3" class="form-control" type="text">
                <option value="0">Nghỉ</option>
                <option value="1">Làm</option>
            </select>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-6">
            <label>Tên </label>
            <input type="text" class="form-control" name="ten"/>
        </div>
        <div class="col-6">
            <label>Mật khẩu </label>
            <input type="text" class="form-control" name="matkhau"/>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-6">
            <label>Mã </label>
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
            <label>Ngày Sinh</label>
            <div class="col-sm-10">
                <input class="form-control" type="date" name="ngaySinh"><br>
            </div>
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
        <button class="btn btn-success col-1 m-3" type="submit">
            Add
        </button>
    </div>
</form>
<table class="table table-bordered">
    <thead>
    <tr>

        <th scope="col">ma</th>
        <%--        <th scope="col">Tên</th>--%>
        <th scope="col">Mã Cửa hàng</th>
        <th scope="col">Mã Chức Vụ</th>
        <%--        <th scope="col">tenDem</th>--%>
        <th scope="col">Ho Va Ten</th>
        <th scope="col">gioiTinh</th>
        <th scope="col">ngaySinh</th>
        <th scope="col">sDT</th>
        <th scope="col">diaChi</th>
        <th scope="col">matKhau</th>
        <th scope="col">trangThai</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tboby>
        <c:forEach items="${listNV}" var="l">
            <tr>
                <td>${l.ma}</td>
                    <%--                <td></td>--%>
                <td>${l.cuaHang.maCH}</td>
                <td>${l.chucVu.maCV}</td>
                    <%--                <td>${}</td>--%>
                <td>${l.ho} ${l.tenDem} ${l.ten}</td>
                <td>
<%--                                                                        ${l.gioiTinh}--%>
                    <c:if test="${l.gioiTinh == 0}"> Nam</c:if>
                    <c:if test="${l.gioiTinh == 1}"> Nu</c:if>
                </td>
                <td>${l.ngaySinh}</td>
                <td>${l.sdt}</td>
                <td>${l.diaChi}</td>
                <td>${l.matkhau}</td>
                <td>
                        <%--                        ${l.trangThai}--%>
                    <c:if test="${l.trangThai==0}">Nghỉ</c:if>
                    <c:if test="${l.trangThai==1}">Làm</c:if></td>
                </td>
                <td>
                    <a href="/nhan-vien/detail?id=${l.id}" class="btn btn-primary" role="button" onclick="return confirm('Bạn có muốn xem chi tiết không?')">Detail</a>
                    <a href="/nhan-vien/delete?id=${l.id}" class="btn btn-danger " role="button" onclick="return confirm('Bạn có muốn xóa hay không')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tboby>
</table>
<%--<button onclick="location.href ='/nhanVien/NhanVien-add.jsp'"class="btn btn-success">Add</button>--%>
</body>
</html>
