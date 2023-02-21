<%@page import="model.HandleQuestion"%>
<%@page import="java.util.List"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body style="background-color:#669bbb;" onload="Redirect()">
	
       <%
       if(request.getAttribute("myattempt")!=null){
       int attempt =(Integer)request.getAttribute("myattempt");
       int correct=(Integer)request.getAttribute("mycorrect");
       	%>
	
	<div id="statusmain">
		<div class="statusbox"><h2>Thanks For Examination !</h2></div>
		<div class="statusbox">Total Attempt Question <span style="background-color:orange"><%=attempt%></span></div>
		<div class="statusbox">Correct Answer <span style="background-color:green"><%=correct%></span></div>
		<div class="statusbox">Wrong Answer <span style="background-color:red"><%=attempt-correct%></span></div>
		<div class="statusbox">Result
		<%if(correct>4) {%>
		<span style="background-color:lightgreen">Pass</span>
		<%}else{%>
		<span style="background-color:red">Fail</span>
		<%} %>
		</div>
		<div class="statusbox" style="color:white; font-size:14px; width:100%;">You will automatic redirect on home page in <b id="redirecttime"> </b> seconds</div>
	</div>
	<%}else{%>
	<div class="warnig"><h2>Illigle Access</h2></div>
	<b id="redirecttime" style="color:green;visibility: hidden;" > </b>
	<%}%>
</body>
<script type="text/javascript" src="js/myjs.js"></script>
</html>