

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.*;
import java.util.*;
import model.*;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvwebjpa1114");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Query query = em.createQuery("Select s from Student s ");
        Query query = em.createNamedQuery("Student.findAll");
        @SuppressWarnings("unchecked")
        List<Student> list = (List<Student>) query.getResultList();
        System.out.print("sid");
        System.out.print("\t sname");
        System.out.println("\t age");
        for (Student s : list) {
            System.out.print(s.getSid());
            System.out.print("\t" + s.getSname());
            System.out.print("\t" + s.getAge());
            System.out.println();
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        response.getWriter().append("See Tomcat Console Student Data");
        request.setAttribute("students",list);
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
