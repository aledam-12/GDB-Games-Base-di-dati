<%@include file="header.jsp" %>
<%@ page import="java.util.ArrayList,model.OrdineCopia" %>
<%
	ArrayList <OrdineCopia> copie = (ArrayList<OrdineCopia>)request.getAttribute("copieVideogiochi");    
if(copie == null) {
    response.sendRedirect("./controlloCatalogo");    
    return;
}
%>
<!DOCTYPE html>
<html>

<head>
    <title>GDB Games</title>
     <link rel="stylesheet" href="css/stile_catalogo.css">
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var currentIndex = 0;
            var images = document.querySelectorAll('.carousel img');
            var totalImages = images.length;

            function showImage(index) {
                images.forEach((img, i) => {
                    img.style.display = (i === index) ? 'block' : 'none';
                });
            }

            function nextImage() {
                currentIndex = (currentIndex + 1) % totalImages;
                showImage(currentIndex);
            }

            setInterval(nextImage, 3000); // Cambia immagine ogni 3 secondi

            showImage(currentIndex);
        });
    </script>
</head>

<body>
	
    <%
    	// Here negative login feedback 
        Boolean feedbackLog = (Boolean) session.getAttribute("feedbackLog");
    %>
    <%
    	// For mail  
        if(feedbackLog != null && feedbackLog){
    %>
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
    <div id="message">Login correttamente effettuato.</div>
    <%
    	}
    %>
    <table id = "SearchResult"></table>
    <div class="novita">
        <div class="carousel">
            <img src="foto\ACS.jpg" alt="Collector edition assassin creed shadow">
            <img src="foto\GTA 6.jpg" alt="GTA 6">
            <img src="foto\NSwitch.jpg" alt="NovitÃ  Switch">
            <img src="foto\PrinceOfPersiaTheLostCrown.jpg" alt="Prince Of Persia The Lost Crown">
        	<img src="foto\Sea of Thieves.png" alt="Sea of Thieves">
        </div>
    </div> 

    <h2>Selezione di prodotti per pc:</h2>
    <div class="griglia">
        <%
        	if(copie != null && copie.size() != 0) {
                for (OrdineCopia copia : copie) { 
                  if ("PC".equals(copia.getNomeConsole())) {
        %>
        <div class="prodotto">
            <a href="controlloCatalogo?action=read&titolo=<%=copia.getTitoloVideogioco()%>&console=<%=copia.getNomeConsole()%>&prezzo=<%=copia.getPrezzo()%>" target="_blank">
                <img src="./getFoto?titolo=<%=copia.getTitoloVideogioco()%>" alt="Immagine del videogioco non trovata">
            </a>
            <h2><%= copia.getTitoloVideogioco() %></h2>
            <h4> <b><%=copia.getPrezzo()%> &euro;</b></h4>
            <p>Console: <b><%=copia.getNomeConsole() %></b></p> <br>
            <p>Quantit&agrave;: <b><%=copia.getQuantità()%></b> </p> 
        </div>
        <% } } }%>
    </div>
<div class = "fine">
<%@include file="footer.jsp" %>
</div>
</body>
</html>
