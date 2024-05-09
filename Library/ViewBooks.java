package Library;

import java.util.ArrayList;

public class ViewBooks implements IOOperation{

	@Override
	public void oper(Database database, User user) {
		
		ArrayList<Book> books = database.getAllBooks();
		System.out.println("Name\t\tAuthor\t\tPublisher\tCLA\tQty\tPrice\tBrw cps");
		
		for (Book book : books) {
			System.out.println(book.getName()+"\t\t"+book.getAuthor()+"\t\t"+book.getPublisher()+"\t\t"+book.getAdress()+"\t"+book.getQty()+"\t"+book.getPrice()+"\t"+book.getBrwcopies());
		}
		
		System.out.println();
		user.menu(database, user);
		
		
	}

}
