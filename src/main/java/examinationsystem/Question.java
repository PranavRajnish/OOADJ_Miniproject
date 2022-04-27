package examinationsystem;

public class Question {
	public int questionNumber;
	public String questionString;
	public String o1;
	public String o2;
	public String o3;
	public String o4;
	public String ans;
	public Question(int questionNumber, String question, String o1, String o2, String o3, String o4, String ans)
	{
		this.questionNumber = questionNumber;
		this.questionString = question;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.o4 = o4;
		this.ans = ans;
	}
	
	@Override
	public String toString()
	{
		return questionNumber + " "+ questionString + " " + o1 + " " + o2 + " " + o3 + " " + o4 + " " + ans;
	}
	public String getQuestionString() {
	    return questionString;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public String getO1() {
	    return o1;
	}
	public String getO2() {
	    return o2;
	}
	public String getO3() {
	    return o3;
	}
	public String getO4() {
	    return o4;
	}
	public String getAns() {
	    return ans;
	}
}
