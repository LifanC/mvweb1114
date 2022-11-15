import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Student;
import model.StudentDAO;
import java.util.*;

@Path("/")
public class StudentServices {
    @GET   
	@Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(){
    	List<Student> data=null;
    	data=StudentDAO.getAllStudents();    	
    	return data;
    }
    
    @POST
    @Path("/addStudent")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String addStudent(Student s) {
    	try {
    	  StudentDAO.addStudent(s);
    	}catch(Exception ex) {
    		System.out.println("Error addStudent "+ex.getMessage());
    		return "Failed";
    	}
    	return "OK";
    }
}
