package mylab.book.entity;

public class Magazine extends Publication {
	private String publishPeriod;

	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
		super(title, publishDate, page, price);
		this.publishPeriod = publishPeriod;
		// TODO Auto-generated constructor stub
	}

	public String getPublishPeriod() {
		return publishPeriod;
	}

	public void setPublishPeriod(String publishPeriod) {
		this.publishPeriod = publishPeriod;
	}

	@Override
	public String toString() {
		return String.format("���� : %s\t������ : %s\t �������� : %d\t���� : %d\t����Ⱓ : %s", super.getTitle(),
				super.getPublishDate(), super.getPage(), super.getPrice(), this.publishPeriod);
	}

}
