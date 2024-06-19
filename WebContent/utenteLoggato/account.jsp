<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import = "model.beans.ClienteBean,model.AcquistoDAO,model.beans.AcquistoBean,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<title>GDB-Games</title>
	<link rel ="stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/css/account.css" >
</head>
<body>
	  <%
	  	ClienteBean cliente = (ClienteBean) request.getSession().getAttribute("cliente"); 
	  	boolean isAdmin = false;
      	if (cliente != null && "admin".equalsIgnoreCase(cliente.getStato())) {
          	isAdmin = true;
      	}
	  		  AcquistoDAO adao = new AcquistoDAO();
	  	  	  ArrayList <AcquistoBean> ordini = (ArrayList <AcquistoBean>)adao.leggiPerEmail(cliente.getEmail());
	  %>  
	<jsp:include page="../header.jsp"/>

    <%
    	Boolean reclamoFlag = (Boolean)(request.getAttribute("recalmoFlag"));
    %>

    <%
    	if (reclamoFlag != null && reclamoFlag.booleanValue()) {
    %>
        <div class="recalmo-inviato">
           <p>reclamo inviato correttamente</p>
        </div>
     <%
     	}
     %>
		
		<h2> Benvenuto <%=cliente.getNome()%>!</h2>
		<div class="logout">
				<button> <a href="${pageContext.request.contextPath}/utenteLoggato/Logout"> Logout </a></button>
		</div>
		<button class= "mod">Modifica i tuoi dati</button>
		
		<%
    		if (isAdmin) {
		%>
    	<div class="admin-section">
        <button><a href="${pageContext.request.contextPath}\admin\admin.jsp">Funzionalità amministratore</a></button>
    	</div>
		<%
    		}
		%>
		
		
		<h3>I tuoi ordini: </h3>
			<table>
				<tr>
					<td>N. Fattura</td>
					<td>Data </td>
					<td>Prezzo Totale </td>
					<td>Dettagli</td>
				</tr>
				<%
					if (ordini != null && ordini.size() != 0) {
						for(AcquistoBean a : ordini) {
				%>
				<tr>
					<td><%=a.getnFattura()%></td>
					<td><%=a.getdataAcquito()%></td>
					<td><%=a.getPrezzoTotale()%></td>
					<td><a href="./dettagliOrdine?id=<%=a.getnFattura()%>">ordine </a> </td>
				</tr>	
				<%} }%>
			</table>
	<%@include file="/footer.jsp" %>
</body>
</html>