package Library;

import java.util.Scanner;

public class PlaceOrder implements IOOperation {

	@Override
	public void oper(Database database, User user) {
		
		Scanner scanner = new Scanner(System.in);
		
		Order order = new Order();
		
		System.out.print("\nEnter book name: ");
		String bookName = scanner.next();
		
		int i = database.getBook(bookName);
		
		if (i <= -1) {
			System.out.println("Book doesn't exist!");
		}else {
			Book book = database.getBook(i);
			order.setBook(book);
			order.setUser(user);
			
			System.out.print("Enter qty: ");
			int qty = scanner.nextInt();// kaç copy order?
			
			order.setQty(qty);
			order.setPrice(book.getPrice() * qty);
			
			// yeterli copy var mı??
			
			if (book.getQty() >= qty) {
				int bookIndex = database.getBook(book.getName());
				book.setQty(book.getQty() - qty);
				database.addOrder(order, book, bookIndex);
				
				System.out.println("Order placed successfully!\n");
			}else {
				System.out.println("There are not that many copies in the library");
				System.out.println("the maximum amount you can order: " + book.getQty());
			}
		}
		user.menu(database, user);
	}


}
