<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.java.util.URL"%>
<!doctype html>
<html lang="en">

<head>
    <title>Thêm mới trạng thái</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <!-- BEGIN NAVBAR -->
     <jsp:include page="/WEB-INF/components/navbar.jsp"></jsp:include>
    <!-- END NAVBAR -->
    <div class="container">
        <div class="row mt-4">
            <div class="col-5 m-auto">
                <h2 class="mb-4">Thêm mới trạng thái</h2>
                <form action="<%=request.getContextPath()%>/<%=URL.INDEX_STATUS %>/<%=URL.ADD_STATUS %>"method="POST">
                    <div class="form-group">
                        <label>Tên trạng thái</label>
                        <input type="text" class="form-control" name="name"/>
                    </div>
          
                    
                    <button class="btn btn-primary">Lưu lại</button>
                    <a href="<%=request.getContextPath()%>/<%=URL.INDEX_STATUS %>" class="btn btn-secondary">Quay lại</a>
                </form>
            </div>
        </div>
    </div>

</body>

</html>