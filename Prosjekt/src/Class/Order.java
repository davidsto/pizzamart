package Class;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import Database.Database;

public class Order {
	
	private Customer customer;
	private HashMap<Product, Integer> products;
	private String status;
	private String idorder;
	
	public Order(Customer customer, HashMap<Product, Integer> products, String status){
		this.customer = customer;
		this.products = products;
		this.status = status;
	}
	
	public Order(Customer customer){
		this.customer = customer;
	}
	
	public void addOrderToDatabase(){
		try {
			Database db = Database.getDatabase();
			String query = "INSERT INTO orders (status) " +
			  			   "VALUES ('"+this.status + "')";
			db.insert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addProductToOrder(Product product, int quantity){
		products.put(product, quantity);
	}
	
	public void setStatus(String status){
		this.status = status;
		try {
			Database db = Database.getDatabase();
			String query = "INSERT INTO orders (status) " +
			  			   "VALUES ('"+this.status + ")";
			db.insert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
