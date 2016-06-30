package bookshelf;

public class BadIsbnNumberException extends Exception {

	public BadIsbnNumberException(BadIsbnNumberErrorType error) {
		super(error.getMessage());
	}
}
