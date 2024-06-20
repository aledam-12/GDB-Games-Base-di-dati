<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <title>header</title>
    <%@ page import = "model.beans.ClienteBean"%>
</head>
<body>
	<% String nomeHeader; 
	if (session.getAttribute("nomeCliente") != null) {
	nomeHeader = (String) session.getAttribute("nomeCliente"); }
	else nomeHeader = "Accedi";
	%>
	<header>
    <div class="sinistra">
    	
        <img src="${pageContext.request.contextPath}/foto/logo5.png" alt="logo" class="logo">
        <a href="${pageContext.request.contextPath}/catalogo.jsp">
            <img src="${pageContext.request.contextPath}/foto/home.png" alt="Home" class="home">
        </a>
    </div>
    <div class="destra">
    <form action="./Searchbar" method="post" id="Searchbar">
    	   <select class="console" name="console" id = "Searchbar Console">
       			 <option value="" disabled selected>console</option>
       			 <option value="Play Station 4">PS4</option>
        		 <option value="XBOX One">Xbox</option>
        		 <option value="Nintendo Switch">Switch</option>
        		 <option value="PC">PC</option>
    	   </select>
    	<input type="text" class="search-bar" placeholder="Cerca il tuo videogioco" name="search" id="Searchbar Titolo">
    	<input type="submit" value = "Cerca">
    	</form>
        <img src="${pageContext.request.contextPath}/foto/ricerca.png" alt="cerca" class="ricerca">	
    </div>
     <div class="account">
     		<a href="${pageContext.request.contextPath}/carrello.jsp">
            	<img src="${pageContext.request.contextPath}/foto/carrello.png" alt="carello" class="carrello">
    		<a href="${pageContext.request.contextPath}/utenteLoggato/account.jsp">
            	<img src="${pageContext.request.contextPath}/foto/omino.png" alt="omino" class="omino" >
        		<div class="name">
        			<span><%=nomeHeader%></span>
        		</div>
        	</a>
        
    </div>
    </header>
    <script src="${pageContext.request.contextPath}/js/Searchbar.js" type="text/javascript"></script>
</body>
</html>
