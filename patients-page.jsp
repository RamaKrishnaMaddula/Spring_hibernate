<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patients</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Maddula Group of Hospitals</h2>
		</div>
	</div>

	<b>Patients Directory</b>

	<div id="container">
		<div id="content">
			<input type="button" value="Add Patient"
				onclick="window.location.href='ShowFormForPatientAdd'; return false;"
				class="add-button" /> <br>
			<table>
				<tr>
					<th>S.no</th>
					<th align="left">First Name</th>
					<th align="left">Last Name</th>
					<th align="left">City</th>
					<th align="left">Details</th>
				</tr>
				<%!int i = 1;%>
				<!-- We need a loop here to retrieve all the customers -->

				<c:forEach var="tempPatient" items="${patients}">
					<c:url var="detailLink" value="/application/showPatientDetail">
						<c:param name="patientId" value="${tempPatient.id}" />
					</c:url>

					<tr>
						<td><%=i%></td>
						<%
							i++;
						%>
						<td align="left">${tempPatient.firstName}</td>
						<td align="left">${tempPatient.lastName}</td>
						<td align="left">${tempPatient.city}</td>
						<td align="left"><a href="${detailLink}">@</a></td>

					</tr>
				</c:forEach>
				<%
					i = 1;
				%>
			</table>
		</div>
	</div>

	<br>
	<br>
	<a href="home"><b>Home</b></a>
</body>
</html>