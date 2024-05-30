<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Errore 404 - Pagina Non Trovata</title>
<link rel ="stylesheet" type = "text/css" href = "stile_errori.css" > 
</head>
<body>
<% String homePath = request.getContextPath()+"/catalogo.jsp";%>
<div class="container">
    <div class="error-content">
    	<div class ="header">
		<h1>Ops! <br> Errore!!!</h1>
		<img src = "${pageContext.request.contextPath}/errori/fotofoto/bomba-errori.png" alt = "pupazzetto per l'errore" style = "width: 150px; height: 150px;">
    	</div>
        <p>Siamo spiacenti c'&egrave; stato un problema con il raggiungimento del sito. Riprovare pi&ugrave; tardi.</p>
        <p><button class = "button" id = "home-button">Torna alla pagina principale</a></button></p>
    </div>
    <div class="error-image">
        <img src="foto\kratos-foto-errori.png" alt="kratos incazzato per l'errore">
    </div>
</div>
</body>
<script>
document.getElementById("home-button").addEventListener("click", function() {
  window.location.href = "catalogo.jsp";
});
</script>
</html>