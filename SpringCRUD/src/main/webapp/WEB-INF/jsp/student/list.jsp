<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students List</title>
</head>
<body>
	<div align="center">
		
		<table border="1">
			<tr>
				<th>RollNo</th>
				<th>Name</th>
				<th>Branch</th>
				<th>EmailId</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<td>${student.rollNo}</td>
					<td>${student.name}</td>
					<td>${student.branch}</td>
					<td>${student.emailId}</td>
					<td><spring:url value="/student/update/${student.rollNo}"
							var="updateURL" /><a href="${updateURL}">Update</a></td>
					<td><spring:url value="/student/delete/${student.rollNo}"
							var="deleteURL" /><a href="${deleteURL}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<button onclick="window.location.href='http://localhost:8080/SpringCRUD/';">Home Page</button>
		<spring:url value="/student/add" var="addURL"></spring:url>
		<button onclick="window.location.href='${addURL}';">Add New Student</button>
	</div>

</body>
</html>
