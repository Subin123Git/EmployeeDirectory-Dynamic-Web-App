<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>
	<div class="container">
		<form action= "${pageContext.request.contextPath}/EmployeeController" method = "POST">
			Enter the Name : <input type="text" name="employeename" value = "${editEmployee.employeeName}"/> <br>
			Enter the Contact No : <input type="text" name="contactno" value = "${editEmployee.employeeContactNumber}" /> <br>
			Enter the Email id : <input type="text" name="emailid" value = "${editEmployee.employeeEmailId}" /> <br>
			Enter the Age : <input type="text" name="age" value = "${editEmployee.employeeAge}"/> <br> 
			Enter the Gender : <input type="text" name="gender" value = "${editEmployee.employeeGender}" /> <br> 
			Enter the Hotel id : <input type="text" name="hotelid" value = "${editEmployee.hotelId}"/> <br>
			<input type ="hidden" name = "employeeid" value = "${editEmployee.employeeId}"/>
			<button type="submit" class="btn btn-primary">Save Employee</button>
		</form>
	</div>

</body>
</html>