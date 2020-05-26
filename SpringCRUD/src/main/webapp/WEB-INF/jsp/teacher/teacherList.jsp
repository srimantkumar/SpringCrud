<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher List</title>
</head>
<body>
	<div align="center">
		
		<table border="1">
			<tr>
				<th>Teacher ID</th>
				<th>Name</th>
				<th>Department</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach items="${teacherList}" var="teacher">
				<tr>
					<td>${teacher.teacherId}</td>
					<td>${teacher.name}</td>
					<td>${teacher.department}</td>
					<td><spring:url value="/teacher/update/${teacher.teacherId}"
							var="updateURL" /><a href="${updateURL}">Update</a></td>
					<td><spring:url value="/teacher/delete/${teacher.teacherId}"
							var="deleteURL" /><a href="${deleteURL}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<button onclick="window.location.href='http://localhost:8080/SpringCRUD/';">Home Page</button>
		<spring:url value="/teacher/add" var="addURL"></spring:url>
		<button onclick="window.location.href='${addURL}';">Add New Teacher</button>
	</div>
	
</body>
</html>