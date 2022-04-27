package examinationsystem;
public class Account {
    public enum AccountType 
    { 
        adminAccount, 
        studentAccount, 
        teacherAccount 
    }
    AccountType accountType;
    String email;
    String password;
}
