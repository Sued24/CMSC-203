public class SavingsAccount extends BankAccount 
{
	private final double RATE = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name , double initial)
	{
		super(name , initial);
		this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount saveAcc , double initial)
	{
		super(saveAcc , initial);
		savingsNumber = saveAcc.savingsNumber + 1;
		this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public void postInterest()
	{
		super.setBalance(super.getBalance() + (super.getBalance() * (RATE / 12)));
	}
	
	public String getAccountNumber()
	{
		return accountNumber;
	}
}
