package bookshelfOOP;

import bookshelf.BadIsbnNumberErrorType;
import bookshelf.BadIsbnNumberException;
import bookshelf.isbn.Isbn;
import bookshelf.isbn.Isbn10;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Isbn10Test {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void givenAGoodIsbnNumberNoneExceptionIsExpected() {

		byte[] isbnNumber = { 0, 0, 7, 1, 8, 0, 8, 5, 5, 8 };
		Isbn isbn = null;

		try {
			isbn = new Isbn10(isbnNumber);
		} catch (BadIsbnNumberException bine) {
		}

		assertTrue("Expected good ISBN number but not created!!", isbn != null);
	}

	@Test
	public void givenABadShortIsbn10NumberAnExceptionIsExpected() throws BadIsbnNumberException {

		thrown.expect(BadIsbnNumberException.class);
		thrown.expectMessage(BadIsbnNumberErrorType.ERROR_LENGTH.getMessage());

		byte[] isbnNumber = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Isbn isbn = new Isbn10(isbnNumber);

	}

	@Test
	public void givenABadIsbnNumberAnExceptionIsExpected() throws BadIsbnNumberException {

		thrown.expect(BadIsbnNumberException.class);
		thrown.expectMessage(BadIsbnNumberErrorType.ERROR_CODE.getMessage());

		byte[] isbnNumber = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
		Isbn isbn = new Isbn10(isbnNumber);

	}

}