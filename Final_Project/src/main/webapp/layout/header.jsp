<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%-- <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"> --%>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a style="color:#7A7A7A;" href="." class="navbar-brand mr-auto">CMS</a>

		
        <div class="navbar-nav">
        	<c:if test="${loginUserId == null }">
        		<div class="nav-item">
        			<a href="view/login.jsp">Login</a>
        		</div>
			</c:if>
			<c:if test="${loginUserId != null }">			
	            <div class="nav-item dropdown show">
	                <a class="dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
	                    aria-haspopup="true" aria-expanded="false">
	                    <i class="fa fa-user"></i>
	                </a>
	                <div class="dropdown-menu dropdown-menu-user" aria-labelledby="navbarDropdown">
	                    <a id="profile" class="dropdown-item" href="ProfileServlet?id=${loginUserId}" > <i class="fa fa-user"></i> User profile</a>
	                    <div class="dropdown-divider"></div>
	                    <a class="dropdown-item" href="LogoutServlet"><i class="fas fa-sign-out-alt"></i>Logout</a>
	                </div>
	            </div>
			</c:if>
        </div>
    </nav>
<%--     <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script> --%>
</body>
</html>