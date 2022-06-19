package Sbchalet.demo.exception;

public class NotfoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4808368682361797146L;

	public NotfoundException(String message) {
		super(message);
	}

	public NotfoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
