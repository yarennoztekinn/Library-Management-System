package Library;

import java.util.Scanner;

public class DeleteBook implements IOOperation {

	@Override
	public void oper(Database database, User user) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter book name: ");
		String bookName = scanner.next();
		
		int ind = database.getBook(bookName);
		if (ind > -1) {
			database.deleteBook(ind);
			System.out.println("Book deleted successfully!\n");
		}else {
			System.out.println("Book doesn't exist!\n");
		}
		user.menu(database, user);
	}

}
