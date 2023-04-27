<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 31/3/2023
  Time: 2:20 AM
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
    <form action="/nsx/add" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>Ma NSX</label>
                <input type="text" class="form-control" name="maNSX"/>
            </div>
            <div class="col-6">
                <label>Ten NSX</label>
                <input type="text" class="form-control" name="tenNSX"/>
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
