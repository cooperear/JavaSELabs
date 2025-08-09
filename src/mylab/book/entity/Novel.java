package mylab.book.entity;

public class Novel extends Publication{


	public Novel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Novel(String title, String publishDate, int page, int price,String author, String genre) {
		super(title, publishDate, page, price);

		this.author = author;
		this.genre = genre;
		// TODO Auto-generated constructor stub
	}
	
	private String author,genre;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return String.format("���� : %s\t�߰��� : %s\t�������� : %d\t���� : %d\t���� : %s \t�帣 : %s",super.getTitle(),
				super.getPublishDate(),super.getPage(),super.getPrice(),this.author,this.genre);

	}
	
}
