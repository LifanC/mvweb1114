import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.*;
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
}