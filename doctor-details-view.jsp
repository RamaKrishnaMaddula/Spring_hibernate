<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor details</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Maddula Group of Hospitals</h2>
		</div>
	</div>
<h3>Details of the Doctor</h3>
<table>
<tr>
<th>First Name: </th>
<td>${doctor.firstName}</td>
</tr>
<tr>
<th>Last Name: </th>
<td>${doctor.lastName}</td>
</tr>
<tr>
<th>Email Address: </th>
<td>${doctor.email}</td>
</tr>
<tr>
<th>Contact Number: </th>
<td>${doctorDetail.contact}</td>
</tr>
<tr>
<th>Qualification: </th>
<td>${doctorDetail.qualification}</td>
</tr>
</table>
<br>
<form action="showDoctorPatients">
<input type="hidden" name="doctorId" value="${doctor.id}" />
<input type="submit" value="Patients" class="add-button">
</form>
		<br>
		
<form action="showDoctorSickness">
<input type="hidden" name="doctorId" value="${doctor.id}" />
<input type="submit" value="Sickness" class="add-button">
</form>		
<br>
<form action="showUpdateDoctorForm">
<input type="hidden" name="doctorId" value="${doctor.id}" />
<input type="submit" value="Update Details" class="add-button">
</form>
<br>
<br>
<br>

<a href="home"><b>Home</b></a>

</body>
</html>