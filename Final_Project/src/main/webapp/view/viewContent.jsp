<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> --%>

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
                                <th style="width: 10px;">#</th>
		  	                    <th style="width:25%;">Title</th>
		  		                <th style="width:50%;">Brief</th>
                                <th>Created Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<%int i = ((int)request.getAttribute("index") - 1) * 3; %>
                         	<c:forEach var="content" items="${listSearch}">
                         		<tr>
                                	<td><c:out value="<%=++i %>"/></td>
                                	<td><c:out value="${content.title}"/></td>
                                	<td><c:out value="${content.brief}"/></td>
                                	<td>
                                    	<span class="createdDate-date"><c:out value="${content.getCreateDateTime().substring(0, 10)}"/></span>
                                    	<br>
                                    	<span class="createdDate-time"><c:out value="${content.getCreateDateTime().substring(11, 19)}"/></span>
                                	</td>
                                	<td>
                                    	<a class="editcontent" href="edit?id=<c:out value="${content.id}"/>&txtSearch=${txtSearch}">Edit</a>
                                    	<a class="delcontent" href="${txtSearch}" data-id_xoa="<c:out value="${content.id}"/>">Delete</a>
                                    	
                                	</td>
                            	</tr>
                         	</c:forEach>
                            
                        </tbody>
                    </table>
                </div>

            </div>
            <br>
			<nav>
				<ul class="pagination">
					<input type="hidden" id="activePage" value="${index}"/>
					<c:if test="${index == 1}">
					<li class="page-item" style="pointer-events:none;"><a class="page-link" href="ViewController?index=${index-1}&txtSearch=${txtSearch}" >Previous</a></li>
					</c:if>
					<c:if test="${index > 1}">
					<li class="page-item"><a class="page-link" href="ViewController?index=${index-1}&txtSearch=${txtSearch}">Previous</a></li>
					</c:if>
					
					<c:forEach begin="1" end="${endPage}" var="i">
						<li class="page-item" id="${i}"><a class="page-link" href="ViewController?index=${i}&txtSearch=${txtSearch}">${i}</a></li>
					</c:forEach>
					
					<c:if test="${index == endPage}">
						<li class="page-item" style="pointer-events:none;"><a class="page-link" href="ViewController?index=${index+1}&txtSearch=${txtSearch}">Next</a></li>
					</c:if>
					<c:if test="${index < endPage || endPage == 0}">
						<li class="page-item"><a class="page-link" href="ViewController?index=${index+1}&txtSearch=${txtSearch}">Next</a></li>
					</c:if>
					
				</ul>
			</nav>
        </div>
    </div>
<%-- <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/resources/js/myscript2.js"></script> --%>

