

public class Account  {
	public Account(String accountNumber, double balance) {
		this.accountNumber=accountNumber;
		this.balance=balance;
		
		
	}

	private String accountNumber;
	private Double balance;

	public void subMenuAccount() {
		
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public boolean alreadyexist(String accountNumber)
	{
		return true;
	}

	public Account get(int i) {
	
		return null;
	}

	public int size() {
		return 0;
	}
}
