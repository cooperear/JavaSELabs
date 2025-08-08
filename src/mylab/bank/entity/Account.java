package mylab.bank.entity;

import javax.naming.InsufficientResourcesException;

import mylab.bank.exception.InsufficientBalanceException;

public class Account {
	private String AccountNumber,ownerName;
	private double balance;
	
	////////
	public Account(String accountNumber, String owserName, double balance) {
		super();
		AccountNumber = accountNumber;
		this.ownerName = owserName;
		this.balance = balance;
	}
	
	////////	
	public String getAccountNumber() {
		return AccountNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public double getBalance() {
		return balance;
	}
	///////
	
	public void deposit(double credit){
		
		this.balance+=credit;
		System.out.println(credit + " �ԱݿϷ�, ���� �ܾ� : " +this.balance);
		
	}
	
	public void withdraw(double credit) throws InsufficientBalanceException{
		if (credit > this.balance) {
			throw new InsufficientBalanceException("�׸�ŭ�� ���� ����� ���� �ܾ�:"+this.balance);
		}else {
			this.balance-=credit;
			System.out.println(credit + " ��ݿϷ�, ���� �ܾ� : " +this.balance);
		}
		
	}
	
	@Override
	public String toString() {
	    return String.format("account num : %s\tname : %s\tbalance : %.2f",
	            getAccountNumber(),
	            getOwnerName(),
	            getBalance());
	}

}
