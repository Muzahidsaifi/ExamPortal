<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Registration</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body style="background-color:#344a71;">
<div id="regOuter">
	<h2>Registration</h2>
	<p>it's free and only takes a minute.</p>
	<%if(session.getAttribute("status")!=null){%>
	<span style="color:red"><%=session.getAttribute("status")%></span>
	<%}%>
	<form action="registration" method="post">
		<label>Name:<span style="color:red;">*</span></label>
		<input type="text" name="name" required>
		<label>Email Id:<span style="color:red;">*</span></label>
		<input type="email" name="email" required>
		<label>Mobile Number:<span style="color:red;">*</span></label>
		<input type="tel" name="mob" required>
		<label>Technology:<span style="color:red;">*</span></label>
		<input type="text" name="tech" required>
		<label>Ducat ID:<span style="color:red;">*</span></label>
		<input type="number" name="duid" required>
		<label>Qualification:<span style="color:red;">*</span></label>
		<input type="text" name="edu" required><br>
		<input type="submit">
		
	</form>
</div>
</body>
<script type="text/javascript" src="js/myjs.js"></script>
</html>