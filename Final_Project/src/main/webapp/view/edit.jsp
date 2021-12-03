<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <head> -->
<!--     <meta charset="UTF-8"> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!--     <title>Edit Profile</title> -->
<%-- 	<link href="${pageContext.request.contextPath}/resources/css/mystyle.css" rel="stylesheet"> --%>
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
        	<h2>Edit Profile</h2>
      	</div>
    <hr style="border: 0.px solid #e4e4e4">
    	<div class="card text-dark ">
    		    <div class="form-container">
        <div class="card-header">Profile From Elements</div>
        
        <form id="updateProfile-form" action="updateProfile" method="POST">
        	<c:if test="${id != null}">
	        	<input hidden="true" name="id" id="id" value="<%out.print(request.getAttribute("id"));%>"/>
        	</c:if>
            <div class="form-group col-md-9">
                <label class="title">First Name</label>
                <input name='firstname' type="text" class="form-control" id="firstName" placeholder="Enter the first name" value="<c:out value="${firstname}"></c:out>" minlength=3 maxlength=30 required>
            </div>
            <div class="form-group col-md-9">
                <label class="title" for="lastName">Last Name</label>
                <input name='lastname' type="text" class="form-control" id="lastName" placeholder="Enter the last name" value="<c:out value="${lastname}"></c:out>" minlength=3 maxlength=30  required>
            </div>
            
            <div class="form-group col-md-9">
                <label class="title" for="email">Email</label>
<%--                 <input name="email" type="email" class="form-control email-control" id="email" placeholder="your_email@example.com" value="<%out.print(request.getAttribute("email"));%>" maxlength=50 required> --%>
                <br>
                <label class="email-control" id="email"><c:out value="${email}"></c:out></label>
            </div>
            <div class="form-group col-md-9">
                <label class="title" for="phone">Phone</label>
                <input name="phone" type="text" class="form-control" id="phone" placeholder="Enter your phone number" value="<c:out value="${phone}"></c:out>" minlength=9 maxlength=13 required>
            </div>
            <div class="form-group col-md-9">
                <label class="title" for="">Description</label>
                <textarea name="description" class="form-control" id="description" rows="3" maxlength=200><c:out value="${description}"></c:out></textarea>
            </div>
            <input hidden="true" name="createdDate" value="<c:out value="${createDate}"></c:out>"/>
            <input hidden="true" name="updateTime" value="<c:out value="${updateTime}"></c:out>"/>
            <div class="form-group col-md-9">
                <input name="btnUpdate" class="btn btn-hover btn-outline-secondary" type="submit" value="Submit Button"/>
                <input name="btnReset" class="btn btn-hover btn-outline-secondary" type="button" value="Reset Button"/>
            </div>
        </form>
    </div>
    	</div>
      </div>
    </div>
<!-- </body> -->
	
<%-- 	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script> --%>
<!-- </html> -->