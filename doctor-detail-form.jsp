<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addition details</title>
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

			<h3>Please enter the doctor details</h3>
			<form:form action="saveDoctorAdditional"
				modelAttribute="doctorDetail" method="post">
				<input type="hidden" name="id" value="${doctor.id}">
				<table>
					<tr>
						<td><label>Contact Number: </label></td>
						<td><form:input path="contact" /></td>
					</tr>
					<tr>
						<td><label>Qualification: </label></td>
						<td><form:input path="qualification" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Submit" class="save"></td>
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