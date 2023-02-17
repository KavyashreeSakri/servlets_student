package servlets_student.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_student.dao.StudentDao;
import servlets_student.dto.Student;

public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
//		String schoolname = req.getParameter("schoolname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ServletContext context= getServletContext();
		String schoolname= context.getInitParameter("schoolname");

		StudentDao studentDao = new StudentDao();
		Student student = studentDao.loginStudent(id);

		if (schoolname.equals(student.getSchoolname()) && email.equals(student.getEmail())
				&& password.equals(student.getPassword())) {

			resp.sendRedirect("https://stackoverflow.com/");
		} else {
				RequestDispatcher dispatcher= req.getRequestDispatcher("Login.html");
				dispatcher.forward(req, resp);
			
		}

	}
}
