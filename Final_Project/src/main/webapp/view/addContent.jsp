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
                    <h2>Add Content</h2>
      		</div>
      <hr />
      <div class="card text-dark ">
        <div class="card-header">Content Form Elements</div>
        
        <div class="card-body">
                <form id="add-form" action="addContent_Controller" method="POST">
            
            <input id="authorid"  type="hidden" name="authorid"  value="<c:out value="${loginUserId}" />" />
          
            <div class="form-group col-md-9">
              <label for="title"><b>Title</b></label>
              <div >
                <input type="text" class="form-control" name="title" id="title" placeholder="Enter the title" value="<c:out value="${content.title}"/>" minlength=10 maxlength=200 required>
              </div>

            </div>
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