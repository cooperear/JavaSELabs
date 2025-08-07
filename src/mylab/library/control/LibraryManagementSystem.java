package mylab.library.control;
import mylab.library.entity.Library;
import mylab.library.entity.Book;
public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		Library sakuraLibrary = new Library("벚꽃 도서관");
		
		addSampleBooks(sakuraLibrary);
		
		showLibraryInfo(sakuraLibrary);
		
		
		
		testFindBook(sakuraLibrary);
		
		

		String isbn = "978-89-01-67890-1";
		
		testCheckOut(sakuraLibrary, isbn);
		
		showLibraryInfo(sakuraLibrary);
		
		testReturn(sakuraLibrary, isbn);
		
		showLibraryInfo(sakuraLibrary);
		
		displayAvailableBooks(sakuraLibrary);
		
	}

	public static void displayAvailableBooks(Library sakuraLibrary) {
		System.out.println("======"+"대출 가능한 도서 목록 "+"======");
		for(Book b:sakuraLibrary.getBooks()) {
			if (b.isAvailable()==true) {
				System.out.println(b);
				System.out.println("---------\n");
			}
			
		}
	}

	public static void testReturn(Library sakuraLibrary, String isbn) {
		System.out.println("======"+"도서 반납"+"======");
		boolean res = sakuraLibrary.returnBook(isbn);
		if (res ==true) {
			System.out.println("반납완료");
			System.out.println("반납된 도서 정보: \n"+sakuraLibrary.findBooksByISBN(isbn));	
		}else {
			System.out.println("실패");
		}
	}

	public static void testCheckOut(Library sakuraLibrary, String isbn) {
		System.out.println("======"+"도서 대출 서비스"+"======");
		
		boolean res = sakuraLibrary.checkOutBook(isbn);
		if (res==true) {
			System.out.println("대출 완료");
			System.out.println("대출 도서 정보: \n"+sakuraLibrary.findBooksByISBN(isbn));
		}else {
			System.out.println("실패");
		}
		
		
		
	}

	public static void showLibraryInfo(Library library) {
		System.out.println("======"+library.getName()+"======");
		System.out.println(String.format("전체 도서수 : %d\n대출 가능한 도서수 :%d\n대출중인 도서수: %d",library.getTotalBooks(),library.getAvailableBooksCount(),library.BorrowedBooksCounts()));
	}

	public static void testFindBook(Library library) {
		System.out.println("======"+"도서 검색 서비스"+"======");
		System.out.println("제목으로 검색");
		for(Book book:library.findBooksByTitle("자바")) {
			System.out.println(book);	
		}
		
		System.out.println("저자로 검색:");
		for(Book book:library.findBooksByAuthor("김자바")) {
			System.out.println(book);	
		}
		
	}
	
	private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}
	
	
	
}
