package bookshelf;

public enum BadIsbnNumberError {
	
		ERROR_CODE("ISBN bad code"), 
		ERROR_LENGTH("Isbn error length");
		
		private final String message;
		
		private BadIsbnNumberError(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return this.message;
		}
}
