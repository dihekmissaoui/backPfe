package Sbchalet.demo.exception;

public class PostNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4808368682361797146L;

	public PostNotFoundException(String message) {
		super(message);
	}

	public PostNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
