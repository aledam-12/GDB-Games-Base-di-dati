<%@page import="model.ProdottiDAO"%>
<%@page import="model.AcquistoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.beans.AcquistoBean,java.util.ArrayList,model.OrdineCopia,model.beans.ClienteBean" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fattura.css">
<meta charset="ISO-8859-1">
<title>GDBGames</title>
</head>
	<jsp:include page="../header.jsp"/>
	<%
		ClienteBean cliente = (ClienteBean) request.getAttribute("Cliente");
		AcquistoBean ordine = (AcquistoBean) request.getAttribute("Ordine"); 
		ArrayList <OrdineCopia> dettagli = (ArrayList <OrdineCopia>) request.getAttribute("DettagliOrdine");
			if (ordine == null  || dettagli == null)
			{
		response.sendRedirect(request.getServletContext()+"./dettagliOrdine");
			}
	%>
<body class="fattura">	
		<p>
			<div class="titolo">
			<div class="numero">N.Fattura: <%=ordine.getnFattura() %></div><div class="data">Data: <%=ordine.getdataAcquito()%></div>
				</div>
			<div class = "intestazione">
			<b>TOTALE: </b><%=ordine.getPrezzoTotale()%>&euro;
			<b>QUANTIT�: </b> <%= dettagli.stream().mapToInt(OrdineCopia::getQuantit�).sum()%>
				<div class="emettitore">
				<h3>GDB-GAMES</h3> 
				<p>
				Salerno <br>
				Email: gdbgames@gmail.com  <br>
				P.IVA 05578569413 <br>
				</p>
				</div>
				<div class="destinatario">
				<h3> Spettabile <%=cliente.getNome()%>   <%=cliente.getCognome()%></h3>
				<p>
				<%=ordine.getCitta() %> <br>
				<%=ordine.getVia() %> <br>
				<%=ordine.getemailcliente() %> <br>
				</p>
				</div>
			</div>
			<div class = "corpo">
			<table class="dettagli-prodotti">
				<tr class="titoli-tabella">
					<th>Titolo </th>
					<th>Quantit� </th>
					<th>Prezzo </th>
					<th>IVA </th>
					<th>Immagine </th>
				</tr>
				<% for(OrdineCopia o : dettagli) {%>
				<tr class="corpo-tabella">
					<td><%=o.getTitoloVideogioco() %></td>
					<td><%=o.getQuantit�() %></td>
					<td><%=o.getPrezzoTotale()%>&euro;</td>
					<td><%=o.getPercIva() %>% </td>
					<td id="riga-img"><img src="../getFoto?titolo=<%=o.getTitoloVideogioco()%>" alt="immagine del videogioco non trovata" width="100px" height="100px" class="immagine"> </td>
					<%} %>
			</table>
			</div>
		<%@include file="../footer.jsp" %>
</body>
</html>