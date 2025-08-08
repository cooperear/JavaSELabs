package mylab.bank.entity;

import mylab.bank.entity.Account;
import mylab.bank.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {

	private double withdrawalLimit;

	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	@Override
	public void withdraw(double credit) throws InsufficientBalanceException {
	    if (credit > getBalance() || credit > this.withdrawalLimit) {
	        throw new InsufficientBalanceException("한도초과, 한도:" + this.withdrawalLimit);
	    } else {
	        // 부모 클래스의 withdraw 메소드를 호출하여 잔액에서 출금합니다.
	        super.withdraw(credit);
	    }
	}

	@Override
	public String toString() {
		return String.format("account num : %s\tname : %s\tbalance : %.2f\t Limit : %.2f", getAccountNumber(),
				getOwnerName(), getBalance(), withdrawalLimit);
	}

}
