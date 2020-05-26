<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" isELIgnored="false"%>	
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Registration</title>
</head>
<body>
	<div>
		<spring:url value="/teacher/insert" var="insertURL" />
		
		<form:form action="${insertURL}" method="POST" modelAttribute="teacherDetails">
			<table>
				<tr>
					<td>Teacher Name</td>
					<td><form:input path="name"/>
				</tr>
				<tr>
					<td>Teacher Department</td>
					<td><form:input path="department"/>
				</tr>
			</table>
			<button type="submit">Save</button>
		</form:form>
		<button onclick="window.location.href='http://localhost:8080/SpringCRUD/';">Home Page</button>
		<button onclick="window.location.href='http://localhost:8080/SpringCRUD/teacher/getAllTeacher'">Teacher List</button>
	</div>
</body>
</html>