package bookshelf;

import bookshelf.isbn.Isbn;

public class Book {

	private final Author author;
	private final Isbn isbn;

	public Book(Author author, Isbn isbn) throws BadIsbnNumberException {
		this.author = author;
		this.isbn = isbn;
		
		isbn.validateIsbn();
	}

	public Author getAuthor() {
		return author;
	}
	
	public Isbn getIsbn() {
		return isbn;
	}
}