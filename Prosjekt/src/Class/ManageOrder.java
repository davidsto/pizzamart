package Class;

public class ManageOrder {
	
	public static Customer addNewCustomer(String forename, String lastname, String adress, String postcode, String phone){
		return new Customer(forename, lastname, phone, adress, postcode);
	}
	
	public static Order addNewOrder(Customer customer){
		return new Order(customer);
	}
	
	public static void addProductToOrder(Order order, Product product, int quantity){
		order.addProductToOrder(product, quantity);
	}
	
	public static void setOrderIntoDatabase(Order order){
		order.addOrderToDatabase();
	}
	

}
