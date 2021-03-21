<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bai Tap JSP</title>
</head>
<body>
	<%-- Hãy in ra màn hình 10 số đầu tiên của dãy Fibonacy--%>
	<h1><%= request.getContextPath() %></h1>
	<%!int tong = 0;
	%>
	<%
		int[] fi = new int [10];
		for (int i = 0; i < 10; i ++){
			if (i == 0)
				fi[i] = 0;
			else if (i == 1)
				fi[i] = 1;
			else
				fi[i] = fi[i-1]+fi[i-2];
		}
		for (int i = 0; i < fi.length; i ++){
	%>
		<h1><%= fi[i] %></h1>
	<%}
	%>
	

	
	
</body>
</html>