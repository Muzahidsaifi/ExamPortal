package servletpages;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetTimeDuration;
@WebServlet("/settime")
public class SetTimeDuration extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String h= req.getParameter("h");
		String m= req.getParameter("m");
		String s= req.getParameter("s");
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		Query q= em.createQuery("from GetTimeDuration");
		List<GetTimeDuration> udata =q.getResultList();
		
		if(udata.isEmpty()&&h.isBlank()!=true&&m.isBlank()!=true&&s.isBlank()!=true) {
			GetTimeDuration gtd= new GetTimeDuration();
			gtd.setH(h);
			gtd.setM(m);
			gtd.setS(s);
			em.getTransaction().begin();
			em.persist(gtd);
			em.getTransaction().commit();
			
		}else if(h.isBlank()!=true&&m.isBlank()!=true&&s.isBlank()!=true) {
			em.getTransaction().begin();
			GetTimeDuration gtd =em.find(GetTimeDuration.class, 1);
			gtd.setH(h);
			gtd.setM(m);
			gtd.setS(s);
			em.getTransaction().commit();
		}
		
		resp.sendRedirect("cpanel.jsp");
		
		
	}

}
