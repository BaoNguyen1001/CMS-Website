<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <div class="container col-md-3 pt-5">

        <div class=" card text-dark">
            <div class="card-header">Register</div>
            <div class="card-body">
                <form action="/Final_Project/RegisterServlet" id="myform" method="POST">
                    <div class="form-group">
                        <input class="form-control" type="text" id="username" name="username" placeholder="User name"
                           minlength=3 maxlength=30 required>
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="email" id="email" name="email" placeholder="E-mail" minlength=5 required>
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="password" id="password" name="password" placeholder="Password"
                            minlength=8 maxlenth=30 required>
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="password" id="repassword" name="repassword"
                            placeholder="Re Password" minlength=8 maxlength=30 required>
                    </div>
                    <c:if test="${msg != null}">
	                    <div class="alert alert-danger">
	                    	<c:out value="${msg}"></c:out>
	                    </div>
                    </c:if>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success form-control py-2">
                            <h5>Register</h5>
                        </button>
                    </div>
                    <div class="form-group">
                        <a href="/Final_Project/view/login.jsp">Click here to Login</a>
                    </div>
                </form>
            </div>

        </div>

    </div>
   	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>