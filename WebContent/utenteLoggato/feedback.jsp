<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Inserimento feedback</title>
<link rel ="stylesheet" type = "text/css" href = "Funzioni_Admin/stile_inserire_videogiochi.css" > 
</head>
<body>
<div class="header"><%@include file="../header.jsp" %></div>

<div class= "reclamo">
<form action="/url-form" method="post">
    <div class="error-message">
    	<p><h3><b>I campi con l'asterisco (*) sono obbligatori.</b></h3></p>
    </div>
  
  <fieldset>
    <legend><h3><b>Feedback</b></h3></legend>
    
    <label for="titolo">Titolo: <span class="required">*</span></label>
    <input type="text" id="titolo" name="titolo" required>
    
    <label for="messaggio">Messaggio: <span class="required">*</span></label>
    <textarea id="messaggio" name="descrizione" required></textarea>
  </fieldset>
  
  <input type="submit" value="Invia feedback">
</form>
</div>
<div class="f"><%@include file="../footer.jsp" %></div>
</body>
</html>
