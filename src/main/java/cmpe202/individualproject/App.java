package cmpe202.individualproject;

import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;

public class App {
	public static void main(String[] args) throws Exception {		
		ItemsAdapter itemsAdapter = new ItemsAdapter();
		Cards cards = Cards.getInstance();
		OrderInterface order = new OrderDecorator(new Order());				
		try {
			cards.initCard();
			itemsAdapter.initializeInventory();
			order.initCart();
			order.placeOrder();
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
