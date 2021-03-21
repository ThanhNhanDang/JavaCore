<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.JAVA10.util.ServiceContant"%>

<%String path = request.getContextPath();%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Thêm mới thành viên</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
	<style><%@include file="/WEB-INF/JSP_file/css/bootstrap.min.css"%></style>
	<style><%@include file="/WEB-INF/JSP_file/css/style.css"%></style>
	
</head>

<body>

    <div class="d-flex justify-content-between">
        <!-- SIDE BAR -->
        <div id="side-bar">
            <div class="logo">ADMIN PAGE</div>
            <ul class="list-group rounded-0">
                <li class="dashboard">DASHBOARD</li>
                <li>
                    <a href="<%=path%>${ServiceContant.SERVICE_USER_LIST}">
                        <i class="fa fa-user mr-2"></i> Quản lý thành viên
                    </a>
                </li>
                <li>
                    <a href="<%=path%>${ServiceContant.SERVICE_ROLE_LIST}">
                        <i class="fa fa-book mr-2"></i>	Quản lý quyền
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-cogs mr-2"></i> Cấu hình hệ thống
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-slack mr-2"></i> Thông tin khác
                    </a>
                </li>
            </ul>
        </div>

        <div id="admin-wrapper">
            <!-- HEADER -->
            <nav class="navbar navbar-expand-sm navbar-light bg-light w-100">
                <a class="navbar-brand" href="#"><i class="fa fa-align-justify"></i></a>
                <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                    data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation"></button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="dropdownId"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cybersoft
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownId">
                                <a class="dropdown-item" href="<%=path%>${ServiceContant.SERVICE_HOME }">Thông tin cá nhân</a>
                                <a class="dropdown-item" href="#">Cài đặt</a>
                                <a class="dropdown-item" href="#">Thoát</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>

            <!-- CONTENT -->
            <section id="admin-content" class="p-3">
                <h3 class="mb-4">Thêm mới nhân viên</h3>
                <form method="post" action="">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" name="email" class="form-control" placeholder="email" />
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu</label>
                                <input type="password" name="password" class="form-control" placeholder="password" />
                            </div>
                            <div class="form-group">
                                <label>Họ tên</label>
                                <input type="text" name="fullname" class="form-control" placeholder="fullname" />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Số điện thoại</label>
                                <input type="text" name="phone" class="form-control" placeholder="phone" />
                            </div>
                            <div class="form-group">
                                <label>Địa chỉ</label>
                                <input type="text" name="address" class="form-control" placeholder="address" />
                            </div>
                            <div class="form-group">
                                <label>Avatar</label>
                                <input type="text" name="avatar" class="form-control" placeholder="avatar" />
                            </div>
                        </div>
                        <div class="col-12 mt-3">
                            <button type="submit" class="btn btn-success">Lưu lại</button>
                            <a class="btn btn-secondary" href="<%=path%>${ServiceContant.SERVICE_USER_LIST}">Quay lại</a>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
    <script ><%@include file="/WEB-INF/JSP_file/js/jquery.slim.min.js"%></script>
    <script ><%@include file="/WEB-INF/JSP_file/js/popper.min.js"%></script>
    <script ><%@include file="/WEB-INF/JSP_file/js/bootstrap.min.js"%></script>
</body>

</html>