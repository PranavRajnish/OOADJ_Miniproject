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
@WebServlet("/evaluate")
public class EvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	          
	    int numberOfQuestions = Integer.parseInt(request.getParameter("numberOfQuestions"));
		System.out.println("In Evaluate Servlet");
		System.out.println("Number : " + numberOfQuestions);
		String subject = request.getParameter("subject");
		DBHelper dbHelper = DBHelper.getInstance();
		List<Question> questions = dbHelper.getQuestionSet(subject.toLowerCase());
		int marks = 0;
		int qid;
		String result;
		for(int i = 0; i < numberOfQuestions; i++)
		{
			qid = questions.get(i).getQuestionNumber();
			result = request.getParameter(Integer.toString(qid));
			if(questions.get(i).getAns().equalsIgnoreCase(result))
				marks++;
		}
		
		System.out.println("Marks : " + marks);
		
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");
		
		dbHelper.addResult(uname, Integer.toString(marks), subject.toLowerCase() + "_marks");
		
		 RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		 rd.forward(request, response);
	}

}

