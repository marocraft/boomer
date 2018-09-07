package ma.craft.boomer.exception;

public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new data not found exception.
	 *
	 * @param message the message
	 */
	public DataNotFoundException(String message) {
		super(message);
	}
}
