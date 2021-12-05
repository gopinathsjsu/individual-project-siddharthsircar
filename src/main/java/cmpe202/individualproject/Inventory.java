package cmpe202.individualproject;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	static Inventory inventory;

	HashMap<String, ItemInterface> stock = new HashMap<>();
	// TODO
	Map<String, Integer> categoryCap = Map.of("Essential", 3, "Luxury", 4, "Misc", 6);

	private Inventory() {

	}

	public static Inventory getInstance() {
		if (inventory == null) {
			inventory = new Inventory();
		}
		return inventory;
	}

	public HashMap<String, ItemInterface> getStock() {
		return stock;
	}

	public void setStock(HashMap<String, ItemInterface> stock) {
		this.stock = stock;
	}

	public Map<String, Integer> getCategoryCap() {
		return categoryCap;
	}

	public void setCategoryCap(HashMap<String, Integer> categoryCap) {
		this.categoryCap = categoryCap;
	}
}

