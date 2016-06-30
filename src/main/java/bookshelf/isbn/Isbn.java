package bookshelf.isbn;

import bookshelf.BadIsbnNumberErrorType;
import bookshelf.BadIsbnNumberException;

/**
 * This class is an example of immutability The field isbnNumber is
 * encapsulated. It cannot be modified once the instance is created.
 * 
 * The methods returns a copy to avoid the callers can change the values of the
 * byte array.
 * 
 */
public abstract class Isbn {

	private final byte[] isbnNumber; // field encapsulated and final.

	/**
	 * This method is declared abstract to be implemented by the extended
	 * classes due that the validation can be different between different ISBN
	 * types.
	 * 
	 * @return
	 */
	protected abstract boolean validateIsbn() throws BadIsbnNumberException;

	/**
	 * Constructs an Isbn instance with the ISBN number.
	 * 
	 * @param isbnNumber
	 *            the ISBN number.
	 * @throws BadIsbnNumberException
	 *             This exception is thrown when the ISBN number has some error.
	 * 
	 */
	protected Isbn(byte[] isbnNumber) throws BadIsbnNumberException {
		this.isbnNumber = isbnNumber;
		if (!validateIsbn()) {
			throw new BadIsbnNumberException(BadIsbnNumberErrorType.ERROR_CODE);
		}
	}

	/**
	 * This method returns a copy of the ISBN.
	 */
	public byte[] getIsbnNumber() {
		return isbnNumber.clone();
	}

	public String getIsbnAsString() {

		StringBuffer strb = new StringBuffer();

		for (byte b : isbnNumber) {
			strb.append(b);
		}

		return strb.toString();
	}

	/**
	 * Overriding method toString to return the ISBN.
	 */
	public String toString() {

		StringBuffer result = new StringBuffer();

		for (byte b : isbnNumber) {
			result.append(Byte.toString(b));
		}

		return result.toString();
	}
}