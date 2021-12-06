package cmpe202.individualproject;

import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;

public class App {
	private static ItemsAdapter itemsAdapter = new ItemsAdapter();
	private static Cards cards = Cards.getInstance();
	private static OrderInterface order = new OrderDecorator(new Order());
	public static void main(String[] args) throws Exception {		
		try {
			System.out.println("================ Welcome to the Marketplace!! ================");
			ConfigReader.loadConfig();
			cards.initCard();
			itemsAdapter.initializeInventory();
			order.initCart();
			order.placeOrder();
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Order Unsuccessful");
			e.printStackTrace();
		}
	}
}
