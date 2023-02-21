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
import model.AdminModel;
import model.UserData;
@WebServlet("/admin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String adminid=req.getParameter("adminid");
		String pass=req.getParameter("pass");
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		Query q= em.createQuery("from AdminModel");
		List<AdminModel> data =q.getResultList();
		int status=0;
		for(AdminModel data0:data) {
			
			if(adminid.contentEquals(data0.getAdminid())&&pass.contentEquals(data0.getPass())) {
				status++;
				HttpSession session=req.getSession(true);
				session.setAttribute("admin", adminid);
				resp.sendRedirect("cpanel.jsp");
				break;
			}
			
		}
		if(status==0) {
			req.setAttribute("adminloginstatus", "ID or Password is Incorrect");
			RequestDispatcher rd =req.getRequestDispatcher("cpanel.jsp");
			rd.forward(req, resp);
		}
		
		
		
	}

}
