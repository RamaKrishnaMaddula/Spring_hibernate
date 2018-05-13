<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Caretaker form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>maddula group of hospitals</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<h3>Please enter the Caretaker details</h3>
			<form action="updateCaretaker" method="post">
				<input type="hidden" name="id" value="${caretaker.id}">
				<table>
					<tr>
						<th>First Name:</th>
						<td><input type="text" name="firstName"
							value="${ caretaker.firstName}" /></td>
					</tr>
					<tr>
						<th>Last Name:</th>
						<td><input type="text" name="lastName"
							value="${caretaker.lastName}" /></td>
					</tr>
					<tr>
						<th>Experience:</th>
						<td><input type="text" name="experiance"
							value="${caretaker.experiance}" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="Update" class="save" /></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<br>
	<br>
	<a href="home"><b>Home</b></a>
</body>
</html>