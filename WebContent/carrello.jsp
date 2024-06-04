<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,model.OrdineCopia" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GDB Games</title>
<link rel="stylesheet" href="css/carello.css">
</head>
<body>
<%
    ArrayList<OrdineCopia> prodotti = (ArrayList<OrdineCopia>)session.getAttribute("prodottiCarrello");
    if (prodotti == null) {
        response.sendRedirect("./controlloCarrello?action=view");    
        return;
    }    
    if (prodotti.size() == 0) {
%>    
    <div class="scritta">
        <h2>Carrello vuoto!!</h2>
        <button><a href="catalogo.jsp">Continua ad acquistare!!</a></button>
    </div>
<%
    } else {
%>
<div class="totale-container">
    <h2>Totale da pagare:</h2>
    <p>
        Totale articoli: <%=prodotti.stream().mapToInt(OrdineCopia::getQuantità).sum()%><br> 
    </p>
    <div>
    <% for (OrdineCopia copia : prodotti) { %>
        <div>
            <ul>
            <li><span><%= copia.getTitoloVideogioco() %></span> - 
            <span><%= copia.getPrezzo() %> &euro;</span></li> 
            </ul>
        </div>
    <% } %>
    <br>
    <h3> Totale: <%=prodotti.stream().mapToDouble(OrdineCopia::getPrezzoTotale).sum()%> &euro;</h3>
    </div>
    <br>
    <button><a href="utenteLoggato/FinalizzaAcquisto.jsp">Acquista</a></button>
</div>
<br>
<div class="prodotti-container">
    <%
        for (OrdineCopia copia : prodotti) {
    %>
    <div class="prodotto">
        <a href="./controlloCatalogo?action=read&id=<%= copia.getCodiceCopia() %>&titolo=<%=copia.getTitoloVideogioco()%>" target="_blank">
            <img src="./getFoto?titolo=<%=copia.getTitoloVideogioco()%>" alt="Immagine del videogioco non trovata">
        </a>
        <div class="el">
            <h2><%= copia.getTitoloVideogioco() %></h2>
            <p>Console: <b><%=copia.getNomeConsole() %></b></p>
            <p class="prezzo"> <%=copia.getPrezzo()%> &euro;</p>
        </div>
        <div class="quantita">
            <h4>Quantità: </h4>
            <button onclick="updateQuantity(<%=copia.getCodiceCopia()%>, -1)">-</button>
    		<span id="quantita<%=copia.getCodiceCopia()%>"><%=copia.getQuantità()%></span>
    		<button onclick="updateQuantity(<%=copia.getCodiceCopia()%>, 1)">+</button>
		</div>
        <a class="rimuovi" href="./controlloCarrello?action=remove&id=<%=copia.getCodiceCopia()%>"><img src="foto/x.png" alt="Rimuovi"></a>
    </div>
    <script>
    function updateQuantity(codiceCopia, change) {
        var currentQuantity = parseInt(document.getElementById('quantita' + codiceCopia).innerText);
        var newQuantity = currentQuantity + change;
        if (newQuantity < 1 || newQuantity > 10) {
            return; // Limita la quantità tra 1 e 10
        }
        // Invia la richiesta al server tramite AJAX
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "./controlloCarrello?action=update&id=" + codiceCopia + "&quantita=" + newQuantity, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // Aggiorna la quantità visualizzata senza ricaricare la pagina
                document.getElementById('quantita' + codiceCopia).innerText = newQuantity;
            }
        };
        xhr.send();
    }
</script>
    <%
        }
    %>
</div>
<%
    }
%>
</body>
</html>
<%@include file="footer.jsp" %>
