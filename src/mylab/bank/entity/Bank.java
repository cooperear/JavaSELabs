package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;



import mylab.bank.entity.Account;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {

	private List<Account> accounts;
	private int nextAccountNumber;

	public Bank() {
		this.accounts = new ArrayList<Account>();
		this.nextAccountNumber = 1000;

	}

	public String createSavingsAccount(String name, double balance, double interestRate) {

		//
		Account a = new SavingAccount("SV" + String.valueOf(this.nextAccountNumber), name, balance, interestRate);

		this.nextAccountNumber++;

		accounts.add(a);
		return a.toString();

	}

	public String createCheckingAccount(String name, double balance, double limit) {

		Account a;
		// String.valueOf(this.nextAccountNumber++)
		a = new CheckingAccount("CH" + String.valueOf(this.nextAccountNumber), name, balance, limit);
		this.nextAccountNumber++;
		accounts.add(a);
		return a.toString();

	}

	public Account findAccount(String AccountNumber) {

		for (Account a : accounts) {
			if (a.getAccountNumber().equals(AccountNumber)) {
				return a;
			}
		}
		return null;
	}


	public void deposit(String AccountNumber, double credit)
			throws AccountNotFoundException, InsufficientBalanceException {
		// 예금
		Account a = findAccount(AccountNumber);
		if (a == (null)) {
			throw new AccountNotFoundException();
		} else {
			a.deposit(credit);
		}

	}

	public void withdraw(String AccountNumber, double rate) throws AccountNotFoundException, InsufficientBalanceException {
	    Account a = findAccount(AccountNumber);
	    if (a == null) {
	        throw new AccountNotFoundException();
	    } else {
	        // 각 계좌 유형의 withdraw 메소드가 직접 출금 로직과 예외 처리를 담당하도록 합니다.
	        a.withdraw(rate);
	    }
	}

	public void printAllAccounts() {
		for (Account a : accounts) {
			System.out.println((a.toString()));
		}

	}

}
