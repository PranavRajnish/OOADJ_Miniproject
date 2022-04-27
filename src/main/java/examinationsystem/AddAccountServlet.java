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

@WebServlet("/addaccount")
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	       // Creating a RequestDispatcher object to dispatch
	       // the request the request to another resource
		   
	    String role = request.getParameter("role");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    Administrator admin = (Administrator) request.getSession().getAttribute("account");
	    Boolean success = admin.createAccount(role, username, password);
	    
	    request.setAttribute("success", success);
	    RequestDispatcher rd = 
	             request.getRequestDispatcher("AddAccount.jsp");
	  
	          rd.forward(request, response);
	}

}
