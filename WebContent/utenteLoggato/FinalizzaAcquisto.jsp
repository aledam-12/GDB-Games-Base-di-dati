<%@ page import="control.ControlloCarrello"%>
<%@ page import="java.util.Collection"%>
<%@ page import="control.Carrello"%>
<%@ page import="model.OrdineCopia" %>
<%@ page import="model.beans.AcquistoBean"%>
<%@ page import="model.beans.ClienteBean"%>
<%@ page import="java.time.LocalDate"%>
<%
	Carrello carrello = (Carrello) session.getAttribute("carrello");
	Collection <?> oggettiCarrello = carrello.viewCart();
%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout</title>
</head>

<body>
	<%@ include file="../header.jsp"%>
	<%
		float prezzoTot = (float) carrello.getPrezzoTotale();
		if (carrello==null || carrello.viewCart().size()==0) {
	%>
		<h3> non puoi finalizzare l'acquisto di un carrello vuoto! torna al <a href="../catalogo.jsp">catalogo</a> </h3>
	<% return;
		}
	%>
	<table id="checkoutTable">
		<tr>
			<th colspan="3">Riepilogo Ordine</th></tr>
			<tr>
				<th>Titolo</th>
				<th>Quantità</th>
				<th>Console </th>
			</tr>
			<%
			if (carrello != null) {
			for (OrdineCopia c : carrello.viewCart()) {
			%>
			<tr> 
				<td><%=c.getTitoloVideogioco() %></td>
				<td><%=c.getQuantità()%></td>
				<td><%=c.getNomeConsole()%></td>
			</tr>
			<%}} %>
	</table>
		<h2>Dettagli Ordine</h2>
			<form action="./Checkout" method="post">
				<label for="numCartaNuova">Numero sulla carta </label>
				<input type="number" id="numCartaNuova" name="numCarta" required><br>
				<label for="via-spedizione">Via </label>
				<input type="text" id="via-spedizione" name="via-spedizione" required> <br>
				<label for="cap-spedizione">CAP </label>
				<input type="number" id="cap-spedizione" name="cap-spedizione" required><br>
				<label for="citta-spedizione">Citt&agrave;</label>
				<input type="text" id="citta-spedizione" name="citta-spedizione" required><br>
				<input type="submit" id="finalizza" name="FinalizzaAcquisto" value="Conferma Ordine">  
			</form>
	<%@ include file="../footer.jsp"%>
</body>
</html>