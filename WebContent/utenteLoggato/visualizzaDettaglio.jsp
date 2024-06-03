<%@page import="model.ProdottiDAO"%>
<%@page import="model.AcquistoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.beans.AcquistoBean,java.util.ArrayList,model.OrdineCopia,model.beans.ClienteBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<%
		ClienteBean cliente = (ClienteBean) request.getAttribute("Cliente");
		AcquistoBean ordine = (AcquistoBean) request.getAttribute("Ordine"); 
		ArrayList <OrdineCopia> dettagli = (ArrayList <OrdineCopia>) request.getAttribute("DettagliOrdine");
			if (ordine == null  || dettagli == null)
			{
		response.sendRedirect(request.getServletContext()+"./dettagliOrdine");
			}
	%>
<body>	
		<p>
			<div class = "intestazione">
				<div class="data-numero"><%=ordine.getnFattura() %>    <%=ordine.getdataAcquito()%></div>
			
				<div class="emettitore">
				<h3>GDB-GAMES</h3> <pre>
				Salerno 
				Email: gdbgames@gmail.com 
				P.IVA 05578569413
				</pre>
				</div>
				<div class="destinatario">
				<h3><%=cliente.getNome()%>   <%=cliente.getCognome()%></h3>
				<pre>
				<%=ordine.getCitta() %>
				<%=ordine.getVia() %>
				<%=ordine.getemailcliente() %>
				</pre>
				</div>
			</div>
			<div class = "corpo">
			<b>TOTALE: </b><%=ordine.getPrezzoTotale()%> &euro;
			<b>QUANTITÀ: </b> <%= dettagli.stream().mapToInt(OrdineCopia::getQuantità).sum()%>
			<table class="dettagli prodotti">
				<tr class="titoli-tabella">
					<th>Titolo </th>
					<th>Quantità </th>
					<th>Prezzo </th>
					<th>IVA </th>
					<th>Immagine </th>
				</tr>
				<% for(OrdineCopia o : dettagli) {%>
				<tr class="corpo-tabella">
					<td><%=o.getTitoloVideogioco() %></td>
					<td><%=o.getQuantità() %></td>
					<td><%=o.getPrezzoTotale()%> </td>
					<td><%=o.getPercIva() %> </td>
					<td><img src="./getFoto?titolo=<%=o.getTitoloVideogioco()%>" alt="immagine del videogioco non trovata" width="500px"> </td>
					<%} %>
			</table>
			</div>
</body>
</html>