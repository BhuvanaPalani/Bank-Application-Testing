

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	Scanner input = new Scanner(System.in);
	
	private String name;
	private String password;
	private ArrayList<Account> accounts ;
	//private String listAllUsers;
	
	public User(String userName, String password,ArrayList<Account> accounts) {
		this.name=userName;
		this.password=password;
		this.accounts=accounts;
		
	}
	
	public User(String userName, String password) {
		this.name=userName;
		this.password=password;
		this.accounts= new ArrayList<>();
	}



	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public boolean alreadyexist(String Username)
	{
		return true;
	}

	public void addAccoount(Account account) {
		
	}
	
	}
	

