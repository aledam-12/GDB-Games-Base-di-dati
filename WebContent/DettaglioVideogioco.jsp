<%@  page import = "model.beans.CopiaBean,model.beans.VideogiocoBean" %>
<!DOCTYPE html>
<html>
<head>
<title>GDB Games</title>
<link rel="stylesheet" href="css/Dettaglio_Videogioco.css">
</head>
<body>
	<div class = "head">
		<%@include file="header.jsp" %>
    </div>
    <%
    	CopiaBean copia = (CopiaBean) request.getAttribute("copia");
    %>
    <%
    	VideogiocoBean videogioco = (VideogiocoBean) request.getAttribute("videogioco");
    %>
    <% if (videogioco != null && copia != null) { %>
        <div class="container">
            <div class="gioco">
                <img src="./getFoto?titolo=<%=copia.getTitoloVideogioco()%>" alt="immagine del videogioco non trovata">
                <h2><%=videogioco.getTitolo()%></h2>
            </div>
            <div class="details">
                <div class= "pegi">
                	<h1><%=videogioco.getPegi() %></h1>
                	<a href = "https://pegi.info/it">www.pegi.info</a>
                </div>
                <div class="desc">
                	<h2>Cosa giocherai:</h2>
                	<p><%=videogioco.getDescrizione() %></p>
                </div>
                <div class = "mprod">
                <p> <%=copia.getPrezzo()%> &euro;</p>
                <button class="button"><a href="controlloCarrello?action=add&id=<%=copia.getCodiceCopia()%>"> Aggiungi al carrello</a></button>
            	</div>
            </div>
        </div>
    <% } %>
</body>
<%@include file="footer.jsp" %>
</html>
