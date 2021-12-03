<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html id="html_home_page">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/mystyle.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"/>

</head>

<body>
	
	
	<div>
		<tiles:insertAttribute name="header"/>
	</div>
	
	<div>
		<div class="menu bg-light">
			<aside>
				<tiles:insertAttribute name="menu"/>
			</aside>
		</div>
		<div >
			<div class="bodyContent">
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
	</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/myscript2.js"></script>	
<script>
	$("document").ready(function(e){
		let checkLogin = <%=session.getAttribute("loginUserId") %>
		console.log(checkLogin);
		if(checkLogin == undefined) {
			$(".menu").children().on("click", function(e) {
				e.preventDefault();
				$(".bodyContent").html("");
				alert("Login to countinues!!!");
			})
		}
	})
</script>
</html>