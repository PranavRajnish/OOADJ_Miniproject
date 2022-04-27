package examinationsystem;

import database.DBHelper;

public class Administrator extends Account 
{
    String admin_id;

    public Administrator(String uname, String password)
    {
    	accountType = Account.AccountType.adminAccount;
    	email = uname;
    	this.password = password;
    }
    
    Boolean createAccount(String role, String username, String password)
    {
    	DBHelper dbHelper = DBHelper.getInstance();
    	Student newStudent = new Student();
 	    Boolean success = dbHelper.addAccount(role, username, password);
 	    return success;
    }

}

