<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/14/2023
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PH28088</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="container">
<%@include file="/layout/trangchu.jsp" %>
<br>
<center><h3>Bảng Chi Tiết Sản Phẩm</h3></center>
<table class="table" >
    <form action="/chi-tiet-san-pham/add" method="post" class="container">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ten SP</label>
            <div class="col-sm-10">
                <select name="tenSP" value="${ctsp.sanPham.maSP}" >
                    <c:forEach items="${listSP}" var="sp">
                        <option value="${sp.tenSP}">${sp.tenSP}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ten DSP</label>
            <div class="col-sm-10">
                <select name="tenDSP" value="${ctsp.dongSP.maDSP}" >
                    <c:forEach items="${listDSP}" var="dsp">
                        <option value="${dsp.tenDSP}">${dsp.tenDSP}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ten MS</label>
            <div class="col-sm-10">
                <select name="tenMauSac" value="${ctsp.mauSac.maMauSac}" >
                    <c:forEach items="${listMS}" var="ms">
                        <option value="${ms.tenMauSac}">${ms.tenMauSac}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ten NSX</label>
            <div class="col-sm-10">
                <select name="tenNSX" value="${ctsp.nSX.maNSX}" >
                    <c:forEach items="${listNSX}" var="nsx">
                        <option value="${nsx.tenNSX}">${nsx.tenNSX}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">NamBH</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="namBH"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">MoTa</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="moTa"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">SoLuongTon</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="soLuongTon"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">GiaNhap</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="giaNhap"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">GiaBan</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="giaBan"><br>
            </div>
        </div>
        <button>Them</button>
    </form>

    <thead>
    <tr>
        <th scope="col">Ma SP</th>
        <th scope="col">Ma Mau Sac</th>
        <th scope="col">Ma DSP</th>
        <th scope="col">Ma NSX</th>
        <th scope="col">Nam BH</th>
        <th scope="col">moTa</th>
        <th scope="col">soLuongTon</th>
        <th scope="col">giaNhap</th>
        <th scope="col">giaBan</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tboby>
        <c:forEach items="${listCTSP}" var="l">
            <tr>
                <td>${l.sanPham.maSP}</td>
                <td>${l.mauSac.maMauSac}</td>
                <td>${l.dongSP.maDSP}</td>
                <td>${l.nSX.maNSX}</td>
                <td>${l.namBH}</td>
                <td>${l.moTa}</td>
                <td>${l.soLuongTon}</td>
                <td>${l.giaNhap}</td>
                <td>${l.giaBan}</td>
                <td>
                    <a href="/chi-tiet-san-pham/detail?id=${l.id}" class="btn btn-primary" role="button" onclick="return confirm('Bạn có muốn xem chi tiết không?')">Detail</a>
                    <a href="/chi-tiet-san-pham/delete?id=${l.id}" class="btn btn-danger " role="button" role="button" onclick="return confirm('Bạn có muốn xóa hay không')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tboby>
</table>

</body>
</html>
