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
/**
 * Servlet implementation class Login
 */
@WebServlet("/exam")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subject = request.getParameter("selectedexam");
		System.out.println("In Exam Servlet");
		System.out.println("Subject : " + subject.toLowerCase());
		
		DBHelper dbHelper = DBHelper.getInstance();
		List<Mark> marks = dbHelper.getResults(subject.toLowerCase() + "_marks");
		String username = (String) request.getSession().getAttribute("username");
		Boolean entered = false;
		for(Mark rec : marks)
		{
			if(rec.uname.equals(username))
			{
				entered = true;
			}
		}
		
		if(!entered)
		{
			List<Question> questions = dbHelper.getQuestionSet(subject.toLowerCase());
			
			request.setAttribute("subject", subject);
			request.setAttribute("data", questions);
		         RequestDispatcher rd = 
		             request.getRequestDispatcher("Exam.jsp");
		          rd.forward(request, response);
		}
		else
		{
			System.out.println("Already taken exam!");
			RequestDispatcher rd = 
		             request.getRequestDispatcher("ExamScreen.jsp");
		          rd.forward(request, response);
		}
	}

}



