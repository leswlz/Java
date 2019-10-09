public class ClientRegister {
    public static void main(String args[]) {
        CashClient client1 = new CashClient("Lisa", "101070-1111");
        AccountClient client2 = new AccountClient("Benny", "101070-1111");
        AccountClient client3 = new AccountClient("Barney", "040474-1571", "Someroad 3");
        Client client4 = new Client("Client", "111170-1111", "Road 4"); 
           
        client1.payCash(70);
        client2.deposit(100);
        client3.deposit(500);
        client2.withdraw(20);
        
        System.out.println(client2);
        System.out.println(client3);
    }
}
class Client {
	protected String name;
	protected String ID;
	protected static String address;		
	public Client(String name, String ID, String address) {
		this.name = name;
		this.ID = ID;
		this.address = address;
	}		
	public String returnName() {
		return this.name;
	}	
	public String returnID() {
		return this.ID;
	}
}
class CashClient extends Client {		
	public CashClient(String name, String ID) {
		super(name, ID, address);	
	}
	public CashClient(String name, String ID, String address) {
		super(name, ID, address);	
	}
	public void payCash(int sum) {
		System.out.println(this.name + "(" + this.ID + "): Amount paid " + sum + " euros.");		
	}
}
class AccountClient extends Client {
	private double balance = 0;
	public AccountClient(String name, String ID) {
		super(name, ID, address);	
	}
	public AccountClient(String name, String ID, String address) {
		super(name, ID, address);	
	}
	public String toString() {
		return this.name + "(" + this.ID + "): " + this.balance;
	}
	public void deposit(double number) {
		this.balance = this.balance + number;
	}	
	public void withdraw(double number) {
		this.balance = this.balance - number;
	}	
}