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


  <c:if test="${company.companyName!=null}">
   <h2>Company Added:${company.companyName} </h2>
  </c:if>

  
    <h2>Add Company </h2>
    <form:form method="POST" action="/SpringHibernateApp/addCompany" modelAttribute="company">
   <table>
   
    <tr>
        <td><form:label path="companyName">Company Name</form:label></td>
        <td><form:input path="companyName" /></td>
    </tr>
     <tr>
        <td><form:label path="companyId">Company Id</form:label></td>
        <td><form:input path="companyId" /></td>
    </tr>
    
    <tr>
        <td><form:label path="qualifier">Qualifier</form:label></td>
        <td><form:input path="qualifier" /></td>
    </tr>
    
     <%-- <tr>
        <td><form:label path="tradingPartners">Select Trading Partners</form:label></td>
        <td>   
               <form:select path="tradingPartners" multiple="true">
               <form:option value="NONE" label="--- Select ---" />
                 <form:options items="${tradingPartners}" itemValue="id" itemLabel="name"/>
               </form:select>
       </td> 
    </tr> --%>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
    

</body>
</html>