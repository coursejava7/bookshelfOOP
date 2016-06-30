package bookshelfOOP;

import bookshelf.BadIsbnNumberErrorType;
import bookshelf.BadIsbnNumberException;
import bookshelf.isbn.Isbn;
import bookshelf.isbn.Isbn13;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Isbn13Test {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void givenAGoodIsbnNumberNoneExceptionIsExpected() {

		byte[] isbnNumber = { 9, 7, 8, 1, 4, 0, 2, 8, 9, 4, 6, 2, 6 };
		Isbn isbn = null;

		try {
			isbn = new Isbn13(isbnNumber);
		} catch (BadIsbnNumberException bine) {
		}

		assertTrue("Expected good ISBN number but not created!!", isbn != null);
	}

	@Test
	public void givenABadShortIsbn10NumberABadIsbnErrorLengthExceptionIsExpected() throws BadIsbnNumberException {

		thrown.expect(BadIsbnNumberException.class);
		thrown.expectMessage(BadIsbnNumberErrorType.ERROR_LENGTH.getMessage());

		byte[] isbnNumber = { 9, 7, 8, 1, 4, 0, 2, 8, 9, 4, 6 };
		Isbn isbn = new Isbn13(isbnNumber);

	}

	@Test
	public void givenABadIsbnNumberABadIsbnErrorCodeExceptionIsExpected() throws BadIsbnNumberException {

		thrown.expect(BadIsbnNumberException.class);
		thrown.expectMessage(BadIsbnNumberErrorType.ERROR_CODE.getMessage());

		byte[] isbnNumber = { 9, 7, 8, 1, 4, 0, 2, 8, 9, 4, 6, 2, 5 };
		Isbn isbn = new Isbn13(isbnNumber);

	}
}