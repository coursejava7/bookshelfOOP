package bookshelf.isbn;

import bookshelf.BadIsbnNumberErrorType;
import bookshelf.BadIsbnNumberException;

/**
 * 
 * ISBN13 implementation
 *
 */
public class Isbn13 extends Isbn {

	public Isbn13(byte[] isbnNumber) throws BadIsbnNumberException {
		super(isbnNumber);
	}

	public boolean validateIsbn() throws BadIsbnNumberException {

		byte[] pattern = { 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3 };
		byte[] isbnNumber = this.getIsbnNumber();

		if (getIsbnNumber().length != 13) {
			throw new BadIsbnNumberException(BadIsbnNumberErrorType.ERROR_LENGTH);
		}

		short total = 0;
		byte controlCode = 0;

		for (int x = 0; x < 12; x++) {
			total = (short) (total + (pattern[x] * isbnNumber[x]));
		}

		controlCode = (byte) (10 - (total % 10));

		if (controlCode != isbnNumber[12]) {
			throw new BadIsbnNumberException(BadIsbnNumberErrorType.ERROR_CODE);
		}

		return true;
	}
}