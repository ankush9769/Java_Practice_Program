
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%--     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 --%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table class="table">
  <thead>
    <tr>
      <th >EmpId</th>
      <th >Name</th>
      <th >Salary</th>
      <th scope="col">ManagerName</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${employees}" var="e">
    <tr>
      
      <td>${e.getId()}</td>
      <td>${e.getName()} </td>
      <td>${e.getSalary()} </td>
      <td>${e.getManagerName()} </td>
    </tr>
    </c:forEach>
    
  </tbody>
</table>

	
</body>
</html>