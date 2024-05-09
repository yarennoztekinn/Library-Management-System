package Library;

import java.util.Scanner;

public class CalculateFine implements IOOperation {

	@Override
	public void oper(Database database, User user) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter book name: ");
		String bookName = scanner.next();
		
		boolean isItWrong = true;
		for (Borrowing b : database.getBrws()) {
			if (b.getBook().getName().matches(bookName) && b.getUser().getName().matches(user.getName())) {
				isItWrong = false;
				if (b.getDaysLeft() > 0) {
					System.out.println("You are late!\n"
							+ "You have to pay " + b.getDaysLeft() * 50 + " as fine\n");
				}else {
					System.out.println("You don't have to pay fine\n");
				}
			}
		}
		if (isItWrong) {
			System.out.println("maybe you enter book name wrong");
		}
		
		user.menu(database, user);
	}

}
