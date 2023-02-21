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
@WebServlet("/edit")
public class EditQuestion extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String question=req.getParameter("question");
		String optionA=req.getParameter("optionA");
		String optionB=req.getParameter("optionB");
		String optionC=req.getParameter("optionC");
		String optionD=req.getParameter("optionD");
		String ans=req.getParameter("ans");
		
		
		if(question!=null&&optionA!=null&&optionB!=null&&optionC!=null&&optionD!=null&&ans!=null) {
			EntityManagerFactory emf =Persistence.createEntityManagerFactory("unit");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			HandleQuestion questiondata =em.find(HandleQuestion.class, id);
			questiondata.setQuestion(question);
			questiondata.setOptionA(optionA);
			questiondata.setOptionB(optionB);
			questiondata.setOptionC(optionC);
			questiondata.setOptionD(optionD);
			questiondata.setAns(ans);	
			em.getTransaction().commit();
		}
		
		resp.sendRedirect("cpanel.jsp");
		
	}

}
