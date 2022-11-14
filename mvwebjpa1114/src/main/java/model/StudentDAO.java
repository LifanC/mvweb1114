package model;
import model.Student;
import javax.persistence.*;
import java.util.*;
public class StudentDAO {
  public static List<Student> getAllStudents(){
	  List<Student> data=null;
	  EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvwebjpa1114");
	  EntityManager manager=factory.createEntityManager();
	  manager.getTransaction().begin();
	  data=manager.createNamedQuery("Student.findAll").getResultList();
	  manager.getTransaction().commit();
	  manager.close();
	  factory.close();
	  return data;
  }
}
