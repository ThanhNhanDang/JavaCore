
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Login Page</title>
</head>
<body>
<%
	String path = request.getContextPath();
	String message = (String)request.getAttribute("message");
%>
	<%
		if (message != null){
	%>
			<p class = "text-danger"> <%=message%></p>
	<%
	}
	%>

	<form class="w-50 mt-5 ml-5" action="<%=path %>/login" method="POST">
	  <div class="form-group">
	    <label for="email">Email address:</label>
	    <input name="username" type="text" class="form-control" placeholder="Enter email" id="email">
	  </div>
	  <div class="form-group">
	    <label for="pwd">Password:</label>
	    <input name="password" type="password" class="form-control" placeholder="Enter password" id="pwd">
	  </div>
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox"> Remember me
	    </label>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>