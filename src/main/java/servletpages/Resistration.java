package servletpages;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.HandleQuestion;
import model.UserData;
@WebServlet("/registration")
public class Resistration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mob=req.getParameter("mob");
		String tech=req.getParameter("tech");
		String duid=req.getParameter("duid");
		String edu=req.getParameter("edu");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		Query q= em.createQuery("from UserData");
		List<UserData> udata =q.getResultList();
		int status=0;
		for(UserData u0:udata) {
			if(duid.contentEquals(u0.getDuid())||email.contentEquals(u0.getEmail())) {
				status++;
				HttpSession session=req.getSession(true);
				session.setAttribute("status", "You are already Examined");
				resp.sendRedirect("index.jsp");
				break;
				
			}
		}
		if(status==0) {
		UserData ud= new UserData(name, email, mob, tech, duid, edu);
		em.getTransaction().begin();
		em.persist(ud);
		em.getTransaction().commit();
		HttpSession session=req.getSession(true);
		session.setAttribute("name", name);
		session.setAttribute("id", duid);
		resp.sendRedirect("ExamPage.jsp");
		}
		
	}
}
