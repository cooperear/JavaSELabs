package mylab.bank.exception;

public class InsufficientBalanceException extends RuntimeException {
	public InsufficientBalanceException(String message) {
		super(message);
	}
	public InsufficientBalanceException() {
		super("--�ܾ� ����--");
		
	}
}
