

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
/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvwebjpa1114");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String sid=request.getParameter("sid");
        String sname=request.getParameter("sname");
        String age=request.getParameter("age");
		Student sx=em.find(Student.class, Integer.parseInt(sid));
		if(sx !=null) {
			sx.setSname(sname);
			sx.setAge(Integer.parseInt(age));
			em.merge(sx);
			em.getTransaction().commit();
		}else {
	          System.out.println("student not found");
	          em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		response.sendRedirect("StudentServlet");
	}

}
