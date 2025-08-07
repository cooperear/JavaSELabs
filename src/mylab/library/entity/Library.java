package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.library.entity.Book;

public class Library {

	private List<Book> books = new ArrayList<>();
	private String name;

	public Library(String name) {
		super();
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> findBooksByTitle(String title) {
		
		List<Book> res = new ArrayList<Book>();
		for (Book b : books) {
			if (b.getTitle().contains(title)) {
				res.add(b);
			}

		}

		return res;
	}

	public List<Book> findBooksByAuthor(String author) {
		List<Book> res = new ArrayList<Book>();
		for (Book b : books) {
			if (b.getAuthor().contains(author)) {
				res.add(b);
			}

		}

		return res;
	}

	public Book findBooksByISBN(String isbn) {

		for (Book b : books) {
			if (b.getIsbn().equals(isbn)) {

				return b;

			}
		}

		return null;

	}

	public boolean checkOutBook(String isbn) {
		Book book = findBooksByISBN(isbn);
		if (book == null) {
			return false;
		}else {
			book.checkOut();
			return true;
		}
		
		
	}
	

	public boolean returnBook(String isbn) {
		Book book = findBooksByISBN(isbn);
		if (book == null) {
			return false;
		}else {
			book.returnBook();
			return true;
		}
		
	}

	public List<Book> getAvailableBooks() {
		List<Book> res = new ArrayList<Book>();
		
		for(Book b:books) {
			if(b.isAvailable()==true) {
				res.add(b);
			}
		}
		
		return res;
	}

	public int getTotalBooks() {
		int res = 0;
		for(Book b:books) {
			res++;
		}
		
		return res;
		
		
	}

	public int getAvailableBooksCount() {
		int res = 0;
		for(Book b:books) {
			
			if(b.isAvailable()==true){
				res++;
			}
		}
		
		return res;
	}

	public int BorrowedBooksCounts() {
		int res = 0;
		for(Book b:books) {
			
			if(b.isAvailable()==false){
				res++;
			}
		}
		
		return res;
	}

}
