<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Maddula Group of Hospitals</h1>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<b><input type="button" value="DOCTOR"
				onclick="window.location.href='showDoctorsPage'; return false;"
				class="add-button" align="middle"/><br><br>
				<input type="button" value="PATIENT"
				onclick="window.location.href='showPatientsPage'; return false;"
				class="add-button" /><br><br>
				<input type="button" value="SICKNESS"
				onclick="window.location.href='showSicknessPage'; return false;"
				class="add-button" /><br><br>
				<input type="button" value="CARETAKERS"
				onclick="window.location.href='showCareTakerPage'; return false;"
				class="add-button" /><br><br>
			</b>
		</div>
	</div>
</body>
</html>