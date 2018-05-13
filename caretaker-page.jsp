<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Caretaker</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2></h2>
		</div>
	</div>
	<b>Caretaker Directory</b>

	<div id="container">
		<div id="content">

			<input type="button" value="Add Caretaker"
				onclick="window.location.href='ShowFormForCaretakerAdd'; return false;"
				class="add-button" />

			<table>
				<tr>
				<th>S.no</th>
					<th align="left">First Name</th>
					<th align="left">Last Name</th>
					<th align="left">Details</th>
				</tr>

				<!-- We need a loop here to retrieve all the customers -->

				<c:forEach var="tempCaretaker" items="${caretakers}">
					<c:url var="detailLink" value="/application/showCaretakerDetail">
						<c:param name="caretakerId" value="${tempCaretaker.id}" />
					</c:url><%! int i=1; %>

					<tr>
					<td><%= i %></td><% i++;%>
						<td align="left">${tempCaretaker.firstName}</td>
						<td align="left">${tempCaretaker.lastName}</td>
						<td align="left"><a href="${detailLink}">@</a></td>

					</tr>
				</c:forEach><% i=1; %>
			</table>
		</div>
	</div>
	<br>
	<br>
	<a href=" home">Home</a>

</body>
</html>