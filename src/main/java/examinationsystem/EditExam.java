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

@WebServlet("/editexam")
public class EditExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String isAddQButton = request.getParameter("addQ_button");
		String subject = request.getParameter("selectedexam");
		System.out.println("IN Edit Exam:");
		System.out.println("Subject :" + subject);
		request.setAttribute("subject", subject);
		if(isAddQButton != null)
		{
		

			
		       // Creating a RequestDispatcher object to dispatch
		       // the request the request to another resource
		         RequestDispatcher rd = 
		             request.getRequestDispatcher("AddQuestions.jsp");
		  
		          rd.forward(request, response);
		}
		else
		{
			DBHelper dbHelper = DBHelper.getInstance();
			List<Question> questions = dbHelper.getQuestionSet(subject.toLowerCase());
			request.setAttribute("questions", questions);
			 RequestDispatcher rd = 
		             request.getRequestDispatcher("ViewExam.jsp");
		  
		          rd.forward(request, response);
			
		}
	          
	    
	}

}

