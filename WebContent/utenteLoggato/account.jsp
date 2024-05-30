<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import = "model.beans.clienteBean, model.AcquistoDAO, model.beans.acquistoBean, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<title>GDB-Games</title>
</head>
<body>
	  <% 
	  clienteBean cliente = (clienteBean) request.getSession().getAttribute("cliente"); 
	  AcquistoDAO adao = new AcquistoDAO();
	  ArrayList <acquistoBean> ordini = (ArrayList <acquistoBean>)adao.leggiPerEmail(cliente.getEmail());
	%>  
	<jsp:include page="../header.jsp"/>

    <%
    Boolean reclamoFlag = (Boolean)(request.getAttribute("recalmoFlag"));
    %>

    <% if (reclamoFlag != null && reclamoFlag.booleanValue()) { %>
        <div class="recalmo-inviato">
           <p>reclamo inviato correttamente</p>
        </div>
     <% } %>

		<h1> Benvenuto <%=cliente.getNome()%></h1>
		<h2>Visualizza i tuoi ordini </h2>
			<table>
				<tr>
					<td>N. Fattura</td>
					<td>Data </td>
					<td>Prezzo Totale </td>
					<td>Dettagli</td>
				</tr>
				<%if (ordini != null && ordini.size() != 0) {
				for(acquistoBean a : ordini) {
				%>
				<tr>
					<td><%=a.getnFattura()%></td>
					<td><%=a.getdataAcquito()%></td>
					<td><%=a.getPrezzoTotale()%></td>
					<td><a href="./dettagliOrdine?id=<%=a.getnFattura()%>">Dettagli </a> </td>
				</tr>	
				<%} }%>
			</table>
		
		<h2>Modifica i tuoi dati</h2>
		<h2>Logout</h2>
		<button> <a href="./Logout"> Logout </a></button>
	<%@include file="/footer.jsp" %>
</body>
</html>