<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GDB-Games</title>
	</head>
	<body>
	<div id="signUpForm" style="display:none">
		<form action = "./controlloRegistrazione" method="post">
			<fieldset>
				<legend><h2><b>Dati anagrafici</b></h2></legend>
					<label for="nome">Nome</label> <br>
					<input type="text" placeholder="Mario" name="nome" required> <br>
					<label for="cognome">Cognome</label> <br>
					<input type="text" placeholder="Rossi" name="cognome" required> <br>
			</fieldset>
			<fieldset>
				<legend><h2><b>Indirizzo per la spedizione</b></h2></legend>
					<label for="indirizzo">Indirizzo</label> <br>
					<input type="text" name="Via" placeholder="Via Roma" required> <br>
					<label for="civico">Numero Civico</label> <br>
					<input type="number" name="NCivico" placeholder="7" max = "999" min="1" required> <br>
					<label for="Città">Città</label> <br>
					<input type="text" name="città" placeholder="Roma" required> <br>
					<label for="CAP">CAP</label> <br>
					<input type="number" name="cap" placeholder="11111" max = "99999" min="0" required> <br>
					<label for="provincia">Provincia</label><br>
					<input type = "text" name="provincia" placeholder="Salerno"><br>
			</fieldset>
			<fieldset>
				<legend><h2><b>Credenziali per l'accesso</b></h2></legend>
					<label for="email">Email</label> <br>
					<input type="email" name="emailCliente" placeholder="example@domain.com" required> <br>
					<label for="email">Password</label> <br>
					<input type="password" name="pwCliente" placeholder="xxxxxx" required> <br>
			</fieldset>
				<input type = "submit" value = "invia" class = "button">
				<input type = "reset" class = "button">
			</form>
			</div>
			<script src="${pageContext.request.contextPath}/formValidation.js"></script>
			<div class="form-not-valid"> </div>
	</body>
</html>
