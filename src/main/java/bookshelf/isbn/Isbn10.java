package bookshelf.isbn;

import bookshelf.BadIsbnNumberError;
import bookshelf.BadIsbnNumberException;

public class Isbn10 extends Isbn {
	
	public Isbn10(byte[] isbnNumber) throws BadIsbnNumberException {
		super(isbnNumber);
	}
	
	public boolean validateIsbn() throws BadIsbnNumberException {
		
		byte[] pattern = {1,2,3,4,5,6,7,8,9};
		byte[] isbnNumber = this.getIsbnNumber();
		
		if(getIsbnNumber().length != 10) {
			throw new BadIsbnNumberException(BadIsbnNumberError.ERROR_LENGTH);
		}
		
		short total = 0;
		byte controlCode = 0;
		
		for(int x = 0; x < 9; x++){
			total = (short) (total +  (pattern[x] * isbnNumber[x]));
		}
		
		controlCode = (byte)(total % 11);
		
		if(controlCode != isbnNumber[9]) {
			throw new BadIsbnNumberException(BadIsbnNumberError.ERROR_CODE);
		}
		
		return true;
	}
	
	public static void main(String[] args) throws BadIsbnNumberException {
		
		Isbn isbn10 = new Isbn10(new byte[]{8,4,3,6,5,4,2,0,1,0});
		System.out.println(isbn10.getIsbnAsString());
		
	}	

}
