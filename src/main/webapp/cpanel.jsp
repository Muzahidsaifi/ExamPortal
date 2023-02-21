<%@page import="model.GetTimeDuration"%>
<%@page import="model.MyModel"%>
<%@page import="java.util.List"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@page import="model.HandleQuestion"%>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>cpanel</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
</head>
<body style="background-color:rgba(191, 233, 232, .5);">
		<%
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		Query q= em.createQuery("from HandleQuestion");
		List<HandleQuestion> data =q.getResultList();
		GetTimeDuration gtd=em.find(GetTimeDuration.class, 1);
		%>

	<%if(session.getAttribute("admin")!=null) {%>
	<main id="cpanelmain">
		<div id="viewusers">
		<div style="position: sticky;top:-10px;background-color:#90ee90;height:35px;line-height:35px"><label>Search User:</label><input type="search"></div>
			<table align="center" border="1" width="100%">
				<tr height="25px" bgcolor="lime" style="position: sticky;top:24px;">
					<th>User Id</th>
					<th>Question</th>
					<th>Given Ans</th>
				</tr>
				<%
				Query q1= em.createQuery("from MyModel");
				List<MyModel> udata =q1.getResultList();
				for(MyModel u0:udata){
				%>
				<tr align="center">
					<td><%=u0.getMyname()%></td>
					<td><%=u0.getMyquestion()%></td>
					<td><%=u0.getMyans()%></td>
				</tr>
				<%}%>
			</table>
		</div>
		<header>
		<div><span><%=session.getAttribute("admin")%></span></div>
		
		<%
		if(session.getAttribute("mysession")==null){
		%>
		<div><a href="add">+ Add</a></div>
		<% }else{%>
		<div ><a href="close">- Close</a></div>
		<%}%>
		<div><a href="adminlogout">Logout</a></div>
		<div style="cursor: pointer;" onclick="ViewUsers(this)">View Users</div>
		<div>
		Set Exam Duration:
		<form action="settime" method="post">
			<%if(gtd!=null){ %>
			<input  type="number" name="h" placeholder="H" value="<%=gtd.getH()%>" disabled>:
			<input type="number" name="m" placeholder="M" value="<%=gtd.getM()%>" disabled>:
			<input type="number" name="s" placeholder="S" value="<%=gtd.getS()%>" disabled>
			<input type="button" value="Edit" onclick="EditTime(this)">
			<%}else{ %>
			<input  type="number" name="h" placeholder="H" >:
			<input type="number" name="m" placeholder="M" >:
			<input type="number" name="s" placeholder="S">
			<input type="submit" value="Save">
			<%} %>		
		</form>
		</div>
		</header>
		<%
		if(session.getAttribute("mysession")!=null){
		%>
		<div id="formsection">
			<form action="save" method="post">
				<label>Question:</label>
				<textarea name="question"></textarea>
				<label>Option A:</label>
				<textarea name="optionA"></textarea>
				<label>Option B:</label>
				<textarea name="optionB"></textarea>
				<label>Option C:</label>
				<textarea name="optionC"></textarea>
				<label>Option D:</label>
				<textarea name="optionD"></textarea>
				<label>Answer Option:</label>
				<input type="text" name="ans">
				<input type="submit">
			</form>
		</div>
		<%} %>
		
		<table border="1">
		
			<tr bgcolor="skyblue" style="position: sticky; top: 39px;">
				<th width="20" height="30">Sr.No.</th>
				<th width="350">Question</th>
				<th>A</th>
				<th>B</th>
				<th>C</th>
				<th>D</th>
				<th width="35">Ans</th>
				<th width="100">Action</th>
			</tr>
			
			
			<%for(HandleQuestion d:data) {%>
			
			<tr align="center">
				<form action="edit" method="post">
					<input type="hidden" value="<%=d.getQId()%>" name="id">
					<td><%=d.getQId()%></td>
					<td ><textarea disabled name="question"><%=d.getQuestion()%></textarea></td>
					<td><textarea disabled name="optionA"><%=d.getOptionA()%></textarea></td>
					<td><textarea disabled name="optionB"><%=d.getOptionB()%></textarea></td>
					<td><textarea disabled name="optionC"><%=d.getOptionC()%></textarea></td>
					<td><textarea disabled name="optionD"><%=d.getOptionD()%></textarea></td>
					<td><textarea disabled name="ans"><%=d.getAns()%></textarea></td>
					<td>
						<button><a href="delete?qid=<%=d.getQId()%>">Delete</a></button>
						<input type="button" value="Edit" onclick="Edit(this)">
					</td>
				</form>
			</tr>
			<%}%>
		</table>
	</main>
	<%}else{%>
		<div id="cpanellogin">
			<div>
			<h3 style="text-align: center; margin:5px 0">Admin Login</h3>
			<form action="admin" method="post">
				<label>Admin Email Id</label>
				<input type="email" name="adminid" required>
				<label>Password</label>
				<input type="password" name="pass" required>
				<div style="width: 100px;">
				<input type="submit" style="width:100px; margin: 5px; padding: 0;cursor: pointer;" value="Login">
				</div>
	
			</form>
			<%if(request.getAttribute("adminloginstatus")!=null){ %>
			<span style="color:red;font-size:13px"><%=request.getAttribute("adminloginstatus")%></span>
			<%}%>
			</div>
			
		</div>
	<%}%>
	
</body>
<script type="text/javascript" src="js/myjs.js"></script>
</html>