<%@include file="header.jsp" %>
<%@ page import="java.util.ArrayList, model.beans.copiaBean" %>
<%
ArrayList <copiaBean> copie = (ArrayList<copiaBean>)request.getAttribute("copieVideogiochi");	
if(copie == null) {
		response.sendRedirect("./controlloCatalogo");	
		return;
	} %>
<!DOCTYPE html>
<html>


	<head>
		<title>GDB Games</title>
	</head>
	
	<body>

		<%  //here negative login feedback 

    Boolean feedbackLog = (Boolean) session.getAttribute("feedbackLog");    
    %>

    <%   //for mail  
	    if(feedbackLog != null && feedbackLog){    %>
        <script>
			changeForm("signUp");

            document.addEventListener('DOMContentLoaded', function() {
                var messageDiv = document.getElementById('message');    
                messageDiv.style.display = 'block';
    
                setTimeout(function() {
                    messageDiv.style.display = 'none';
                }, 5000);
            });
        </script>
		

		<div id="message">login correttamente effetturato.</div>
		
		<% }%>

	<h1> Scegli tra i nostri prodotti! </h1>
	<div class = "prodottoContainer">
 	<% if(copie != null && copie.size() != 0) {
	for (copiaBean copia : copie) {%>
	<div class="prodotto">
	<h4><%= copia.getTitoloVideogioco() %></h4>
	<p> Prezzo: <b><%=copia.getPrezzo()%> &euro; </b>
	<p>Console: <b><%=copia.getNomeConsole() %></b>
	<p> IVA: <%=copia.getPercIva()%>%</p>
	<a href="controlloCatalogo?action=read&id=<%=copia.getCodiceCopia()%>&titolo=<%=copia.getTitoloVideogioco()%>"target = "_blank"> 
	<img src="./getFoto?titolo=<%=copia.getTitoloVideogioco()%>" alt="immagine del videogioco non trovata" width="500px"> </a> <br>
	<button> <a href="controlloCarrello?action=add&id=<%=copia.getCodiceCopia()%>"> Aggiungi al carrello </a> </button><br>
	</div>
	<% }} %>
	</div>
	</body>
	</html>
	<%@include file="footer.jsp" %>