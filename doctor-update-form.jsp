<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update-doctor-form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Maddula Group of Hospitals</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<form name="updateDoctor" action="updateDoctor" method="post">
					<input type="hidden" name="id" value="${doctor.id}">
					<tr>
						<th>First Name:</th>
						<td><input type="text" value="${doctor.firstName}"
							name="firstName" />
						<td>
					</tr>
					<tr>
						<th>Last Name:</th>
						<td><input type="text" value="${doctor.lastName}"
							name="lastName" /></td>
					</tr>
					<br>
					<tr>
						<th>Email:</th>
						<td><input type="text" value="${doctor.email}" name="email" />
						</td>
					</tr>
					<tr>
						<th>Contact:</th>
						<td><input type="text" value="${doctorDetail.contact}"
							name="contact" /></td>
					</tr>
					<tr>
						<th>Qualification:</th>
						<td><input type="text" value="${doctorDetail.qualification}"
							name="qualification" /></td>
					</tr>
					<tr><th></th>
						<td><input type="submit" value="Update doctor"></td>
					</tr>
				</form>
			</table>
		</div>
	</div>
<br>
	<br>
<a href="home"><b>Home</b></a>

</body>
</html>