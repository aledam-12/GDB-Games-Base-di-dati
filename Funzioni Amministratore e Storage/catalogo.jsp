<%@include file="header.html" %>
<%
	ArrayList <BeanVideogioco> products = ArrayList <BeanVideogioco> request.getAttribute("copieVideogiochi");
	if(products == null) {
		response.sendRedirect("./product");	
		return;
	}
	(BeanVideogioco) product = (BeanVideogioco) request.getAttribute("copieVideogiochi");
%>
<!DOCTYPE html>
<html>
<body> 
<h1> Visualizza i prodotti </h1>
<table border="1px"> 
<tr>
    <th>Code <a href="product?sort=code">Sort</a></th>
    <th>Titolo <a href="product?sort=name">Sort</a></th>
    <th>Console <a href="product?sort=description">Sort</a></th>
    <th>Azione</th>
</tr>
<% if (products != null && products.size() != 0) {
Iterator<?> it = products.iterator();
while (it.hasNext()) {
BeanVideogioco bean = (BeanVideogioco) it.next();
%>
<td><%=bean.getCode()%></td>
<td><%=bean.getName()%></td>
<td><%=bean.getDescription()%></td>
<td><a href="product?action=delete&id=<%=bean.getCode()%>">Cancella</a><br>
<a href="product?action=read&id=<%=bean.getCode()%>">Dettagli</a></td>

</body>
</html>
<%@include file="footer.html" %>
