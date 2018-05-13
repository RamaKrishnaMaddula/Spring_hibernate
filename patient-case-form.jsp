<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Maddula Group of Hospitals</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">


<h3>Please enter the additional details</h3>
			<form action="additionalPatientDetails" method="post">
				<input type="hidden" name="pat_id" value="${patient.id}">
				<table>
				<tr><td><label>Sickness: </label></td>
				<td><select name="sick_id">
				<%! int i = 1; %>
				<c:forEach var="tempSickness" items="${sickness}">
				<option value="${tempSickness.id}"> <%= i %>. ${tempSickness.title} </option><% i++; %>
				</c:forEach>
				<% i = 1; %>
				</select></td>
				</tr>
				<tr><td><label>Doctor: </label></td>
				<td><select name="doc_id">
				<%! int j = 1; %>
				<c:forEach var="tempDoctor" items="${doctors}">
				<option value="${tempDoctor.id}"> <%= j %>. Dr. ${tempDoctor.firstName} ${tempDoctor.lastName} </option><% j++; %>
				</c:forEach>
				<% j = 1; %>
				</select></td>
				</tr>
				<tr><td><label>Caretaker: </label></td>
				<td><select name="ctaker_id">
				<%! int k = 1; %>
				<c:forEach var="tempCaretaker" items="${caretakers}">
				<option value="${tempCaretaker.id}"> <%= k %>. ${tempCaretaker.firstName} ${tempcaretaker.lastName} </option><% k++; %>
				</c:forEach>
				<% k = 1; %>
				</select></td>
				</tr>
				<tr><td><label></label></td>
				<td><input type="submit" value="Submit" ></td>
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