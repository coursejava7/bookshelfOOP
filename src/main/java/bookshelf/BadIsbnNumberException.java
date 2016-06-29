package bookshelf;

public class BadIsbnNumberException extends Exception {
	
	public BadIsbnNumberException(BadIsbnNumberError error) {
		super(error.getMessage());
	}
}
