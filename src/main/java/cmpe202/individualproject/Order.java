package cmpe202.individualproject;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

public class Order implements OrderInterface{
	List<Items> cart = new ArrayList<>();
	Float totalPrice = 0.0f;
	String cardNumber;
	
	public Order(List<Items> cart, Float totalPrice, String cardNumber) {
		super();
		this.cart = cart;
		this.totalPrice = totalPrice;
		this.cardNumber = cardNumber;
	}
	
	public Order() {
		
	}
	
	public List<Items> getCart() {
		return cart;
	}

	public void setCart(List<Items> cart) {
		this.cart = cart;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void initCart() {
		try (CSVReader csvReader = new CSVReader(new FileReader("..\\..\\resources\\SampleFiles\\Input2 - Sheet1.csv"));) {
			String[] values = null;
			csvReader.readNext();
			while ((values = csvReader.readNext()) != null) {
				Items item = new Items(values[0], Integer.valueOf(values[1]));
				cart.add(item);
				cardNumber =  values[2];
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void placeOrder() {
		HashMap<String, ItemInterface> stock = Inventory.getInstance().getStock();
		for(Items item: cart) {
			this.totalPrice += stock.get(item.getItem()).getPrice();
		}
		Cards.getInstance().addCard(cardNumber);
		System.out.println("Order Placed");
		System.out.println("Amount Paid: " + this.totalPrice);
	}
}
