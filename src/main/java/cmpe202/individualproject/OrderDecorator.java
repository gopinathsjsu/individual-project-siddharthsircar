package cmpe202.individualproject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class OrderDecorator implements OrderInterface {
	Order order;

	public OrderDecorator(Order order) {
		this.order = order;
	}
	
	public void placeOrder() {
		boolean errorCap = false;
		boolean errorQty = false;
		HashSet<String> errorCapItems = new HashSet<>();
		HashSet<String> errorQtyItems = new HashSet<>();
		List<Items> cart = order.getCart();

		HashMap<String, Integer> categoryCount = new HashMap<>();
		HashMap<String, ItemInterface> inventory = Inventory.getInstance().getStock();
		Map<String, Integer> categoryCap = Inventory.getInstance().getCategoryCap();

		for (Items item : cart) {
			item.setCategory(inventory.get(item.getItem()).getCategory());
			String category = item.getCategory();
			if(item.getQuantity() > inventory.get(item.getItem()).getQuantity()) {
				errorQty = true;
				errorQtyItems.add(item.getItem());
			}
			categoryCount.put(category, categoryCount.getOrDefault(category, 0) + item.getQuantity());
		}

		for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
			if (entry.getValue() >= categoryCap.get(entry.getKey())) {
				errorCap = true;
				for (Items item : cart) {
					if (item.getCategory().equals(entry.getKey())) {
						errorCapItems.add(item.getItem());
					}
				}
			}
		}
		
		if(errorQty) {
			generateErrorFile("Insufficient Quantities for: ", errorQtyItems);
			System.out.println("Insufficient Quantities for: " + errorQtyItems);
		}
		else if (errorCap) {
			generateErrorFile("Please correct quantities for: ", errorCapItems);
			System.out.println("Please correct quantities for: " + errorCapItems);
		}
		else order.placeOrder();
	}

	public void generateErrorFile(String errorMsg, HashSet<String> errorItems) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("error.txt", "UTF-8");
			writer.println(errorMsg);
			writer.println(errorItems);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initCart() {
		// TODO Auto-generated method stub
		try {
			order.initCart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
