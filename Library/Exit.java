package Library;

import java.util.Scanner;

public class Exit implements IOOperation {
	
	Scanner scanner;
	Database database;
	User user;
	
	@Override
	public void oper(Database database, User user) {
		this.database = database;
		this.user = user;
		
		scanner = new Scanner(System.in);
		
		System.out.println("\nAre you sure that you want to exit?\n"
				+"1. Yes\n2. Main menu");
		int i = scanner.nextInt();
		
		if (i == 1) {
			System.out.println("0. Exit\n1. Login\n2. New user");
			
			int num = scanner.nextInt();
			
			switch (num) {
			case 0: break;
			case 1: login();break;
			case 2 : newUser();break;
			default : System.out.println("Error!");
			}
		}else {
			user.menu(database, user);
		}
	}
	
	private void login() {
		System.out.print("\nEnter phone number:");
		String phoneNumber  = scanner.next();
		System.out.print("Enter email:");
		String email = scanner.next();
		
		int n = database.login(phoneNumber, email);
		
		if (n != -1) { // eşleşme varsa
			User user = database.getUser(n);
			user.menu(database, user); 
		}else {
			System.out.println("User doesn't exist!");
		}
		
	}
	
	private void newUser() {
		System.out.print("Enter name:");
		String name = scanner.next();
		System.out.print("Enter phone number ");
		String phoneNumber = scanner.next();
		System.out.print("Enter email:");
		String email = scanner.next();
		
		System.out.println("1. Admin \n2. Normal User");
		int n2 = scanner.nextInt();
		
		User user;//default
		if (n2==1) {
			user = new Admin(name,email,phoneNumber);
		}else {
			user = new NormalUser(name, email, phoneNumber);
		}
		
		database.AddUser(user);
		user.menu(database,user);
		
	}


}
