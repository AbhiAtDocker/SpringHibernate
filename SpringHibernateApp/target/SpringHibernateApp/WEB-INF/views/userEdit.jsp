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
      
    <h2>Edit User </h2>
    <form:form method="POST" action="/SpringHibernateApp/updateUser" modelAttribute="user">
   <table>
   <tr>
           <td></td>
         <td><form:hidden path="id" /></td>
    </tr>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        
        <td> <form:radiobutton path="active" value="true"/></td>
        <td><form:label path="active">Enable User</form:label></td>
    </tr>
    <tr>
        
        <td> <form:radiobutton path="active" value="false"/></td>
        <td><form:label path="active">Disable User</form:label></td>
    </tr>
    
    <tr>
        <td><form:label path="role">Select Role</form:label></td>
          
        <td>   
               <form:select path="role.id">
               <form:option value="NONE" label="--- Select ---" />
                 <form:options items="${roles}" itemValue="id" itemLabel="name"/>
               </form:select>
       </td> 
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Update User"/>
        </td>
    </tr>
  </table>  
 </form:form>

</body>
</html>