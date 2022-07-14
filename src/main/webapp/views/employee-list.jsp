<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>

	<div class="container">
       <button class = "btn btn-primary" onclick = "window.location.href='views/employee-add.jsp'">Add Employee</button>
		<table border="1" class="table table-striped table-bordered">
			<tr class="table-dark">
				<th>Employee id</th>
				<th>Employee Name</th>
				<th>Employee Contact No</th>
				<th>Email id</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Hotel id</th>
			</tr>
			<c:forEach items="${employeeList}" var="employees">
				<tr>
					<td>${employees.employeeId}</td>
					<td>${employees.employeeName}</td>
					<td>${employees.employeeContactNumber}</td>
					<td>${employees.employeeEmailId}</td>
					<td>${employees.employeeAge}</td>
					<td>${employees.employeeGender}</td>
					<td>${employees.hotelId}</td>

				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>