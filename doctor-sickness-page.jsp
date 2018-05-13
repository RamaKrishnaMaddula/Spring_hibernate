<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doc-sickness-list</title>
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

			<form action="addSicknessToDoctor" method="get">
				<table>
					<tr>
						<td><select name="sicknessId">
								<%
									int j = 1;
								%>
								<c:forEach var="tempSickness" items="${allSickness}">
									<option value="${tempSickness.id}"><%=j%>. ${tempSickness.title}
									</option>
									<%
										j++;
									%>
								</c:forEach>
								<%
									j = 1;
								%>
						</select></td>
						<td><input type="hidden" name="doctorId" value="${doctor.id}">
							<input type="submit" value="Add Sickness" class="add-button" /></td>
					</tr>
				</table>
			</form>


			<table>
				<tr>
					<th>S.no</th>
					<th align="left">Title</th>
					<th>Details</th>
				</tr>

				<!-- We need a loop here to retrieve all the customers -->
				<%!int i = 1;%>
				<c:forEach var="tempSickness" items="${sickness}">
					
					<tr>

						<td><%=i%></td>
						<%
							i++;
						%>
						<td align="left">${tempSickness.title}</td>
						<td><a href="${detailLink}">@</a></td>
					</tr>
				</c:forEach>
				<%
					i = 1;
				%>
			</table>
			<br> <br>
		</div>
	</div>


	<br>
	<br>
	<a href="home"><b>Home</b></a>
</body>
</html>