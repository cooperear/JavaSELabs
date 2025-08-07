package mylab.library.control;
import mylab.library.entity.Library;
import mylab.library.entity.Book;
public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		Library sakuraLibrary = new Library("���� ������");
		
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
		System.out.println("======"+"���� ������ ���� ��� "+"======");
		for(Book b:sakuraLibrary.getBooks()) {
			if (b.isAvailable()==true) {
				System.out.println(b);
				System.out.println("---------\n");
			}
			
		}
	}

	public static void testReturn(Library sakuraLibrary, String isbn) {
		System.out.println("======"+"���� �ݳ�"+"======");
		boolean res = sakuraLibrary.returnBook(isbn);
		if (res ==true) {
			System.out.println("�ݳ��Ϸ�");
			System.out.println("�ݳ��� ���� ����: \n"+sakuraLibrary.findBooksByISBN(isbn));	
		}else {
			System.out.println("����");
		}
	}

	public static void testCheckOut(Library sakuraLibrary, String isbn) {
		System.out.println("======"+"���� ���� ����"+"======");
		
		boolean res = sakuraLibrary.checkOutBook(isbn);
		if (res==true) {
			System.out.println("���� �Ϸ�");
			System.out.println("���� ���� ����: \n"+sakuraLibrary.findBooksByISBN(isbn));
		}else {
			System.out.println("����");
		}
		
		
		
	}

	public static void showLibraryInfo(Library library) {
		System.out.println("======"+library.getName()+"======");
		System.out.println(String.format("��ü ������ : %d\n���� ������ ������ :%d\n�������� ������: %d",library.getTotalBooks(),library.getAvailableBooksCount(),library.BorrowedBooksCounts()));
	}

	public static void testFindBook(Library library) {
		System.out.println("======"+"���� �˻� ����"+"======");
		System.out.println("�������� �˻�");
		for(Book book:library.findBooksByTitle("�ڹ�")) {
			System.out.println(book);	
		}
		
		System.out.println("���ڷ� �˻�:");
		for(Book book:library.findBooksByAuthor("���ڹ�")) {
			System.out.println(book);	
		}
		
	}
	
	private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}
	
	
	
}
