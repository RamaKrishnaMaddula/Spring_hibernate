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


	<div id="container">
		<div id="content">
			<form action="addPatientToSickness" method="get">
				<table>
					<tr>
						<td><select name="patientId">
								<%
									int j = 1;
								%>
								<c:forEach var="tempPatients" items="${allPatients}">
									<option value="${tempPatients.id}"><%=j%>.
										${tempPatients.firstName} ${tempPatients.lastName} -
										${tempPatients.city}
									</option>
									<%
										j++;
									%>
								</c:forEach>
								<%
									j = 1;
								%>
						</select></td>
						<td><input type="hidden" name="sicknessId" value="${sickness.id}">
							<input type="submit" value="Add Patient" class="add-button" /></td>
					</tr>
				</table>
			</form>
			<table>
				<tr>
					<th>S.no</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>City</th>
					<th>Details</th>
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
						<td>${tempPatient.firstName}</td>
						<td>${tempPatient.lastName}</td>
						<td>${tempPatient.city}</td>
						<td><a href="${detailLink}">@</a></td>

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