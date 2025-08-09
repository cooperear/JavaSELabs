package mylab.book.entity;

public class Publication {
	private String title, publishDate;
	private int page, price;
	
	public Publication() {} // �Ű����� ������: ��� �ʵ� �ʱ�ȭ 

	public Publication(String title, String publishDate, int page, int price) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.page = page;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
