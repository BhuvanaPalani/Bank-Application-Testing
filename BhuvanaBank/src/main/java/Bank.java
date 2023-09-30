

import java.util.ArrayList;

public class Bank {
	
	private ArrayList<User> users = new ArrayList<User>();

	
	public Bank() {
		ArrayList<Account> acc1 = new ArrayList<Account>();
		User  user1 = new User("Karthi","Volvo");
		acc1.add(new Account("69112",10000.00));
		acc1.add(new Account("691102",1000.00));
		user1.setAccounts(acc1);
		
		ArrayList<Account> acc2 = new ArrayList<Account>();
		User  user2 = new User("Anu","Mylife");
		acc2.add(new Account("12345",5000.00));
		acc2.add(new Account("1234",500.00));
		acc2.add(new Account("6789",2000.00));
		user2.setAccounts(acc2);
		
		ArrayList<Account> acc3 = new ArrayList<Account>();
		User  user3 = new User("Haasini","Beautiful");
		acc3.add(new Account("679112",4000.00));
		acc3.add(new Account("691102",500.00));
		user3.setAccounts(acc3);
		
		ArrayList<Account> acc4 = new ArrayList<Account>();
		User  user4 = new User("Nandhana","Naughty");
		acc4.add(new Account("01234",5000.00));
		acc4.add(new Account("2468",10000.00));
		user4.setAccounts(acc4);
		
		users.add(user1);
		users.add(user2);	
		users.add(user3);
		users.add(user4);
	}
	
	public ArrayList<User> GetUsers() {
        return users;

	}
	public void SetAccountMoney(User user,String accountNumber,double newBalance) 
	{
		
	}
}
