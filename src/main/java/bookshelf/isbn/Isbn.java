package bookshelf.isbn;

import bookshelf.BadIsbnNumberError;
import bookshelf.BadIsbnNumberException;

public abstract class Isbn implements Cloneable {
	
	private final byte[] isbnNumber; //field encapsulated : isbn number.
	
	/**
	 * This method is declared abstract to be implemented by the extended classes
	 * because the digit control calculation could be different.
	 * 
	 * @return
	 */
	public abstract boolean validateIsbn() throws BadIsbnNumberException;
	
	/**
	 * It initializes the instance with a final valor for ISBN number.  
	 * 
	 * @param isbnNumber
	 */
	protected Isbn(byte[] isbnNumber) throws BadIsbnNumberException {
		this.isbnNumber = isbnNumber;
		if(!validateIsbn()) {
			throw new BadIsbnNumberException(BadIsbnNumberError.ERROR_CODE);
		}
	}
	
	public byte[] getIsbnNumber(){
		return isbnNumber.clone();
	}
	
	public String getIsbnAsString(){
		
		StringBuffer strb = new StringBuffer();
		
		for(byte b : isbnNumber) {
			strb.append(b);
		}
		
		return strb.toString();
	}
	
	/**
	 * Overriding method toString allows return the isbn number with the digit control.
	 */
	public String toString() {
		
		StringBuffer result = new StringBuffer();
		
		for(byte b: isbnNumber){
			result.append(Byte.toString(b));
		}
		
		return result.toString();
	}
}