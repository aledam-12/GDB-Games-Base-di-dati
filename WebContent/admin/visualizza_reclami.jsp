<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.ArrayList, model.beans.ReclamoBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h3> Visualizza reclami </h3>
	<% ArrayList<ReclamoBean> reclami = (ArrayList <ReclamoBean>)request.getAttribute("reclami");	
	if (reclami == null) {
		response.sendRedirect("./adminCheck");
		return;
	} 
	%>
	<%if (reclami.size()==0 && reclami != null) {%>
		<p>Non &egrave; presente nessun reclamo!</p>
	<%return;} %>
	<div class="container reclamo">
	<% for (ReclamoBean reclamo : reclami) {%>
	 <div class="reclamo">	
	 <h4><%=reclamo.getTitolo() %></h4> <p>Utente: <%=reclamo.getEmailCliente() %> </p> <br>
		<p> <%=reclamo.getContenuto() %></p>
	</div>
	<% } %>
	</div>
</body>
</html>