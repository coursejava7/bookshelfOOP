package bookshelf;

public enum BadIsbnNumberErrorType {

	ERROR_CODE("ISBN bad code"), ERROR_LENGTH("Isbn error length");

	private final String message;

	private BadIsbnNumberErrorType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
