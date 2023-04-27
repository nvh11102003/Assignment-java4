<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 31/3/2023
  Time: 2:59 AM
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
<body class="container">
<%@include file="/layout/trangchu.jsp" %>
<br>
<section>
    <form action="/nhan-vien/update?id=${nhanVien.id}" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>Tên Cửa Hàng </label>
                <select name="tenCH">
                    <c:forEach items="${listCH}" var="ch">
                        <option value="${ch.tenCH}" ${ch.tenCH == nhanVien.cuaHang.tenCH?"selected":""}>${ch.tenCH}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Tên Chức Vụ </label>
                <select name="tenCV">
                    <c:forEach items="${listCV}" var="cv">
                        <option value="${cv.tenCV}" ${cv.tenCV == nhanVien.chucVu.tenCV?"selected":""}>${cv.tenCV}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label class="col-sm-2 col-form-label">Giới Tính</label>
                <label><input type="radio" name="gioiTinh" value="0"${nhanVien.gioiTinh == 0?"checked" : "" }>Nam</label>
                <label><input type="radio" name="gioiTinh" value="1"${nhanVien.gioiTinh ==1?"checked": "" }>Nu</label>
            </div>
            <div class="col-6">
                <label>Trạng thái </label>
                <select name="trangThai" class="col-sm-5" class="form-control" type="text">
                    <option value="0"${nhanVien.trangThai==0 ?"selected":"" }>Nghỉ</option>
                    <option value="1"${nhanVien.trangThai==1 ?"selected":""}>Làm</option>
                </select>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Tên </label>
                <input type="text" class="form-control" name="ten" value="${nhanVien.ten}"/>
            </div>
            <div class="col-6">
                <label>Mật khẩu </label>
                <input type="text" class="form-control" name="matkhau" value="${nhanVien.matkhau}"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Mã </label>
                <input type="text" class="form-control" name="ma" value="${nhanVien.ma}"/>
            </div>
            <div class="col-6">
                <label>Tên Đệm </label>
                <input type="text" class="form-control" name="tenDem" value="${nhanVien.tenDem}"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Họ </label>
                <input type="text" class="form-control" name="ho" value="${nhanVien.ho}"/>
            </div>
            <div class="col-6">
                <label>Ngày Sinh</label>
                <div class="col-sm-10">
                    <input class="form-control" type="date" name="ngaySinh" value="${ngaySinh}"><br>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>SĐT </label>
                <input type="text" class="form-control" name="sdt" value="${nhanVien.sdt}"/>
            </div>
            <div class="col-6">
                <label>Địa chỉ </label>
                <input type="text" class="form-control" name="diaChi" value="${nhanVien.diaChi}"/>
            </div>
        </div>



        <div class="row mt-4">
            <button class="btn btn-success col-1 m-3" type="submit">
                Update
            </button>
        </div>
    </form>
</section>
</body>
</html>
