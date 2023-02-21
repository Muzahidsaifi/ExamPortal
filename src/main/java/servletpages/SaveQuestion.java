package servletpages;

import java.io.IOException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HandleQuestion;
@WebServlet("/save")
public class SaveQuestion extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String question=req.getParameter("question");
		String optionA=req.getParameter("optionA");
		String optionB=req.getParameter("optionB");
		String optionC=req.getParameter("optionC");
		String optionD=req.getParameter("optionD");
		String ans=req.getParameter("ans");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		HandleQuestion hq= new HandleQuestion(question, optionA, optionB, optionC, optionD, ans);
		em.getTransaction().begin();
		em.persist(hq);
		em.getTransaction().commit();
		resp.sendRedirect("cpanel.jsp");
		
		
	}

}
