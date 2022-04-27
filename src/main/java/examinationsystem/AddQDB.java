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

@WebServlet("/addquestionsdb")
public class AddQDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	       // Creating a RequestDispatcher object to dispatch
	       // the request the request to another resource
		
		String subject = request.getParameter("subject").toLowerCase();    
	    String questionString = request.getParameter("questionString");
	    String questionNumber = request.getParameter("questionNumber");
	    String op1 = request.getParameter("op1");
	    String op2 = request.getParameter("op2");
	    String op3 = request.getParameter("op3");
	    String op4 = request.getParameter("op4");
	    String ans = request.getParameter("ans");
	    
	    DBHelper dbHelper = DBHelper.getInstance();
	    Boolean success = dbHelper.addQuestion(questionNumber, questionString, op1, op2, op3, op4, ans, subject);
	    
	    request.setAttribute("success", success);
	    RequestDispatcher rd = 
	             request.getRequestDispatcher("AddQuestions.jsp");
	  
	          rd.forward(request, response);
	}

}
