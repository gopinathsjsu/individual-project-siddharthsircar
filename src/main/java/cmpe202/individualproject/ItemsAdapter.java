package cmpe202.individualproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ItemsAdapter {
	public void initializeInventory() throws FileNotFoundException, IOException, CsvValidationException {
		Inventory inventory = Inventory.getInstance();
		try (CSVReader csvReader = new CSVReader(new FileReader(
				System.getProperty("user.dir") + ConfigReader.INPUT_DIR+ "Dataset - Sheet1.csv"));) {
			String[] values = null;
			csvReader.readNext();
			while ((values = csvReader.readNext()) != null) {
				String key = values[1];
				Stock stock = new Stock(values[0], values[1], Integer.valueOf(values[2]), Float.valueOf(values[3]));
				inventory.getStock().put(key, stock);
			}
			System.out.println("================ Current Stock ================");
			System.out.println("Items		Category		Quantity		Price");
			for (Map.Entry<String, ItemInterface> entry : inventory.getStock().entrySet()) {
				System.out.println(entry.getKey() + "		" + entry.getValue().getCategory() + "		"
						+ entry.getValue().getQuantity() + "		" + entry.getValue().getPrice());
			}
		}
	}
}
