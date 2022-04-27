package examinationsystem;

public class StudentMark {

	String subject;
	int marks;

	public StudentMark(String subject, int marks)
	{
		this.subject = subject;
		this.marks = marks;
	}
	
	public String getSubject()
	{
		return subject;
	}
	
	public int getMarks()
	{
		return marks;
	}
}
