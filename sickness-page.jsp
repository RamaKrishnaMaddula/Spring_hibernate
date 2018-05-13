<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sickness</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2></h2>
		</div>
	</div>
	<b>Sickness Directory</b>

	<div id="container">
		<div id="content">

			<input type="button" value="Add Sickness"
				onclick="window.location.href='ShowFormForSicknessAdd'; return false;"
				class="add-button"/>

			<table>
				<tr>
					<th>S.no.</th>
					<th align="left">Title</th>
					<th>Details</th>
				</tr>

				<!-- We need a loop here to retrieve all the customers -->
<%! int i =1; %>
				<c:forEach var="tempSickness" items="${sickness}">
					<c:url var="detailLink" value="/application/showSicknessDetail">
						<c:param name="sicknessId" value="${tempSickness.id}" />
					</c:url>

					<tr>

						<td><%= i %></td><% i++; %>
						<td align="left">${tempSickness.title}</td>
						<td><a href="${detailLink}">@</td>
					</tr>
				</c:forEach><% i =1; %>
			</table>

		</div>
	</div>
	
	<br>
	<br>
<a href="home"><b>Home</b></a>
</body>
</html>