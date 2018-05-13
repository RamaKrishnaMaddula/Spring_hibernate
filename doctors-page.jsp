<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Doctors List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Maddula Group of Hospitals</h2>
		</div>
	</div>

<b>Doctors directory</b>




	<div id="container">
		<div id="content">

			<input type="button" value="Add Docotr"
				onclick="window.location.href='ShowFormForDoctorAdd'; return false;"
				class="add-button" />
			<table>
				<tr>
				<th>S.no</th>
					<th align="left">First Name</th>
					<th align="left">Last Name</th>
					<th align="left">Email</th>
					<th align="left">Details</th>
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
						<td align="left">${tempDoctor.firstName}</td>
						<td align="left">${tempDoctor.lastName}</td>
						<td align="left">${tempDoctor.email}</td>
						<td align="left"><a href="${detailLink}">@</a></td>
					</tr>
				</c:forEach>
			</table>
			<% i = 1;%>
		</div>
	</div>
<br>
<br>
<a href="home"><b>Home</b></a>
</body>
</html>