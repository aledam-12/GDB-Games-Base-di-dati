<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, model.OrdineCopia, model.ProdottiDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type = "text/css" href="${pageContext.request.contextPath}/css/catalogo_admin.css">
<title>Insert title here</title>
</head>
<body>
	<%	ArrayList <OrdineCopia> prodotti = (ArrayList <OrdineCopia>)request.getAttribute("prodotti");
		ProdottiDAO pdao = new ProdottiDAO();
		if (prodotti == null) {
		    response.sendRedirect("./adminCheck");    
		    return;
		}
		
	%>
 	<div class="griglia">
 	<% if (prodotti.size()==0) { %>
 		<div class="scritta"><h2>Nessun prodotto in vendita</h2></div>
 		<%} %>
 		
        <%
        	if(prodotti != null && prodotti.size() != 0) {
        		int i = 1;
        		for (OrdineCopia prodotto : prodotti){
        %>
        <div class="prodotto">
            <a href="../controlloCatalogo?action=read&id=<%=pdao.leggiOrdineCopia(prodotto).getCodiceCopia()%>&titolo=<%=prodotto.getTitoloVideogioco()%>" target="_blank">
                <img src="../getFoto?titolo=<%=prodotto.getTitoloVideogioco()%>" alt="Immagine del videogioco non trovata">
            </a>
            <h2><%= prodotto.getTitoloVideogioco() %></h2>
            <h4> <b><%=prodotto.getPrezzo()%> &euro;</b></h4>
            <p>Console: <b><%=prodotto.getNomeConsole() %></b></p>
            <p> Quantit&agrave;: <b><%=prodotto.getQuantità()%></b> </p>
            <button class="button" onclick = "EliminaProdotti(true, <%=i%>)">Elimina</button>
            <div class = "elimina" style="display:none" id ="Elimina <%=i%>">
           	<form method = "post">
           		<label for="quantità"> Quantit&agrave;</label>
           		<input type="number" min="1">
           		<button class="button" id = "BottoneElimina <%=i%>" >Elimina</button>
           		<div class="conferma" id = "Conferma <%=i%>" style="display:none"> <p class="conferma"> Sei sicuro di voler eliminare? </p>
           			<input type="submit" value="SI">
           			<button onclick = "EliminaProdotti (false, <%=i%>)"> NO</button>
           		</div>
           	</form>
        </div>
    </div>
    <% i++;}} %>
    </div>
    <script src="${pageContext.request.contextPath}/js/admin.js" type="text/javascript"></script>
</body>
</html>