

import java.util.ArrayList;
import java.util.Scanner;

public class Bankomat {
	
	static Scanner input = new Scanner(System.in); // Create scanner to obtain input from command window
	
	
	private ArrayList<User> users = new ArrayList<User>();
	private User currentUser;


	private Bank bank = new Bank();
	
	public Bankomat() {

	}
	public Bankomat(Bank bank2, User user) {
		this.bank = bank2;
		currentUser = user;

	}


	public void Run() { 
		
		users = bank.GetUsers();
		
		boolean tryAgain = false;	
		do{	
			currentUser=null;
			System.out.println("Log in: ");
	        System.out.println("Welcome our esteemed customer,");
	        System.out.println("Enter User name:");
			String account = input.nextLine();
	        System.out.println("Enter Password:");
	        String password = input.nextLine();
	        
	        boolean succesfullLogin = login(account,password);
	       
	        
	        if(succesfullLogin)
        	{
	        	System.out.println("You are loged in. Kindly select one option from :-");
	        	
        	} else
        	{
        		System.out.println("Incorrect User Name or Password.");
        		System.out.println("Please try gain.");
        		continue;
        	}
	        
	        
	        boolean exitBankMenu = false;	
	        do{ 
	        	System.out.println("Enter 1 to Withdraw Money");
	        	System.out.println("Enter 2 to Deposit Money");
	        	System.out.println("Enter 3 to Check balance ");
	        	System.out.println("Enter 4 to Logout");
	        	String menu = input.nextLine();
	        	
	        
			switch(menu)  {
		        
				case "1" :
					System.out.println("Enter account number");
					String withdrawaccountnumber = input.nextLine();
					System.out.println("Enter ammount to withdraw");
					try {
						double withdrawamount = input.nextDouble();
						input.nextLine();
						
						withdrawMoney(withdrawaccountnumber,withdrawamount);
						exitBankMenu = false;
					}
					catch (Exception e) {
						System.out.println("We only accept numbers.");
					}
					break;
	  	
				case "2" :
					System.out.println("Enter account number");
					String depositaccountnumber = input.nextLine();
					System.out.println("Enter ammount to deposit");
					try {
						double deositamount = input.nextDouble();
						input.nextLine();
						depositMoney(depositaccountnumber,deositamount);
						exitBankMenu = false;
					}
					catch (Exception e) {
						System.out.println("We only accept numbers.");
					}
					break;
					
				case "3" :
					System.out.println("Enter account number:");
					String balanceAccountnumber = input.nextLine();
					checkAccountbalance(balanceAccountnumber);
					exitBankMenu = false;
					break;
					
				case "4" :
				    System.out.println("You are loged out");
				    System.out.println("Thank you for today! You are welcome back!");
				    exitBankMenu = true;
				    break;
					
			} 
	        }while(!exitBankMenu);
	        
	        System.out.println("Do you want to exit Bank Application? Enter yes or no");
	        String keepUsing = input.nextLine();
	        if(keepUsing.equalsIgnoreCase("yes"))
	        	tryAgain=true;
	        else if(keepUsing.equalsIgnoreCase("no"))
	        	tryAgain=false;
	        else
	        {
	        	System.out.println("Invalid input. Banking system still continue");
	        	tryAgain=false;
	        }
		} while(!tryAgain);
		tryAgain = false;

		tryAgain = true;
	
		//close scanner
		(input).close();
			
	}
				

	public boolean login(String UserName, String password)
	{
		User user;
		users = bank.GetUsers();
		for (int i = 0; i < users.size(); i++) {

			user = users.get(i);
			if (user.getName().equalsIgnoreCase(UserName)&& user.getPassword().equals(password))
			{
				currentUser = user;
				return true;
			}
		} 
		return false;
		
	}
	
	
	public void checkAccountbalance(String accountNumber)
	{
		ArrayList<Account> CureentUserAccounts = currentUser.getAccounts();
		Account account ;
		Boolean accountexist=false;
		for (int i = 0; i < CureentUserAccounts.size(); i++) {

			account = CureentUserAccounts.get(i);
			if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
				accountexist = true;
				System.out.println("Your current balance is " + account.getBalance() );
				
			}
		}
		if(!accountexist)
			System.out.println(" Account does not exist");
	}
	
	public void withdrawMoney(String accountNumber,double ammount)
	{
		
		
		ArrayList<Account> CurrentUserAccounts = currentUser.getAccounts();
		Account account ;
		boolean accountexist=false;
		for (int i = 0; i < CurrentUserAccounts.size(); i++) {

			account = CurrentUserAccounts.get(i);
			if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
				accountexist = true;
				if(account.getBalance()>ammount) {
					account.setBalance(account.getBalance()-ammount);
					System.out.println("Your current balance is " + account.getBalance() );
					
				}
				else {
					System.out.println("Insufficient balance");
					System.out.println("please try again");
				}
				
			}
		}
		if(!accountexist)
			System.out.println(" Account doesnt exist");

		
	}	
	
	//private String userName() {
		//return null;
	//}

	public void depositMoney(String accountNumber, double ammount)
	{
		ArrayList<Account> CureentUserAccounts = currentUser.getAccounts();
		Account account ;
		boolean accountexist=false;
		for (int i = 0; i < CureentUserAccounts.size(); i++) {

			account = CureentUserAccounts.get(i);
			if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
				accountexist = true;
				account.setBalance(account.getBalance()+ammount);
				System.out.println("Your current balance is " + account.getBalance() );
				
			}
		} 
		if(!accountexist)
			System.out.println(" Account does not exist");

	}
	
	
	
}
