<%@page import="com.java.util.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <title>Danh sách quyền</title>
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
        <div class="row">
            <div class="col-12 mt-4">
                <div class="row">
                    <div class="col-8">
                        <h2>Danh sách quyền</h2>
                    </div>
                    <div class="col-4 d-flex align-items-center justify-content-end">
                        <a href="<c:url value="/${URL.INDEX_ROLE }/${URL.ADD_ROLE}"/>" class="btn btn-primary">Thêm mới</a>
                    </div>
                </div>
                <table class="table table-bordered mt-3">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Tên quyền</th>
                             <th>Mô tả</th>
                             
                         
                            <th>#</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${listRole}" var="item">
	                    	<tr>
	                            <td>${ item.id }</td>
	                            <td>${ item.name }</td>
	                            <td>${ item.des }</td>
	                           
	                            <td class="w-25">
	                                <a href="<c:url value="/${URL.INDEX_ROLE }/${URL.EDIT_ROLE}?id=${item.id }" />" class="btn btn-sm btn-info">Sửa</a>
	                                <a href="<c:url value="/${URL.INDEX_ROLE }/${URL.DELETE_ROLE}?id=${item.id }"/>" class="btn btn-sm btn-danger">Xóa</a>
	                            </td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>

</html>