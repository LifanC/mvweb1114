

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import javax.persistence.Query;

/**
 * Servlet implementation class deleteStudentServlet
 */
@WebServlet("/deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String sid=request.getParameter("sid");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvwebjpa1114");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Student sx=manager.find(Student.class, Integer.parseInt(sid));
		 if(sx !=null) {        	
	         manager.remove(sx);   
			 manager.getTransaction().commit();
	        }else {
	          System.out.println("student not found");
	          manager.getTransaction().rollback();
		    }        
		    manager.close();
	        factory.close();
	        response.sendRedirect("StudentServlet");
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvwebjpa1114");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String sid=request.getParameter("sid");
        Query query = em.createQuery("delete from Student where sid="+sid);
        int r=query.executeUpdate();
        if(r>0)
        	System.out.println("delete successfully");
        else
        	System.out.println("delete failed");
        em.getTransaction().commit();
        em.close();
        emf.close();
        response.sendRedirect("StudentServlet");
		*/
        
	}

}
