package mylab.library.entity;

public class Book {
	private String title, author, isbn;
	private int publishYear;
	private boolean isAvailable;

	public Book() {

	}

	public Book(String title, String author, String isbn, int publishYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean checkOut() {

		if (this.isAvailable == true) {
			this.isAvailable = false;
			return true;
		} else {
			return false;
		}

	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void returnBook() {
		this.isAvailable=true;
	}
	
	public String toString(){
		
		return String.format("책 제목 : %s\t저자: %s\tISBN: %s,출판년도: %d, 대출가능여부 %b",title,author,isbn,publishYear,isAvailable);
	}

}
