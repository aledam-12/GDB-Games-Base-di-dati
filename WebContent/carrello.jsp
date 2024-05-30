<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,model.OrdineCopia" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GDB Games</title>
</head>
<%  ArrayList <OrdineCopia> prodotti = (ArrayList <OrdineCopia>)session.getAttribute("prodottiCarrello");
	if (prodotti == null) {
		response.sendRedirect("./controlloCarrello?action=view");	
		return;
	}	
if (prodotti.size() == 0) {
	%>
	<p>il carrello è vuoto, torna al <a href="catalogo.jsp">catalogo </a> per aggiungere i nostri prodotti </p>
	<% }
	for ( OrdineCopia copia : prodotti) {
%>
<h4><%= copia.getTitoloVideogioco() %></h4>
<p> Prezzo: <b><%=copia.getPrezzo()%> &euro; </b>
<p>Console: <b><%=copia.getNomeConsole() %></b>
<p> Quantità: <%=copia.getQuantità() %> </p>
<form action="./controlloCarrello" method="get">
<select name="quantita">
<option value="1"> 1</option>
<option value="2"> 2</option>
<option value="3"> 3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>
<input type="hidden" value="add" name="action">
<input type="hidden" value="<%=copia.getCodiceCopia()%>" name="id">
<input type="submit" value="aggiorna">
</form>
<p> IVA: <%=copia.getPercIva()%>%</p>
<a href="./controlloCatalogo?action=read&id=<%= copia.getCodiceCopia() %>&titolo=<%=copia.getTitoloVideogioco()%>" target = "_blank"> 
	<img src="./getFoto?titolo=<%=copia.getTitoloVideogioco()%>" alt="immagine del videogioco non trovata" width="500px"> </a> <br>
<a href="./controlloCarrello?action=remove&id=<%=copia.getCodiceCopia()%>"> rimuovi dal carrello </a>
<p>------------------------------------------------------------------------------------</p>
<% } %>
<h3>Totale: </h3>
	<p>	Prezzo: <%=prodotti.stream().mapToDouble(OrdineCopia::getPrezzoTotale).sum()%>&euro; <br>
		Totale elementi: <%=prodotti.stream().mapToInt(OrdineCopia::getQuantità).sum()%>
	</p>
<h3> Finalizza Acquisto:  </h3>
<a href="utenteLoggato/FinalizzaAcquisto.jsp">Finalizza</a>
<body>
</body>
</html>
<%@include file="footer.jsp" %>