<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!Doctype html public "-//w3c//dtd html 4.01 transitional//en" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<title>update patient</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>maddula group of hospitals</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<form name="updatepatient" action="updatePatient" method="post" modelAttribute="${patient}">
				<input type="hidden" name="pat_id" value="${patient.id}">
				<table>
					<tr>
						<th>first name:</th>
						<td><input type="text" value="${patient.firstName}"
							name="firstName" /></td>
					</tr>
					<tr>
						<th>last name:</th>
						<td><input type="text" value="${patient.lastName}"
							name="lastName" /></td>
					</tr>
					<tr>
						<th>city:</th>
						<td><input type="text" value="${patient.city}" name="city" /></td>
					</tr>
					<tr>
						<td><label>doctor: </label></td>
						<td><select name="doc_id">
								<%!int j = 1;%>
								<c:forEach var="tempdoctor" items="${doctor}">
									<option value="${tempdoctor.id}">
										<%=j%>. Dr. ${tempdoctor.firstName} ${tempdoctor.lastName}
									</option>
									<%
										j++;
									%>
								</c:forEach>
								<%
									j = 1;
								%>
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
					<tr>
						<th></th>
						<td><input type="submit" value="update patient"></td>
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
