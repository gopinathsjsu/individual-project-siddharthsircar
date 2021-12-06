package cmpe202.individualproject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Cards {
	private static Cards cards;
	private String HEADER = "Cards";
	private HashSet<String> cardsList = new HashSet<>();

	private Cards() {

	}

	public static Cards getInstance() {
		if (cards == null) {
			cards = new Cards();
		}
		return cards;
	}

	public void initCard() {
		try (CSVReader csvReader = new CSVReader(new FileReader(
				System.getProperty("user.dir") + ConfigReader.INPUT_DIR + ConfigReader.CARDS_FILE + ".csv"));) {
			String[] values = null;
			this.HEADER = csvReader.readNext()[0];
			while ((values = csvReader.readNext()) != null) {
				cardsList.add(values[0]);
			}
			System.out.println("Existing Cards: " + cardsList);
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addCard(String cardNumber) {
		cardsList.add(cardNumber);
		System.out.println("Cards: " + cardsList);
		File file = new File(
				System.getProperty("user.dir") + ConfigReader.INPUT_DIR + ConfigReader.CARDS_FILE + ".csv");

		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			String[] header = { this.HEADER };
			writer.writeNext(header);
			for(String card: this.cardsList) {
				writer.writeNext(new String[] {card});
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
