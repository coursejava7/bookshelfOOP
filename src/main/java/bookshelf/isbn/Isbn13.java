package bookshelf.isbn;

import bookshelf.BadIsbnNumberError;
import bookshelf.BadIsbnNumberException;

public class Isbn13 extends Isbn {
	
	public Isbn13(byte[] isbnNumber) throws BadIsbnNumberException {
		super(isbnNumber);
	}
	
	public boolean validateIsbn() throws BadIsbnNumberException {
		
		byte[] pattern = {1,3,1,3,1,3,1,3,1,3,1,3};
		byte[] isbnNumber = this.getIsbnNumber();
		
		if(getIsbnNumber().length != 13) {
			throw new BadIsbnNumberException(BadIsbnNumberError.ERROR_LENGTH);
		}
		
		short total = 0;
		byte controlCode = 0;
		
		for(int x = 0; x < 12; x++){
			total = (short) (total +  (pattern[x] * isbnNumber[x]));
		}
		
		controlCode = (byte)(10 - (total % 10));
		
		if(controlCode != isbnNumber[12]) {
			throw new BadIsbnNumberException(BadIsbnNumberError.ERROR_CODE);
		}
		
		return true;
	}
	
	
	public static void main(String[] args) throws BadIsbnNumberException {
		
		Isbn isbn13 = new Isbn13(new byte[]{3,3,6,7,7,2,9,0,0,4,8,0,9});
		System.out.println(isbn13.getIsbnAsString());
		
	}
}
