<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Doctors related to the sickness</title>

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
<form action="addDoctorToSickness" method="get">
<table>
<tr><td>
<select name="doctorId">
<% int j = 1; %>
<c:forEach var="tempDoctors" items="${allDoctors}">
<option value="${tempDoctors.id}"><%= j %>. Dr. ${tempDoctors.firstName} ${tempDoctors.lastName} </option><% j++; %>
</c:forEach><% j=1; %>
</select></td><td>
<input type="hidden" name="sickId" value="${sickness.id}">
			<input type="submit" value="Add Doctor"
				class="add-button" /></td>
</tr>
</table>				</form>
			<table>
				<tr>
				<th>S.no</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Details</th>
				</tr>

				<!-- We need a loop here to retrieve all the customers -->
				
				<%! int i = 1; %>

				<c:forEach var="tempDoctor" items="${doctors}">

					<c:url var="detailLink" value="/application/showDoctorDetail">
						<c:param name="doctorId" value="${tempDoctor.id}" />
					</c:url>
					<tr>
						<td><%= i %></td>
						<%  i++; %>
						<td>${tempDoctor.firstName}</td>
						<td>${tempDoctor.lastName}</td>
						<td>${tempDoctor.email}</td>
						<td><a href="${detailLink}">@</a></td>
					</tr>
				</c:forEach>
			</table>
			<% i = 1;%>
		</div>
	</div>

<a href="home"><b>Home</b></a>
</body>
</html>