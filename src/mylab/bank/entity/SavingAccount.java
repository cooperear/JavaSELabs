package mylab.bank.entity;

public class SavingAccount extends Account{
	private double interestRate;

	public SavingAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}
	
	
	public double getInterestRate() {
		return interestRate;
	}


	public void applyInterest() {
		
		double balance = super.getBalance();
		super.deposit((balance * (interestRate/100)));
		
	}
	@Override
	public String toString() {
		return String.format("account num : %s	name : %s	balance : %.2f	IR : %.2f",super.getAccountNumber(),super.getOwnerName(),super.getBalance(),this.interestRate);
		
	}
	
	
}
