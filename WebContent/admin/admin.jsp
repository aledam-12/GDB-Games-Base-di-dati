<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>GDB-Games</title>
	</head>
	<body>
		<jsp:include page="../header.jsp" />
		<h3>inserisci nuovi prodotti</h3>
		<%@ include file = "inserire_copia.html"%> <br>
		<%@ include file = "inserire_videogiochi.html"%>
				<h3>Cerca ordini</h3>
				<div class = "form-container">
				<form method="GET" action = "../admin/adminCheck">
						<label for="email"> Email </label>
						<input type="email" name="email-cliente" placeholder="example@mail.com">
						<label for="data inizio"> Data Inizio* </label>
						<input type="date" name="inizio" required>
						<label for="data fine"> Data fine* </label>
						<input type="date" name="fine" required>
						<input type="submit" value="cerca">
				</form>
				<button onclick='window.location.href="../admin/adminCheck"'>Visualizza tutti</button>
			</div>
		<h3>Visualizza ordini</h3>
		<%@ include file = "visualizza ordini.jsp"%>
		
		
		<%@ include file="../footer.jsp" %>
		
		
	</body>	
</html>