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
@WebServlet("/delete")
public class DeleteRow extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Qid =req.getParameter("qid");
		int qid =Integer.parseInt(Qid); 
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		HandleQuestion question=em.find(HandleQuestion.class, qid);
		em.getTransaction().begin();
		em.remove(question);
		em.getTransaction().commit();
		resp.sendRedirect("cpanel.jsp");
	}

}
