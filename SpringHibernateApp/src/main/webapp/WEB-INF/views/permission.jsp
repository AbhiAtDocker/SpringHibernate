<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


  <c:if test="${permission!=null}">
   <h2>Permission Added:${permission.id} </h2>
  </c:if>

  
    <h2>Add Permission </h2>
    <form:form method="POST" action="/SpringHibernateApp/addPermission" modelAttribute="permission">
   <table>
        <td> <form:checkbox path="view" value="true"/></td> <!-- tab will be vi -->
        <td><form:label path="view">View Tab Permission</form:label></td>
    </tr>
    <tr>
        
        <td> <form:checkbox path="read" value="true"/></td>
        <td><form:label path="read">Read Permission</form:label></td>
    </tr>
     <tr>
        <td> <form:checkbox path="create" value="true"/></td>
        <td><form:label path="create">Create Permission</form:label></td>
    </tr>
     <tr>
        <td> <form:checkbox path="Update" value="true"/></td>
        <td><form:label path="update">Update Permission</form:label></td>
    </tr>
    <tr>
        <td> <form:checkbox path="Delete" value="true"/></td>
        <td><form:label path="delete">Delete Permission</form:label></td>
    </tr>
     
    <tr>
        <td colspan="2">
            <input type="submit" value="Create Permission"/>
        </td>
    </tr>
</table>  
</form:form>
    

</body>
</html>