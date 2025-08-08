package mylab.bank.exception;

public class WithdrawalLimitExeededExeption extends InsufficientBalanceException {

	public WithdrawalLimitExeededExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public WithdrawalLimitExeededExeption() {
		super("--출금한도 초과--");
		
	}

}
