<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sickness Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Maddula Group of Hospitals</h2>
		</div>
	</div>
	<h3>Enter the sickness details
	<div id="container">
		<div id="content">
	<form action="saveSickness" method="post">
		<table>
			<tr>
				<th>Title: </th>
				<td><input type="text" name="title" value="${sickness.title}" />
				</td>
			</tr>
			<tr>
				<th>Description: </th>
				<td><input type="text" name="description"
					value="${sDes.description}" /></td>
			</tr>
			<tr>
				<th>Symptoms: </th>
				<td><input type="text" name="symptoms" value="${sDes.symptoms}" /></td>
			</tr>
			<tr>
			<th>
			</th>
			<td>
			<input type="submit" value="submit"  class="save">
			</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	<br>
	<br>
<a href="home"><b>Home</b></a>
</body>
</html>