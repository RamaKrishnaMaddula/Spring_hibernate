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

			<h3>Details of the Patient</h3>
			<table >
				<tr>
					<th>First Name:</th>
					<td>${patient.firstName}</td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td>${patient.lastName}</td>
				</tr>
				<tr>
					<th>city:</th>
					<td>${patient.city}</td>
				</tr>
				<tr>
					<th>Suffering with:</th><%!int i = 1;%>
					<td><c:forEach var="tempSickness" items="${sickness}"><%=i%>
							<%
								i++;
							%>.${tempSickness.title}<br>
						</c:forEach>
						<%
							i = 1;
						%></td>
				</tr>
				<tr>
					<th>Suffering from last:</th>
					<td>${patient.sufferFrom}</td>
				</tr>
				<tr>
					<th>Joining time:</th>
					<td>${patient.joining}</td>
				</tr>
				<tr>
					<th>Doctor:</th>
					<td>${doctor.firstName} ${doctor.lastName}</td>
				</tr>
				<tr>
					<th>Caretaker:</th>
					<td>${caretaker.firstName} ${caretaker.lastName}</td>
				</tr>
			</table>
			<br>
			<form action="updatePatientForm">
				<input type="hidden" name="patientId" value="${patient.id}" /> <input
					type="submit" value="Update Details" class="add-button">
			</form>
			</div>
			</div>
			<br>
	<br>
<a href="home"><b>Home</b></a>
</body>
</html>