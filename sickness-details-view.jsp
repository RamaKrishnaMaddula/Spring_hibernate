<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Maddula Group of Hospitals</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">

			<h3>Sickness Description:</h3>
			<table>
				<tr>
					<th>Title:</th>
					<td>${sickness.title}</td>
				</tr>
				<tr>
					<th>Description:</th>
					<td>${sicknessDescription.description}</td>
				</tr>
				<tr>
					<th>Symptoms:</th>
					<td>${sicknessDescription.symptoms}</td>
				</tr>
			</table>
			<br>
			<form action="updateSicknessForm">
				<input type="hidden" name="sicknessId" value="${sickness.id}" /> <input
					type="submit" value="Update Details" class="add-button">
			</form>
			<br>
			<form action="sicknessDoctors">
				<input type="hidden" name="sicknessId" value="${sickness.id}" /> <input
					type="submit" value="Doctors" class="add-button">
			</form>
			<br>

			<form action="sicknessPatients">
				<input type="hidden" name="sicknessId" value="${sickness.id}" /> <input
					type="submit" value="Patients" class="add-button">

			</form>
		</div>
	</div>
	<br>
	<br>
<a href="home"><b>Home</b></a>
</body>
</html>