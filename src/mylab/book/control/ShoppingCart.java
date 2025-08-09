package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;
import mylab.book.exception.InvalidPublicationException; // ���� Ŭ���� ����Ʈ

public class ShoppingCart {
	private List<Publication> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItem(Publication pub) {
		this.items.add(pub);
		System.out.println(pub.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
	}

	// ���ܸ� �������� ������ removeItem �޼���
	public void removeItem(String title) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getTitle().equals(title)) {
				Publication removed = items.remove(i);
				System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
				return; // ���������� ���ŵǸ� �޼��� ����
			}
		}
		// ���ǹ��� ã�� ���ϸ� ���ܸ� ����
		throw new InvalidPublicationException("��ٱ��Ͽ� '" + title + "'(��)��(��) �����ϴ�.");
	}

	public void displayCart() {
		for (Publication pub : items) {
			int currentPrice = pub.getPrice();
			int a;
			if (pub instanceof Magazine) {
				a = ((int) (currentPrice * 0.6));
			} else if (pub instanceof Novel) {
				a = ((int) (currentPrice * 0.8));
			} else {
				a = ((int) (currentPrice * 0.9));
			}
			System.out.println("���� �� ���� : " + currentPrice + " ���� �� ����: " + a + " ��ǰ���� " + pub.toString());
		}
	}

	// ... (calculateDiscountedPrice, printStatistics �޼���� ������ ����)

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
		cart.addItem(new Magazine("����ũ�μ���Ʈ����", "2007-10-01", 328, 9900, "����"));

		cart.displayCart();

		try {
			cart.removeItem("���߿�"); // ���������� ����
			cart.removeItem("���������ʴ�å"); // ���ܰ� �߻��� ��Ȳ
		} catch (InvalidPublicationException e) {
			System.err.println("���� �߻�: " + e.getMessage());
		}

		System.out.println("-- ���� �� ��ٱ��� ���� --");
		cart.displayCart();
	}
}