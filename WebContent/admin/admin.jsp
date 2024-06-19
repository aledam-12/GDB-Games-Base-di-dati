<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel ="stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/css/funAdmin.css" >
		<title>GDB-Games</title>
	</head>
	<body>
		<jsp:include page="../header.jsp" />
		<div class= "titoli">
			<h2>inserisci nuovi prodotti:</h2>
			<h2>inserisci copia del prodotto:</h2>
		</div>
		<div class="inserisci">
			<%@ include file = "inserire_videogiochi.html"%><br>
			<%@ include file = "inserire_copia.html"%> <br>
		</div>
				<h2 class = "h">Ricerca ordini:</h2>
				<div class = "ordini">
				<form method="GET" action = "../admin/adminCheck">
						<div class="error-message">I campi con l'asterisco (*) sono obbligatori.</div>
						<label for="email"> Email: <span class="required">*</span></label>
						<input type="email" name="email-cliente" placeholder="example@mail.com">
						<label for="data inizio"> Data Inizio: <span class="required">*</span></label>
						<input type="date" name="inizio" id="dataInzio" required>
						<label for="data fine"> Data fine: <span class="required">*</span></label>
						<input type="date" name="fine" id="dataFine" required>
						<input type="submit" value="Cerca">
						<input type="reset" value="Cancella">
						<button onclick='window.location.href="../admin/adminCheck"'>Tutti gli ordini</button>
				</form>
			</div>
		<h2>Visualizzazione ordini:</h2>
		<%@ include file = "visualizza ordini.jsp"%>
		<h2>Modifiche del catalogo:</h2>
		<%@ include file="visualizza prodotti.jsp" %>
			<h2 class = "h"> Ricerca clienti: </h2>
			<div class = "clienti">
				<form method="GET" action = "../admin/adminCheck">
						<div class="error-message">I campi con l'asterisco (*) sono obbligatori.</div>
						<label for="email"> Email: <span class="required">*</span></label>
						<input type="email" name="email-utente" placeholder="example@mail.com"> <br>
						<input type="submit" value = "Cerca">
				</form>
				</div>
				<h2>Visualizzazione clienti:</h2>
		<%@ include file = "visualizza clienti.jsp" %>
		<%@ include file = "visualizza_reclami.jsp" %>
		<%@ include file="../footer.jsp"%>
	</body>	
</html>