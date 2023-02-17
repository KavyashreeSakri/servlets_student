package servlets_student.Controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_student.dao.StudentDao;
import servlets_student.dto.Student;

public class StudentController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String fathername = req.getParameter("fathername");
		String mothername = req.getParameter("mothername");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		//hardcoding for school name
		ServletContext context= getServletContext();
		String schoolname=context.getInitParameter("schoolname");
		
		
		//hardcoding the school fees
		ServletConfig config= getServletConfig();		
		long schoolfees = Long.parseLong(config.getInitParameter("schoolfees"));

		Student student = new Student();
		student.setName(name);
		student.setFathername(fathername);
		student.setMothername(mothername);
		student.setEmail(email);
		student.setPassword(password);
		student.setSchoolname(schoolname);
		student.setSchoolfees(schoolfees);

		StudentDao dao = new StudentDao();
		dao.signupStudent(student);

	
//		dao.updateStudent(id, student);

	}
}
