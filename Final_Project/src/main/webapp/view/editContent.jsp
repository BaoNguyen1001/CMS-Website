<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- <title>Edit Profile</title> -->
<style type="text/css">
		.btn-hover:hover {
  				background-color: green;
  				}
</style>
<!-- </head> -->
<!-- <body> -->
    <div class="container-fluid" style="padding-top: 30px;">
    	<div class="col-md-12">
    		<div class="page-header">
        		 <c:if test="${content != null}">
                 	<h2>Edit Content</h2>
                 </c:if>
                 <c:if test="${content == null}">
                    <h2>Add Content</h2>
                 </c:if>
      		</div>
      <hr />
      <div class="card text-dark ">
        <div class="card-header">Content Form Elements</div>
        
        <div class="card-body">
        	<c:if test="${content != null}">
            	<form id="update-form" action="#">
            </c:if>
            <c:if test="${content == null}">
                <form id="add-form" action="addContent_Controller" method="POST">
            </c:if>
            
            <input id="authorid"  type="hidden" name="authorid"  value="<c:out value="${loginUserId}" />" />
            
            <c:if test="${content != null}">
            	<input id="contentId" type="hidden" name="id"  value="<c:out value="${content.id}" />" />
            </c:if>
            	
            <div class="form-group col-md-9">
              <label for="title"><b>Title</b></label>
              <div >
                <input type="text" class="form-control" name="title" id="title" placeholder="Enter the title" value="<c:out value="${content.title}"/>" minlength=10 maxlength=200 required>
              </div>

            </div>
            
            <c:if test="${content != null}">
	            <div class="form-group col-md-9">
	              <label for="brief"><b>Brief</b></label>
	             <div >
	                <textarea rows="2" class="form-control" name="brief" id="brief" minlength=30 maxlength=150 required><c:out value="${content.brief}"/>
				</textarea>

	              </div>
	            </div>
	            <div class="form-group col-md-9">
	              <label for="content"><b>Content</b></label>
	              <div >
	                <textarea rows="5" class="form-control" name="content" id="content" minlength=50 maxlength=1000 required><c:out value="${content.content}"/></textarea>
	              </div>
	            </div>
        	</c:if>
              
            <c:if test="${content == null}">
            	 <div class="form-group col-md-9">
	              <label for="brief"><b>Brief</b></label>
	             <div >
	                <textarea rows="2" class="form-control" name="brief" id="brief" required></textarea>
	              </div>
	            </div>
	            <div class="form-group col-md-9">
	              <label for="content"><b>Content</b></label>
	              <div >
	                <textarea rows="5" class="form-control" name="content" id="content" required></textarea>
	              </div>
	            </div>
        	</c:if>
        	
            <br />
            <div class="form-group col-md-9">
            
                <input type="submit" id="isubmit" class="btn btn-hover btn-outline-secondary " name="submit" value="Submit Button" />
                <input type="reset" id="ireset"  class="btn btn-hover btn-outline-secondary" name="reset" value="Reset Button" />
           
            </div>
          </form>
        </div>
      </div>
    	</div>

    </div>
<!-- </body> -->
<!-- </html> -->