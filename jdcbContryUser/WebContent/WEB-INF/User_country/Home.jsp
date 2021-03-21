
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.project.jdbcCountrUser.util.ServiceConstant"%>
<%@page import="com.project.jdbcCountrUser.util.JSPConstant"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.project.jdbcCountrUser.model.Country"%>
<%@page import="com.project.jdbcCountrUser.model.User"%>
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
		<c:choose>
			<c:when test="${loginSuccess == 'true'}">
				<%User user = (User)request.getAttribute("userProfile"); %>
				<h1 class="text-info text-center">User profile</h1>

				<div class="container w-25 float-left mb-2">
				<a href="<%=path%><%=ServiceConstant.PATH_USER_ADD%>"
					class="btn btn-info text-white">Add new User</a>
				</div>
				
			</c:when>
			<c:otherwise>
				<h1 class="text-info text-center">Country list</h1>
			</c:otherwise>
		</c:choose>
		
		<%--Product table --%>
		<table class="table border shadow">
			<c:choose>
						<c:when test="${loginSuccess=='true'}">
						<thead class="pl-2">
				<tr class="table-light text-center">
					<th>Id</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
					<th>City</th>
					<th>Country</th>
				</tr>
			</thead>
			<tbody class="pl-2">
						<tr class="text-center">
						
						<td><%System.out.println(User(request.getAttribute("userProfile").);%></td>
						<td>${user.getFirstName()}</td>
						<td>${user.getLastName()} </td>
						<td>${user.getphone()} </td>
						<td>${user.getEmail()} </td>
						<td>${user.getAddress()} </td>
						<td>${user.getCity()} </td>
						<td>${user.getName()} </td>
						<td><a
							href="<%=path%><%=ServiceConstant.PATH_USER_ADD%>?id=${user.geiIdUser()}"
							class="btn btn-outline-warning btn-sm">Edit</a> <a
							href="<%=path%><%=ServiceConstant.PATH_USER_DELETE%>?id=${user.getIdUser()}"
							class="btn btn-outline-danger btn-sm">Delete</a></td>
					</tr>
			</tbody>
						</c:when>
						<c:otherwise>
						<thead class="pl-2">
				<tr class="table-light text-center">
					<th>Id</th>
					<%--Header--%>
					<th>Name</th>
				</tr>
			</thead>
			<tbody class="pl-2">

				<%-- Product lists --%>
				<c:forEach var="listCountry" items="${listCountry}">
					
					<tr class="text-center">
						<td>${listCountry.getId()}</td>
						
						<td>${listCountry.getName()}</td>
					</tr>
				</c:forEach>
			</tbody>
						</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>