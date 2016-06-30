package bookshelf;

import bookshelf.isbn.Isbn;


public class Book {

	private final Isbn isbn;

	public Book(Isbn isbn) {
		this.isbn = isbn;
	}

	public Isbn getIsbn() {
		return isbn;
	}
}