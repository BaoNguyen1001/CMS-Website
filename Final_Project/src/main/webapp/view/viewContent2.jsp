
<html>
<head>
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
     <div class="container-fluid">
        <div class="col-md-12">
            <div class="page-header">
                <h2>View Content</h2>
            </div>

            <hr />
            <div class="card text-dark">
                <div class="card-header">View Content List</div>
                <div class="card-body">
                    <table class="table table-bordered table-striped table-responsive-md">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Title</th>
                                <th>Brief</th>
                                <th>Created Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                         	<c:forEach var="content" items="${listContent}">
                         		<tr>
                                	<td><c:out value="${content.id}"/></td>
                                	<td><c:out value="${content.title}"/></td>
                                	<td><c:out value="${content.brief}"/></td>
                                	<td>
                                    	<span class="createdDate-date"><c:out value="${content.createDate.getDate()}"/></span>
                                    	<br>
                                    	<span class="createdDate-time"><c:out value="${content.createDate.getTime()}"/></span>
                                	</td>
                                	<td>
                                    	<a href="Content/edit?id=<c:out value="${content.id}"/>">Edit</a>
                                    	<a id="delcontent" href="Content/delete?id=<c:out value="${content.id}"/>">Delete</a>
                                    	<button data-id_xoa="" class="delcontent">Delete</button>
                                	</td>
                            	</tr>
                         	</c:forEach>
                            
                        </tbody>
                    </table>
                </div>

            </div>

        </div>
    </div>
	<script src="${pageContext.request.contextPath}/resources/js/myscript.js"></script>
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>

</body>

</html>