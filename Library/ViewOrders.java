package Library;

import java.util.Scanner;

public class ViewOrders implements IOOperation{

	@Override
	public void oper(Database database, User user) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nEnter book name: ");
		String bookName = scanner.next();
		
		int i = database.getBook(bookName);
		if (i > -1) {
			System.out.println("Book\t\tUser\t\tQTY\tPrice");
			for(Order order: database.getAllOrders()) {
				if (order.getBook().getName().matches(bookName)) {
					System.out.println(order.getBook().getName()+"\t\t"+order.getUser().getName()+"\t\t"+order.getQty()+"\t"+order.getPrice());
				}
			}
			System.out.println();
		}else {
			System.out.println("Book doesn't exist!\n");
		}
		user.menu(database, user);
	}
	
}
