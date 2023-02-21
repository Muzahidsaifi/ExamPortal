package servletpages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import model.MyModel;
@WebServlet("/exam")
public class Result extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=req.getSession(false);
		String duid=session.getAttribute("id").toString();
		session.invalidate();
		
		Map d=req.getParameterMap();
		Iterator entries=d.entrySet().iterator();
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		Query q= em.createQuery("from HandleQuestion");
		List<HandleQuestion> data =q.getResultList();
		
		int attempt=0;
       	int correct=0;
		while(entries.hasNext()) {
			attempt++;
		 	Map.Entry<String, String[]>  examdata=(Entry<String, String[]>)entries.next();
		 	String myquestion=examdata.getKey();
		 	int que=Integer.parseInt(myquestion);
		 	String myans=null;
		 	String []atmpans=examdata.getValue();
		 	for(HandleQuestion d0:data){
				if(que==d0.getQId()){
					HandleQuestion atmp=em.find(HandleQuestion.class, que);
					String ans=atmp.getAns();
						for(String myans0:atmpans){
							myans=myans0;
							if(ans.contentEquals(myans0)){
								correct++;
							}
						}
					}
				}
		 	
		 	MyModel mm= new MyModel(duid, myquestion, myans);
			em.getTransaction().begin();
			em.persist(mm);
			em.getTransaction().commit();
		 	
		 	}
		
		req.setAttribute("myattempt", attempt);
		req.setAttribute("mycorrect", correct);
		RequestDispatcher rd=req.getRequestDispatcher("StatusPage.jsp");
		rd.forward(req, resp);
		
		
		
	}

}
