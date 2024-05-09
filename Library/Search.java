package Library;

import java.util.Scanner;

public class Search implements IOOperation{

	@Override
	public void oper(Database database, User user) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nEnter book name: ");
		String name = scanner.next();
		
		int ind = database.getBook(name);
		if (ind > -1) {
			System.out.println(database.getBook(ind).toString());
		}else {
			System.out.println("Book doesn't exist!\n");
		}
		user.menu(database, user);
		
	}

}
