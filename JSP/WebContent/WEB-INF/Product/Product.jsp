
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.JAVA.project.util.ServiceConstant"%>
<%@page import="com.JAVA.project.util.ProductConstant"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.JAVA.project.service.ProductService"%>
<%@page import="com.JAVA.project.model.Product"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Product Page</title>
</head>
<body class="bg-light">


	<%
		String path = request.getContextPath();
	%>
	<div class="container bg-light mx-auto shadow p-5 mt-5">

		<h1 class="text-info text-center">Product List</h1>

		<div class="container w-25 float-left mb-2">
			<%--Khi  nhấn nút Add new product sẽ chuyển đến trang thêm sản phẩm
			Dặt đường dẫn sao cho sau khi ấn nút submit sẽ vô hàm doPost
			Tao 1 produt mới
			Product product= new Product();
			lấy thông tin từ form set vvaof product
			product,id = Integer.parseInt(req.Get)
			thêm 1 product mới vào danh sách
			Hiển thi trong product hompage --%>
			<a href="<%=path%><%=ServiceConstant.PATH_PRODUCT_ADD%>"
				class="btn btn-info text-white">Add new product</a>
		</div>

		<%--Product table --%>
		<table class="table border shadow">
			<thead class="pl-2">
				<%-- p => padding qua trái--%>
				<tr class="table-light text-center">
					<th>Id</th>
					<%--Header--%>
					<th>Name</th>
					<th>Code</th>
					<th>Description</th>
					<th>Price</th>

				</tr>
			</thead>
			<tbody class="pl-2">

				<%-- Product lists --%>
				<c:forEach var="product" items="${products}">
					<%-- items phu thuoc vao setAttribute --%>
					<tr class="text-center">
						<td>${product.id}</td>
						<%--${} for i và chỉ nhân --%>
						<td>${product.name}</td>
						<td>${product.code}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td><a
							href="<%=path%><%=ServiceConstant.PATH_PRODUCT_UPDATE%>?id=${product.id}"
							class="btn btn-outline-warning btn-sm">Update</a> <a
							href="<%=path%><%=ServiceConstant.PATH_PRODUCT_DELETE%>?id=${product.id}"
							class="btn btn-outline-danger btn-sm">Delete</a></td>
					</tr>
				</c:forEach>

				<%-- end Product lists --%>

			</tbody>
		</table>

	</div>

</body>
</html>