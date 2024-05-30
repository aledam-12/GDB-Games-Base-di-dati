<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Errore 404 - Pagina Non Trovata</title>
<link rel ="stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/errori/stile_errori.css" > 
</head>
<body>
<div class="container">
    <div class="error-content">
    	<div class ="header">
		<h1>Ops! <br> Errore 404</h1>
		<img src = "${pageContext.request.contextPath}/errori/foto/bomba-errori.png" alt = "pupazzetto per l'errore" style = "width: 150px; height: 150px;">
    	</div>
        <p>La pagina che stai cercando non &egrave; stata trovata. Potrebbe essere stata rimossa, avere cambiato nome o essere temporaneamente non disponibile.</p>
        <p><button class = "button" id="home-button">Torna alla pagina principale</a></button></p>
    </div>
    <div class="error-image">
        <img src="${pageContext.request.contextPath}/errori/foto/kratos-foto-errori.png" alt="kratos incazzato per l'errore">
    </div>
</div>
</body>
<script>
document.getElementById("home-button").addEventListener("click", function() {
  window.location.href = "catalogo.jsp";
});
</script>
</html>