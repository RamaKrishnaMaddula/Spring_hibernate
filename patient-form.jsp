<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient</title>
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


			<h3>Enter the patient details</h3>
			<form:form action="savePatient" modelAttribute="patient"
				method="post">
				<table>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>City: </label></td>
						<td><form:input path="city" /></td>
					</tr>
					<tr>
						<td><label>Been sick from last(days): </label></td>
						<td><form:input path="sufferFrom" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Next"></td>
					</tr>
				</table>
			</form:form>

		</div>
	</div>

	<br>
	<br>
	<a href="home"><b>Home</b></a>

</body>
</html>