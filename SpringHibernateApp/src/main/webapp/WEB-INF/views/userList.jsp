<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>SpringMvcHibernate</title>
	    
	    <!-- Bootstrap Css -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	</head>
	<body>
	    <div id="springMvcHibernate" class="container">
	        <h3 id="header_msg" align="center" class="text-primary">Spring MVC and Hiberate Example</h3>
	        <hr />
			
			<div>&nbsp;</div>
	        <!------ SPRING MVC & HIBERNATE EXAMPLE ------>	
	        <div id="spring_mvc_hibernate_usr_mapping_table">
	            <c:if test="${not empty userList}">
	        		<table id="usr_table" class="table">
	                	<thead>
	                    	<tr align="center">
	                        	<th scope="col">User Id</th><th scope="col">Name</th><th scope="col">Email Address</th><th scope="col">Is Active?</th><th scope="col">Role</th><th scope="col">Edit</th><th scope="col">Delete</th>
	                    	</tr>
	                	</thead>
	                	<tbody>
	                    	<c:forEach var="u" items="${userList}">
	                        	<tr align="center">
	                            	<td>${u.id}</td><td>${u.name}</td><td>${u.email}</td><td>${u.active}</td><td>${u.role.name}</td><td><a href="editUser/${u.id}">Edit</a></td><td><a href="deleteUser/${u.id}">Delete</a></td>
	                        	</tr>
	                    	</c:forEach>
	                	</tbody>
	            	</table>
	        	</c:if>
	        	
	        	<!-- Error Message -->
	        	<c:if test="${empty userList}">
	        		<span id="errMsg" class="text-danger">Error in retrieving data!</span>
	        	</c:if>
	        </div>
	    </div>
	</body>
</html>