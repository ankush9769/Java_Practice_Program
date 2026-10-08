<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%--     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 --%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EmpController" method="post">
<br>
Enter name :<input type="text" name="name"/>
<br>
Enter Salary:<input type="number" name="salary"/>
<br>
Reporting Manager:

<select name="mid" required>
<option value ="">Select Manager</option>

<c:forEach var="manager" items="${managers}">
<option value="${manager.mid}">
${manager.mname}
</option>

</c:forEach>

</select>

<button type="submit">submit</button>
 
</form>


</body>
</html>