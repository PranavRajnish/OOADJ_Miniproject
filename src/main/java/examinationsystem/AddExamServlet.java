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

@WebServlet("/addexam")
public class AddExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	       // Creating a RequestDispatcher object to dispatch
	       // the request the request to another resource
		
		String subject = request.getParameter("subjectname");    
	    String duration = request.getParameter("duration");

	    List<Subject> subjects = (List<Subject>) request.getSession().getAttribute("subjects");
	    request.getSession().removeAttribute("subjects");
	    subjects.add(new Subject(subject));
	    System.out.println("ADD");
    	for(int i = 0; i < subjects.size(); i++)
    		System.out.println(subjects.get(i).getSubjectName());
    	
	    request.getSession().setAttribute("subjects", subjects);
	    DBHelper dbHelper = DBHelper.getInstance();
	    Boolean success = dbHelper.addExam(subject.toLowerCase());
	    
	    request.setAttribute("success", success);
	    RequestDispatcher rd = 
	             request.getRequestDispatcher("AddExam.jsp");
	  
	          rd.forward(request, response);
	}

}
