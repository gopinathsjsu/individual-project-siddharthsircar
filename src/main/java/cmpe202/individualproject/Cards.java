package cmpe202.individualproject;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Cards {
	private static Cards cards;
	private String header = "Cards";
	private HashSet<String> cardsList = new HashSet<>();
	
	private Cards() {
		
	}
	
	public static Cards getInstance() {
		if(cards == null) {
			cards = new Cards();
		}
		return cards;
	}
	
	public void initCard() {
		try (CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Siddharth Sircar\\eclipse-workspace\\MarketPlaceIndividualProject\\resources\\SampleFiles\\Cards - Sheet1.csv"));) {
			String[] values = null;
			this.header = csvReader.readNext()[0];
			while ((values = csvReader.readNext()) != null) {
				cardsList.add(values[0]);
			}
			
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addCard(String cardNumber)
	{
	    cardsList.add(cardNumber);
	    System.out.println("Cards: " + cardsList);
	}
}
