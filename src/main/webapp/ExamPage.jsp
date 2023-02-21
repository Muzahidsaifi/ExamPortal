
<%@page import="model.GetTimeDuration"%>
<%@page import="model.HandleQuestion"%>
<%@page import="java.util.List"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head >
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Exam Page</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body onload="StartTimer(),AddClickEvent()">
<%
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		Query q= em.createQuery("from HandleQuestion");
		List<HandleQuestion> data =q.getResultList();
		GetTimeDuration gtd=em.find(GetTimeDuration.class, 1);
		%>
	<%if(session.getAttribute("name")!=null){%>
	<div id="mainpage">
		<form action="exam" method="post">
		<div class="action">
			<div><label>Name: </label><span><%=session.getAttribute("name")%></span></div>
			<div><label>Duration: </label><span></span></div>
		</div>
		
		<div id="questionPage">
		
		
			<div>
				<ol>
				<%for(HandleQuestion d:data){%>
					<li id="<%=d.getQId()%>">
						<p><%=d.getQuestion()%></p>
						<ul>
							<li><input type="radio" name="<%=d.getQId()%>" value="A"> <%=d.getOptionA()%></li>
							<li><input type="radio" name="<%=d.getQId()%>" value="B"> <%=d.getOptionB()%></li>
							<li><input type="radio" name="<%=d.getQId()%>" value="C"> <%=d.getOptionC()%></li>
							<li><input type="radio" name="<%=d.getQId()%>" value="D"> <%=d.getOptionD()%></li>
						</ul>
					</li>
					<%} %>
				</ol>

			</div>
			
			<div>
				<%
				int n=1;
				for(HandleQuestion d:data) {
				%>
				<a href="#<%=d.getQId()%>"><div><%=n%><input type="hidden" value="<%=d.getQId()%>"></div></a>
				<%
				n++;
				}%>
			</div>
		</div>
		<div class="action" style="bottom:0px;">
		<input type="submit" value="SUBMIT" onclick="return SaveData()">
		</div>
		</form>
	</div>
	<%}else{ %>
	<div class="warnig"><h2>Illigle Access</h2></div>
	<%}%>
	<%if(gtd!=null){ %>
	<input  class="gettimevalue" type="hidden" value="<%=gtd.getH()%>">
	<input class="gettimevalue"  type="hidden" value="<%=gtd.getM()%>">
	<input class="gettimevalue"  type="hidden" value="<%=gtd.getS()%>">
	<%} %>
</body>
<script type="text/javascript" src="js/myjs.js"></script>
</html>