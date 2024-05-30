<%@include file="header.jsp" %>
<%@  page import = "model.beans.copiaBean,model.beans.videogiocoBean" %>
<!DOCTYPE html>
<html>
<head>
<title>GDB Games</title>
</head>
<body>
<h2>Dettagli</h2>
	<%copiaBean copia = (copiaBean) request.getAttribute("copia"); %>
	<%videogiocoBean videogioco = (videogiocoBean) request.getAttribute("videogioco"); %>
	<% if (videogioco != null && copia != null) {	%>
			<h2><%=videogioco.getTitolo()%></h2>
			<img src="./getFoto?titolo=<%=copia.getTitoloVideogioco()%>" alt="immagine del videogioco non trovata" width="50%" height="50%">
			<p>Prezzo: <%=copia.getPrezzo()%> &euro; </p>
			<h4>Iva: <%=copia.getPercIva() %>% </h4>
			<h4>Descrizione: </h4>
			<p><%=videogioco.getDescrizione() %></p>
			<p>Console: <b><%=copia.getNomeConsole() %></b>
			<h4>PEGI: <%=videogioco.getPegi() %></h4>
<% } %>
</body>
<%@include file="footer.jsp"%>
</html>
