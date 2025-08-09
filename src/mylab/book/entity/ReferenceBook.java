package mylab.book.entity;

public class ReferenceBook extends Publication {
	private String field;

	public ReferenceBook(String field) {
		super();
		this.field = field;
	}

	public ReferenceBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReferenceBook(String title, String publishDate, int page, int price, String field) {
		super(title, publishDate, page, price);
		this.field = field;
		// TODO Auto-generated constructor stub
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return String.format("���� : %s\t������ : %s\t �������� : %d\t���� : %d\t�ʵ� : %s", super.getTitle(),
				super.getPublishDate(), super.getPage(), super.getPrice(), this.field);
	}

}
