

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import java.util.*;
/**
 * Servlet implementation class QueryAgeServlet
 */
@WebServlet("/QueryAgeServlet")
public class QueryAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String age=request.getParameter("age");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvwebjpa1114");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Student> query=manager.createQuery("select s from Student s where s.age >= :a",Student.class);
		query.setParameter("a", Integer.parseInt(age));
	    List<Student>  data=query.getResultList();
	    manager.getTransaction().commit();
        manager.close();
        factory.close();
	    request.setAttribute("students", data);
	    request.getRequestDispatcher("student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
