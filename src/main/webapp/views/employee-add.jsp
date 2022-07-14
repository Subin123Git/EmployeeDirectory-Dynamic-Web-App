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
		<form action= "" method = "POST">
			Enter the id : <input type="text" name="employeeid" /> <br>
			Enter the Name : <input type="text" name="employeename" /> <br>
			Enter the Contact No : <input type="text" name="contactno" /> <br>
			Enter the Email id : <input type="text" name="emailid" /> <br>
			Enter the Age : <input type="text" name="age" /> <br> Enter the
			Gender : <input type="text" name="gender" /> <br> Enter the
			Hotel id : <input type="text" name="hotelid" /> <br>
			<button type="submit" class="btn btn-primary">Add Employee</button>
		</form>
	</div>

</body>
</html>