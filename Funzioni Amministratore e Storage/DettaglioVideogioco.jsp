<%@include file="header.html" %>
<!DOCTYPE html>
<html>
<h2>Details</h2>
	<%	copiaBean product = response.getParameter("prodotto"); 
		if (product != null) {
	%>
	<table border="1">
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<tr>
			<td><%=product.getPegi()%></td>
			<td><%=product.getTitolo()%></td>
			<td><%=product.getDescrizione()%></td>
			<td><%=product.getPrezzo()%></td>
		</tr>
	</table>
<%@include file="footer.html" %>
</html>
