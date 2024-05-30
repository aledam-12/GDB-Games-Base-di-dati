<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stile_login.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
<script>
function changeForm(str) {
	  let lForm = document.getElementById("loginForm");
	  let sForm = document.getElementById("signUpForm");

	  if (str === "Sign Up") {
	    lForm.style.display = "none";
	    sForm.style.display = "block";
	  } else {
	    sForm.style.display = "none";
	    lForm.style.display = "block";
	  }
	}


</script>

<%  //here negative login feedback 

    Boolean feedbackLog = (Boolean) session.getAttribute("feedbackLog");    
    Boolean logToReg = (Boolean) session.getAttribute("logToReg");    
    %>

    <%   //for mail  
	    if(feedbackLog != null && logToReg != null){
	    	if (feedbackLog && logToReg) {%>
        <script>
			changeForm("signUp");

            document.addEventListener('DOMContentLoaded', function() {
                var messageDiv = document.getElementById('message');    
                messageDiv.style.display = 'block';
    
                setTimeout(function() {
                    messageDiv.style.display = 'none';
                }, 5000);
            });
        </script>

        <div id="message">mail non registrata, registrati</div>
            <%  }}%>


    <% // for password
	         if(feedbackLog != null && logToReg != null){
	        	 if (feedbackLog && !logToReg){%>
        <script>

            document.addEventListener('DOMContentLoaded', function() {
                var messageDiv = document.getElementById('message');    
                messageDiv.style.display = 'block';
    
                setTimeout(function() {
                    messageDiv.style.display = 'none';
                }, 5000);
            });
        </script>

        <div id="message">password non conforme, riprova</div>
            <%}}%>




<%  //here negative Registration feedback 

    Boolean feedbackReg = (Boolean) session.getAttribute("feedbackReg");    
    %>

    <%   //for Correct registration

	    if(feedbackReg != null){
	    	if (feedbackReg)%>
        <script>
			changeForm("logIn");

            document.addEventListener('DOMContentLoaded', function() {
                var messageDiv = document.getElementById('message');    
                messageDiv.style.display = 'block';
    
                setTimeout(function() {
                    messageDiv.style.display = 'none';
                }, 5000);
            });
        </script>

        <div id="message">Registrazione correttamente effettuata!</div>
            <%  }%>



<%   //for mail already registered
			if (feedbackReg != null) {
			if(!feedbackReg){    %>
			<script>
				changeForm("logIn");
	
				document.addEventListener('DOMContentLoaded', function() {
					var messageDiv = document.getElementById('message');    
					messageDiv.style.display = 'block';
		
					setTimeout(function() {
						messageDiv.style.display = 'none';
					}, 5000);
				});
			</script>
	
			<div id="message">utente gia registrato, registrati</div>
				<% } }%>

 <% if (request.getRemoteUser() != null) {
 response.sendRedirect("LogOut.jsp");
 return;//fa in modo che se un utente � loggato non si possa riloggare
} %>
<div class="logSig">
	<div class="form-container">
	<div id="loginForm">
		<form action="./Login" method="post">
			  <fieldset name="group-user">
			  <legend><h2><b>Accesso</b></h2></legend>
				  <label for="username">Username:</label> <br>
				  <input type="text" name="username" id="username" required> <br>
				  <label for="password">Password:</label> <br> 
				  <input type="password" name="password" id="password" required> <br>
			  </fieldset>
			<input type="submit" class="button" value = "Accesso">
			<button onclick='changeForm("Sign Up")'> Non hai un account?  </button> 
		</form>
	</div>	
	<div class= "reg">
	 <%@include file = "Register.jsp" %>
	 </div>
	 </div>
</div>  
<script>
	document.getElementById("loginForm").style.display = "block";
	document.getElementById("signUpForm").style.display = "none";
</script> 
<div class= "f">  
	<%@ include file="footer.jsp" %>
</div>

<script src="${pageContext.request.contextPath}/formValidation.js"></script>

</body>
</html>