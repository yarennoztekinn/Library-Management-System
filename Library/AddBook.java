package Library;

import java.util.Scanner;

public class AddBook implements IOOperation{

	@Override
	public void oper(Database database, User user) {
		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		
		System.out.print("\nEnter book name: ");
		String name = scanner.next();
		if (database.getBook(name) > -1) {
			System.out.println("there is a book with this name!\n");
			user.menu(database, user);
			return;
		}
		else {
			book.setName(name);
			System.out.print("Enter book author: ");
			book.setAuthor(scanner.next());
	 		
			System.out.print("Enter book publisher: ");
			book.setPublisher(scanner.next());
			
			System.out.print("Enter book collection adress: ");
			book.setAdress(scanner.next());
			
			System.out.print("Enter qty: ");
			book.setQty(scanner.nextInt());
			
			System.out.print("Enter price: ");
			book.setPrice(scanner.nextDouble());
			
			System.out.print("Enter borrowing copies: ");
			book.setBrwcopies(scanner.nextInt());
			
			database.addBook(book);
			System.out.println("Book added succesfully\n");
			
			user.menu(database, user);
			scanner.close();
		}
		
	}

}
