package examinationsystem;

public class Mark {
	String uname;
	int marks;

	public Mark(String uname, int marks)
	{
		this.uname = uname;
		this.marks = marks;
	}
	
	public String getUname()
	{
		return uname;
	}
	
	public int getMarks()
	{
		return marks;
	}
}
