package examinationsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBHelper;

@WebServlet("/studentresults")
public class StudentResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN studetn results get");
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN studetn results post");
		DBHelper dbHelper = DBHelper.getInstance();
		HttpSession session = request.getSession();
		List<StudentMark> studentMarks = new ArrayList();
		for(Subject subj: (List<Subject>)session.getAttribute("subjects"))
		{
			int m = dbHelper.getStudentResults((String)session.getAttribute("username"), subj.subjectName.toLowerCase() + "_marks");
			StudentMark sm = new StudentMark(subj.subjectName, m);
			studentMarks.add(sm);
		}
		request.setAttribute("marks", studentMarks);
		
		       // Creating a RequestDispatcher object to dispatch
		       // the request the request to another resource
		         RequestDispatcher rd = 
		             request.getRequestDispatcher("StudentResults.jsp");
		          rd.forward(request, response);
	          
	    
	}

}

