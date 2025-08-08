package mylab.bank.exception;

public class AccountNotFoundException extends Exception{

	/**
	 * 
	 */
	
	public AccountNotFoundException(String message) {
		super(message);
	}
	public AccountNotFoundException() {
		super("--°èÁ¤ÀÌ ¾ø´Âµª¼î?--");
	}

}
