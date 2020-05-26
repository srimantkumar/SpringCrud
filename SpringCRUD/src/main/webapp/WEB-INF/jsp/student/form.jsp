<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<spring:url value="/student/insert" var="insertURL"/>
	
	<form:form action="${insertURL}" method="POST" modelAttribute="studentDetails">
		<form:hidden path="rollNo"/>
		<div align="center">
			<table>
				<tr>
					<td>Student Name</td> 
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td>Branch</td> 
					<td><form:input path="branch"/></td>
				</tr>
				<tr>
					<td>EmailId</td> 
					<td><form:input path="emailId"/></td>
				</tr>
			</table>
			<button type="submit">Save</button>
		</div>
	</form:form>
	<br>
	<div align="center">
		<button onclick="window.location.href='http://localhost:8080/SpringCRUD/';">Home Page</button>
		<button onclick="window.location.href='http://localhost:8080/SpringCRUD/student/getAllStudent'">Student List</button>
	</div>
	
</body>
</html>