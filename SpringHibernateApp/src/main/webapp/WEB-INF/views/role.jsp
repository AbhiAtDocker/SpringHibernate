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

 
  <c:if test="${role.name!=null}">
   <h2>Role Added:${roleName} </h2>
  </c:if>
 
  
    <h2>Add Role</h2>
    <form:form method="POST" action="/SpringHibernateApp/addRole" modelAttribute="role">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="code">Code</form:label></td>
        <td><form:input path="code" /></td>
    </tr>
    
    <tr>
        <td><form:label path="tabs">Select Tabs</form:label></td>
      <td>   
            <form:select multiple="true" path="tabs">
             <form:options items="${tabs}" itemLabel="name" itemValue="tabId"/>
            </form:select>
       </td> 
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
    

</body>
</html>