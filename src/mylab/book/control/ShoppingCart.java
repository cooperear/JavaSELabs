package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;
import mylab.book.exception.InvalidPublicationException; // 예외 클래스 임포트

public class ShoppingCart {
	private List<Publication> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItem(Publication pub) {
		this.items.add(pub);
		System.out.println(pub.getTitle() + "이(가) 장바구니에 추가되었습니다.");
	}

	// 예외를 던지도록 수정한 removeItem 메서드
	public void removeItem(String title) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getTitle().equals(title)) {
				Publication removed = items.remove(i);
				System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
				return; // 성공적으로 제거되면 메서드 종료
			}
		}
		// 출판물을 찾지 못하면 예외를 던짐
		throw new InvalidPublicationException("장바구니에 '" + title + "'(는)이(가) 없습니다.");
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
			System.out.println("할인 전 가격 : " + currentPrice + " 할인 후 가격: " + a + " 상품정보 " + pub.toString());
		}
	}

	// ... (calculateDiscountedPrice, printStatistics 메서드는 기존과 동일)

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
		cart.addItem(new Magazine("마이크로소프트웨어", "2007-10-01", 328, 9900, "월간"));

		cart.displayCart();

		try {
			cart.removeItem("빠삐용"); // 정상적으로 제거
			cart.removeItem("존재하지않는책"); // 예외가 발생할 상황
		} catch (InvalidPublicationException e) {
			System.err.println("오류 발생: " + e.getMessage());
		}

		System.out.println("-- 제거 후 장바구니 상태 --");
		cart.displayCart();
	}
}