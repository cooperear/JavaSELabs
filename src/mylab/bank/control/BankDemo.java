package mylab.bank.control;

import javax.naming.InsufficientResourcesException;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingAccount;
import mylab.bank.exception.AccountNotFoundException;

public class BankDemo {

	public static void main(String[] args) throws InsufficientResourcesException, AccountNotFoundException {
		// TODO Auto-generated method stub
		Bank bank = new Bank();

		bank.createSavingsAccount("이하늘", 10000, 1.9);
		bank.createCheckingAccount("박시훈", 30000, 10000);
		bank.createSavingsAccount("박보카", 10000, 3.4);

		System.out.println("------계좌 목록--------");
		bank.printAllAccounts();

		try {

			System.out.println("------입출금 테스트--------");
			bank.deposit("CH1001", 10000.0);
			bank.deposit("SV1002", 10000.0);
			bank.withdraw("CH1001", 5000);
			bank.withdraw("SV1002", 5000);

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

		System.out.println("------이자적용 테스트--------");
		SavingAccount a = (SavingAccount) bank.findAccount("SV1002");
		a.applyInterest();

		System.out.println("------예외처리--------");
		try {

			bank.withdraw("SV1002", 50099);
		} catch (Exception E) {
			
			System.out.println(E.getMessage());
		}
		try {

			bank.withdraw("CH1001", 14000);
		} catch (Exception E) {
			
			System.out.println(E.getMessage());
		}
		
		
		try {

			bank.withdraw("SV999", 500000);
		} catch (Exception E) {
			System.out.println(E.getMessage());

		}

	}

}
