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
	        <h3 id="header_msg" align="center" class="text-primary">Address List</h3>
	        <hr />
			
			<div>&nbsp;</div>
	        <!------ SPRING MVC & HIBERNATE EXAMPLE ------>	
	        <div id="spring_mvc_hibernate_usr_mapping_table">
	            <c:if test="${not empty company}">
	               <c:choose>
	                 <c:when test="${company.primaryAdress!=null}">
	        		<table id="usr_table" class="table">
	                	<thead>
	                    	<tr align="center">
	                        	<th scope="col">Address Id</th><th scope="col">Company Name</th><th scope="col">Company Id</th><th scope="col">Key</th><th scope="col">Address</th><th scope="col">Is Primary</th><<th scope="col">Edit</th><th scope="col">Delete</th><th scope="col">
	                    	</tr>
	                	</thead>
	                	<tbody>
	                	   <tr align="center">
	                            	<td>${company.primaryAddress.id}</td><td>${company.companyName}</td><td>${company.companyId}</td><td>${company.primaryAddress.key}</td><td><td>${company.primaryAddress.address1}<br>${company.primaryAddress.city},${company.primaryAddress.country}<br>${company.primaryAddress.zip}<br> </td>${company.primaryAddress.isPrimary
	                            	}<td></td><td><a href="editCompany/${u.id}">Edit</a></td><td><a href="deleteCompany/${u.id}">Delete</a></td><td><a href="address/${u.id}">View</a></td><td><a href="tradingPartner/${u.id}">View</a></td>
	                        </tr>
	                    	<c:forEach var="u" items="${companyList}">
	                        	<tr align="center">
	                            	<td>${u.id}</td><td>${u.companyName}</td><td>${u.companyId}</td><td>${u.qualifier}</td><td><a href="editCompany/${u.id}">Edit</a></td><td><a href="deleteCompany/${u.id}">Delete</a></td><td><a href="address/${u.id}">View</a></td><td><a href="tradingPartner/${u.id}">View</a></td>
	                        	</tr>
	                    	</c:forEach>
	                	</tbody>
	            	</table>
	            	</c:when>
	            	<c:otherwise>
	            	
	            	   Add Address
	            	</c:otherwise>
	             </c:choose> 	
	        	</c:if>
	        	
	        	<!-- Error Message -->
	        	<c:if test="${empty companyList}">
	        		<span id="errMsg" class="text-danger">Error in retrieving data!</span>
	        	</c:if>
	        </div>
	    </div>
	</body>
</html>