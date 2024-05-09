package Library;

public abstract class User {// setlerde email ve phoneNumber check
	
	protected String name; 
	protected String email; 
	protected String phoneNumber; 
	protected IOOperation[] operations; // arayüz türünden bir dizi oluşturabilir ve bu diziyi arayüzü uygulayan sınıfların örnekleriyle doldurabilirsiniz
	
	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	abstract public String toString();
	
	abstract public void menu(Database database, User user);
}
