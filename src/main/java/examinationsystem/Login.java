package examinationsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.DBHelper;
/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println("Role :" + role);
		DBHelper dbHelper = DBHelper.getInstance();
		if(dbHelper.login(uname, password, role))
		{
			System.out.println(uname + " " + password);
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			List<Subject> subjects = new ArrayList();
			subjects.add(new Subject("Physics"));
			subjects.add(new Subject("Chemistry"));
			subjects.add(new Subject("Biology"));
			session.setAttribute("subjects", subjects);
			System.out.println("Role :" + role);
			switch(role)
			{
			case "students":
			{
				studentLogin(uname, response, session);
				break;	
			}
			case "teachers":
			{
				teacherLogin(uname, response, session);
				break;
			}
			case "admins":
			{
				adminLogin(uname, password, response, session);
				break;
			}
			}
//			
		}
		else
		{
			System.out.println("Error");
			response.sendRedirect("Login2.jsp");
		}
	}


	private void adminLogin(String uname, String password, HttpServletResponse response, HttpSession session) throws IOException {
		Administrator admin = new Administrator(uname, password);
		session.setAttribute("role", "Administrator");
		session.setAttribute("account", admin);
		response.sendRedirect("AdminHome.jsp");
		admin.admin_id = uname;
	}


	private void teacherLogin(String uname, HttpServletResponse response, HttpSession session) throws IOException {
		Teacher teacher = new Teacher();
		session.setAttribute("role", "Teacher");
		response.sendRedirect("TeacherHome.jsp");
		teacher.teacher_id = uname;
	}


	private void studentLogin(String uname, HttpServletResponse response, HttpSession session) throws IOException {
		Student student = new Student();
		System.out.println("Student Login");
		session.setAttribute("role", "Student");;
		student.username = uname;
		response.sendRedirect("Home.jsp");
	}

}

