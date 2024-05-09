package Library;

import java.util.Scanner;

public class DeleteAllData implements IOOperation{

	@Override
	public void oper(Database database, User user) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nAre you sure that you want to delete all data?\n"
				+"1. Continue\n2. Main menu");
		int i = scanner.nextInt();
		
		if (i == 1) {
			database.deleteAllData();
		}else {
			user.menu(database, user);
		}
	}

}
