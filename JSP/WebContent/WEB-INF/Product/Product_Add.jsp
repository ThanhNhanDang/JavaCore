
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.JAVA.project.util.ServiceConstant"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <title><c:choose>
		<c:when test="${command=='ADD'}">
		Add
		</c:when>
		<c:otherwise>Update</c:otherwise>
		</c:choose>
		new product</title>
</head>
<body>
	<%String path = request.getContextPath();%>
	<div class="container bg-light shadow mx-auto pb-5">
		<h3 class="text-info text-center mt-5 pt-2">
		<c:choose>
		<c:when test="${command=='ADD'}">
		Add
		</c:when>
		<c:otherwise>Update</c:otherwise>
		</c:choose>
		new product
		</h3>
		
		<div class="container w-50 p-4 mb-4 shadow rounded">
			<form method="POST"
			<c:choose>
					<c:when test="${command=='ADD'}">action="<%=path%><%=ServiceConstant.PATH_PRODUCT_ADD%>"</c:when>
					<c:when test="${command=='EDIT'}">action="<%=path%><%=ServiceConstant.PATH_PRODUCT_UPDATE%>"</c:when>	 		
				</c:choose> 
			>
				<div class="form-group">
			    <label class="text-info" for="id">Product id</label>
			    <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' class="form-control" name="productId" id="id" <c:if test="${command=='EDIT'}">value="${product.id}" readonly</c:if> >
			
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="name">Product name</label>
			    <input type="text" class="form-control" name="productName" id="name"<c:if test="${command=='EDIT'}">value="${product.name}" </c:if> >
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="code">Product code</label>
			    <input type="text" class="form-control" name="productCode" id="code"<c:if test="${command=='EDIT'}">value="${product.code}" </c:if> >
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="description">Description</label>
			    <textarea  class="form-control" name="productDescription" id="description" >
			    <c:if test="${command=='EDIT'}">${product.description}</c:if>
			    </textarea>
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="price">Price</label><br>
			    <input class="w-25" type="number" class="form-control" name="productPrice" id="price"<c:if test="${command=='EDIT'}">value="${product.price}"</c:if> >
			  </div>
			  <div class="form-group mt-2">
			  <c:if test="${idERR=='DUPLICATE'}"><script>window.alert('Product ID đã có trong Database.')</script></c:if>
			  	<button  
						onclick="validate()"
			  	     
					type="submit" class="btn btn-info w-50 mx-auto">
					<c:choose>
						<c:when test="${command=='ADD'}">Add</c:when>
						<c:otherwise>Update</c:otherwise>
					</c:choose></button>
			  		 
				<script>
   			 	function validate() {
					
      				if( document.getElementById("id").value 			!="" &&
      					document.getElementById("name").value			!="" &&
      					document.getElementById("code").value			!="" &&
      					document.getElementById("description").value	!="" &&
      					document.getElementById("price").value			!="" &&
      					document.getElementById("price").value			>  0) {
          				return true;
      				}
      				
					alert("Dữ liệu không được để trống. Product Price lớn hơn 0.")
      				return false;
    		}
				</script>
			  </div>
			</form>
			
		</div>
	</div>
</body>
</html>