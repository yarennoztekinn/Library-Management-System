package Library;
import java.util.Scanner;

public class BorrowBook implements IOOperation {

	@Override
	public void oper(Database database, User user) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter book name: ");
		String bookName = scanner.next();
		
		int ind = database.getBook(bookName);
		
		if (ind > -1) {
			Book book = database.getBook(ind);
			boolean isAlreadyBorrowed = false;
			
			for (Borrowing b : database.getBrws()) {
				
				if (b.getBook().getName().matches(bookName) && b.getUser().getName().matches(user.getName())) {
					
					isAlreadyBorrowed = true;
					System.out.println("You have already borrowed this book before!");
					break;
				}
			}
			if (!isAlreadyBorrowed) {
				if (book.getBrwcopies() >= 1) {
					Borrowing borrowing = new Borrowing(book, user);
					book.setBrwcopies(book.getBrwcopies()-1);
					database.borrowBook(borrowing, book, ind);
					System.out.println("You must return the book before 14 days from now on\n"
							+"Expiry date: " + borrowing.getFinish() + "\nEnjoy!\n");
				}else {
					System.out.println("This book isn't avaible");
				}
			}
		}else { //ind = 0
			System.out.println("Book doesn't exist!\n");
		}
		user.menu(database, user);
	}
}
