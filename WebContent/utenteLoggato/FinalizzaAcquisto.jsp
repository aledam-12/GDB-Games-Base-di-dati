<%@ page import="control.ControlloCarrello"%>
<%@ page import="java.util.Collection"%>
<%@ page import="control.Carrello"%>
<%@ page import="model.OrdineCopia" %>
<%@ page import="model.beans.AcquistoBean"%>
<%@ page import="model.beans.ClienteBean"%>
<%@ page import="java.time.LocalDate"%>
<%
    Carrello carrello = (Carrello) session.getAttribute("carrello");
    Collection <?> oggettiCarrello = carrello.viewCart();
%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/FinalizzaAcquisto.css">
</head>
<body>
    <%@ include file="../header.jsp"%>
    <%
        float prezzoTot = (float) carrello.getPrezzoTotale();
        if (carrello == null || carrello.viewCart().size() == 0) {
    %>
        <h3>Non puoi finalizzare l'acquisto di un carrello vuoto! Torna al <a href="../catalogo.jsp">catalogo</a></h3>
    <% return;
        }
    %>
    <h1>Riepilogo ordine:</h1>
    <h2 class= "tot">Totale ordine: <%= prezzoTot %> &euro;</h2>
    <table id="checkoutTable">
        <tr>
            <th colspan="3"><h2>Articoli:</h2></th>
        </tr>
        <tr>
            <th><h3>Titolo</h3></th>
            <th><h3>Quantit�</h3></th>
            <th><h3>Console</h3></th>
        </tr>
        <%
        if (carrello != null) {
            for (OrdineCopia c : carrello.viewCart()) {
        %>
        <tr>
            <td><%= c.getTitoloVideogioco() %></td>
            <td><%= c.getQuantit�() %></td>
            <td><%= c.getNomeConsole() %></td>
        </tr>
        <% }} %>
    </table>
    <div class="error-message">I campi con l'asterisco (*) sono obbligatori.</div>
    <form action="./Checkout" method="post">
        <!-- Indirizzo di Spedizione -->
        <fieldset>
            <legend><h2>Indirizzo di spedizione</h2></legend>
            <label for="via-spedizione"><h3>Via: <span class="required">*</span></h3></label>
            <input type="text" id="via-spedizione" name="via-spedizione" required>
            <label for="cap-spedizione"><h3>CAP: <span class="required">*</span></h3></label>
            <input type="number" id="cap-spedizione" name="cap-spedizione" required>
            <label for="citta-spedizione"><h3>Citt�: <span class="required">*</span></h3></label>
            <input type="text" id="citta-spedizione" name="citta-spedizione" required>
        </fieldset>
        
        <!-- Metodo di Pagamento -->
        <fieldset>
            <legend><h2>Metodo di pagamento</h2></legend>
            <label for="numCartaNuova"><h3>Numero carta: <span class="required">*</span></h3></label>
            <input type="number" id="numCartaNuova" name="numCarta" required><br>
        </fieldset>
        
        
        <input type="submit" id="finalizza" name="FinalizzaAcquisto" value="Acquista">
    	
    </form>
    <br><br>
    <div class="fine">
    	<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>