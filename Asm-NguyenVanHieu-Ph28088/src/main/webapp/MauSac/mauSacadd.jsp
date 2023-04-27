<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 31/3/2023
  Time: 2:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<body class="container">
<%@include file="/layout/trangchu.jsp" %>
<br>
<section>
    <form action="/mau-sac/add" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>Ma MS</label>
                <input type="text" class="form-control" name="maMauSac"/>
            </div>
            <div class="col-6">
                <label>Ten MS</label>
                <input type="text" class="form-control" name="tenMauSac"/>
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
