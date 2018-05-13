<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doc-patients</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<br>
	<div id="wrapper">
		<div id="header">
			<h2>Maddula Group of Hospitals</h2>
		</div>
	</div>
	<b>Patients of Dr. ${doctor.firstName} ${doctor.lastName}</b>
	<div id="container">
		<div id="content">
		<form action="addPatientToDoctor" method="get">
<table>
<tr><td>
<select name="patientId">
<% int j = 1; %>
<c:forEach var="tempPatients" items="${allPatients}">
<option value="${tempPatients.id}"><%= j %>. ${tempPatients.firstName} ${tempPatients.lastName} - ${tempPatients.city} </option><% j++; %>
</c:forEach><% j=1; %>
</select></td><td>
<input type="hidden" name="doctorId" value="${doctor.id}">
			<input type="submit" value="Add Patient"
				class="add-button" /></td>
</tr>
</table>				</form>
			<table>
				<tr><th>S.no</th>
					<th align="left">First Name</th>
					<th align="left">Last Name</th>
					<th align="left">City</th>
					<th align="left">Suffering from</th>
					<th align="left">Joining Date</th>
					<th align="left">Details</th>
				</tr>

				<!-- We need a loop here to retrieve all the customers -->
<%! int i =1; %>
				<c:forEach var="tempDocPatient" items="${doctorPatients}">
					<c:url var="detailLink" value="/application/showPatientDetail">
						<c:param name="patientId" value="${tempDocPatient.id}" />
					</c:url>
					
					<tr><td><%= i %></td><% i++; %>
						<td align="left">${tempDocPatient.firstName}</td>
						<td align="left">${tempDocPatient.lastName}</td>
						<td align="left">${tempDocPatient.city}</td>
						<td align="left">${tempDocPatient.sufferFrom}days</td>
						<td align="left">${tempDocPatient.joining}</td>
						<td align="left"><a href="${detailLink}">@</a></td>


					</tr>
				</c:forEach>
			</table>
			<% i=1; %>
		</div>
	</div>
	
	<br>
	<br>
	<a href="home"><b>Home</b></a>
</body>
</html>