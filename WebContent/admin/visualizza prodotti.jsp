<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, model.OrdineCopia, model.ProdottiDAO, model.beans.VideogiocoBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type = "text/css" href="${pageContext.request.contextPath}/css/catalogo_admin.css">
<title>Insert title here</title>
</head>
<body>
	<%	ArrayList <OrdineCopia> prodotti = (ArrayList <OrdineCopia>)request.getAttribute("prodotti");
		ArrayList <VideogiocoBean> videogiochi = (ArrayList <VideogiocoBean>) request.getAttribute("videogiochi");
		ProdottiDAO pdao = new ProdottiDAO();
		if (prodotti == null || videogiochi == null) {
		    response.sendRedirect("./adminCheck");    
		    return;
		}
		
	%>
 	<div class="griglia">
 	<% if (prodotti.size()==0 || videogiochi.size() == 0) { %>
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
           	<form method = "post" action = "./adminDelete">
           		<label for="quantità"> Quantit&agrave;</label>
           		<input type="number" min="1" name = "quantita">
           		<input type="hidden" id="titolo" name="titolo" value = "<%=prodotto.getTitoloVideogioco()%>">
           		<input type="hidden" id="prezzo" name="prezzo" value = "<%=prodotto.getPrezzo()%>">
           		<input type="hidden" id="console" name="console" value = "<%=prodotto.getNomeConsole() %>">
           		<button class="button" id = "BottoneElimina <%=i%>" >Elimina</button>
           		<div class="conferma" id = "Conferma <%=i%>" style="display:none"> <p class="conferma"> Sei sicuro di voler eliminare? </p>
           			<input type="submit" value="SI">
           			<button onclick = "EliminaProdotti (false, <%=i%>)"> NO</button>
           		</div>
           	</form>
            </div>
    	<button class="button" onclick = "ModificaProdotti(true, <%=i%>)">Modifica</button>
    	   <div class = "edit" id = "Modifica <%=i%>" style = "display:none">
    	   	<form method = "post" action = "./adminUpdate?type=copia">
    	   	 <label for="console">Console <span class="required">*</span></label>
 			 <input type="text" id="console" name="console" value = "<%=prodotto.getNomeConsole()%>" required>
 			 <label for="prezzo">Prezzo: <span class="required">*</span></label>
  			 <input type="number" id="prezzo" name="prezzo" step="1.0" required value = "<%=prodotto.getPrezzo()%>" >
  			 <input type="hidden" id="OldConsole" name="OldConsole" value = "<%=prodotto.getNomeConsole()%>">
  			 <input type = "hidden" id = "titolo" name = "titolo" value = "<%=prodotto.getTitoloVideogioco() %>">
  			 <input type = "hidden" id = "OldPrezzo" name = "OldPrezzo" value = "<%=prodotto.getPrezzo()%>">
  			 <input type = "submit" value = "invia">
    	   	</form>
    	   	<button class = "button" onclick = "ModificaProdotti (false, <%=i%>)">Annulla</button>
    	   </div>	
    	</div>
    	<% i++;}} %>
    </div>
    	<div class = "griglia">
    	<%  if(videogiochi != null && videogiochi.size() != 0) {
    		int i = 1;
    		for (VideogiocoBean videogioco : videogiochi) { %>
    		<div class = "prodotto">
    		<h2><%= videogioco.getTitolo() %></h2>
    		<p>Pegi: <%=videogioco.getPegi() %> <br> </p>
    		<p><%=videogioco.getDescrizione() %> </p>
    		<button class="button" onclick="ModificaVideogioco(true, <%=i %>)">Modifica</button>
    			<div class = "edit" id = "ModificaVideogioco <%=i%>" style="display:none">
    				<form method = "post" action = "./adminUpdate?type=videogioco">
    					<label for="descrizione">Descrizione: (lascia il campo vuoto per non modificarla)<span class="required">*</span></label>
  						<textarea id="descrizione" name="descrizione" required></textarea>
 	 					<label for="pegi">Pegi (3-18): <span class="required">*</span></label>
 	 					<input type = "number" name = "pegi" id="pegi" max="18" min ="3"  value = "<%=videogioco.getPegi()%>">
 	 					<input type = "hidden" value = "<%=videogioco.getTitolo() %>" name="titolo">
	    				<input type = "submit" value = "Conferma">
	    				<button class = "button" onclick = "ModificaVideogioco (false, <%=i%>)">Annulla</button>
    				</form>
    			</div> 
    		</div>
    	</div>
    	<% i++; }} %>
    <script src="${pageContext.request.contextPath}/js/admin.js" type="text/javascript"></script>
</body>
</html>