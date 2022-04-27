package examinationsystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBHelper;

@WebServlet("/checkmarks")
public class CheckMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String subject = request.getParameter("selectedexam");
		request.setAttribute("subject", subject);
		DBHelper dbHelper = DBHelper.getInstance();
		List<Mark> marks = dbHelper.getResults(subject.toLowerCase() + "_marks");
		request.setAttribute("marks", marks);
		
		         RequestDispatcher rd = 
		             request.getRequestDispatcher("ViewMarks.jsp");
		 
		          rd.forward(request, response);
	          
	    
	}

}

