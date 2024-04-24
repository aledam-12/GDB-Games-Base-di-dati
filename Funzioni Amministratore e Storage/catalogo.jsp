<%@include file="header.html" %>
<%@ page import="java.beans.*" %>
<%
	ArrayList <copiaBean> products = ArrayList <copiaBean> request.getAttribute("copieVideogiochi");
	if(products == null) {
		response.sendRedirect("./product");	
		return;
	}
%>
<!DOCTYPE html>
<html>
<body> 
<h1> Visualizza i prodotti </h1>
<% if (products != null && products.size() != 0) {
Iterator<?> it = products.iterator();
while (it.hasNext()) {
copiaBean bean = (copiaBean) it.next();
}
%>
<%=bean.getPrezzo()%>
<%=bean.getTitolo()%>
<a href="product?action=read&id=<%= bean.getTitoloVideogioco() %>">Dettagli </a>
</body>
</html>
<%@include file="footer.html" %>
