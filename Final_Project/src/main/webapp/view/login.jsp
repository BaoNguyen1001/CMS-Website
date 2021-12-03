<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container col-md-3 pt-5">
        <div class=" card text-dark">
            <div class="card-header">Please Sign In</div>
            <div class="card-body">
                <form action="/Final_Project/LoginServlet" method="POST">
                    <div class="form-group">
                    	<c:if test="${email == null }">
                        	<input class="form-control" type="email" id="email" name="email" placeholder="E-mail" minlength=5 maxlength=50 required>
                    	</c:if>
                    	<c:if test="${email != null }">                        	
                    		<input class="form-control" type="email" id="email" name="email" placeholder="E-mail" value="${email}" minlength=5 maxlength=50 required>
                    	</c:if>
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="password" id="password" name="password" placeholder="Password"
                            minlength=8 maxlength=30 required>
                    </div>
                    <c:if test="${mess != null}">
	                    <div class="alert alert-danger">
	                    	<c:out value="${mess}"></c:out>
	                    </div>
                    </c:if>
                    <div class="form-group">
                        <input class="form-checkbox" type="checkbox" id="remember" name="remember">
                        Remember me
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success form-control py-2">
                            <h5>Login</h5>
                        </button>
                    </div>
                    <div class="form-group">
                        <a href="/Final_Project/view/register.jsp">Click here to Register</a>
                    </div>
                </form>
            </div>

        </div>
    </div>
    
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    	<script>
		$(document).ready(function(e) {
			let msg2 = <%= request.getAttribute("msg2")%>
			if(msg2 != null)
				alert(msg2);
		});
	</script>
   
    
</body>
</html>