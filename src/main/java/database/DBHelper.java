package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import examinationsystem.Question;
import examinationsystem.Mark;
import examinationsystem.StudentMark;

public class DBHelper {

	private static final String url= "jdbc:mysql://localhost:3306/oes_database?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
	private static String username = "root";
	private static String password = "87KNTadb66";
	private static Connection con;
	
	private static DBHelper dbhelper = null;
	
	private DBHelper()
	{
		connectToDB();
	}
	
	public static DBHelper getInstance()
    {
        if (dbhelper == null)
        	dbhelper = new DBHelper();
 
        return dbhelper;
    }
	
	private void connectToDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Cant connect to database");
			e.printStackTrace();
		}
	}
	public boolean login(String uname, String pass, String table)
	{
		String query = "select * from " + table + " where uname = ? and pass = ?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			//st.setString(1, table);
			st.setString(1, uname);
			st.setString(2, pass);
			System.out.println("Query " + st);
			ResultSet rs = st.executeQuery();
			if(rs.next())
				return true;
			return false;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't login");
			e.printStackTrace();
			return false;
		}
		
	}
	public List<Question> getQuestionSet(String subject)
	{
		String query = "select * from " + subject;
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			//st.setString(1, table);
			System.out.println("Query " + st);
			ResultSet rs = st.executeQuery();
			List<Question> list=new ArrayList<Question>(); 
			while(rs.next())
			{
				Question q = new Question(rs.getInt("Qno"), rs.getString("Question"), rs.getString("op1"), rs.getString("op2"), rs.getString("op3"), rs.getString("op4"), rs.getString("ans"));
				list.add(q);
			}
				
			return list;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't get questions");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Mark> getResults(String subject)
	{
		String query = "select * from " + subject;
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			//st.setString(1, table);
			System.out.println("Query " + st);
			ResultSet rs = st.executeQuery();
			List<Mark> list=new ArrayList<Mark>(); 
			while(rs.next())
			{
				Mark m = new Mark(rs.getString("uname"), rs.getInt("marks"));
				list.add(m);
			}
				
			return list;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't get results");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean addQuestion(String questionNumber, String questionString, String op1, String op2, String op3, String op4, String ans, String table)
	{	
		String query = "INSERT INTO " + table 
				 + "(Qno, Question, op1, op2, op3, op4, ans) "
				 + "VALUES(" + questionNumber + ", ?, ? , ?, ?, ?, ? );";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1, questionString);
			st.setString(2, op1);
			st.setString(3, op2);
			st.setString(4, op3);
			st.setString(5, op4);
			st.setString(6, ans);
			System.out.println("Query " + st);
			st.executeUpdate();
			return true;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't add question");
			e.printStackTrace();
			return false;
		}
						
		
	}

	public boolean addResult(String uname, String marks, String table)
	{
		String query = "INSERT INTO " + table + " VALUES( ?," + marks + ");";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1, uname);
			System.out.println("Query " + st);
			st.executeUpdate();
			return true;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't add result");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean addAccount(String accountType, String uname, String pass)
	{
		String query = "INSERT INTO " + accountType.toLowerCase() + " VALUES( ?, ? );";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1, uname);
			st.setString(2, pass);
			System.out.println("Query " + st);
			st.executeUpdate();
			return true;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't add account");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean addExam(String subject)
	{
		String query1 = "CREATE TABLE " + subject + " (Qno int, Question VARCHAR(45), op1 VARCHAR(45), op2 VARCHAR(45), op3 VARCHAR(45), op4 VARCHAR(45), ans VARCHAR(45), PRIMARY KEY (Qno));";
		String query2 = "CREATE TABLE " + subject + "_marks (uname VARCHAR(45), marks int, PRIMARY KEY (uname));";
		PreparedStatement st1;
		PreparedStatement st2;
		try {
			st1 = con.prepareStatement(query1);
			st2 = con.prepareStatement(query2);
			System.out.println("Query " + st1);
			System.out.println("Query " + st2);
			st1.executeUpdate();
			st2.executeUpdate();
			return true;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't add exam");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public int getStudentResults(String username, String table)
	{
		String query = "SELECT * FROM " + table + " WHERE uname = ?;";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1, username);
			System.out.println("Query " + st);
			ResultSet rs = st.executeQuery();;
			if(rs.next())
			{
				return rs.getInt("marks");
			}
			return -1;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't get student results");
			e.printStackTrace();
			return -1;
		}
	}
}
