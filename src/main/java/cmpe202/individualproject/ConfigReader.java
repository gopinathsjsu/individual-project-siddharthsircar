package cmpe202.individualproject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String INPUT_DIR;
	public static String OUTPUT_DIR;
	public static String INPUT_FILE;
	public static String CARDS_FILE;
	/*
	 * This method loads all the framework specific configurations
	 * */
	public static void loadConfig() {
		Properties CONFIG = new Properties();
		try {
			FileInputStream cn = new FileInputStream(System.getProperty("user.dir") + "/Config/config.properties");
			CONFIG.load(cn);
			INPUT_DIR = CONFIG.getProperty("inputFileDirectory");
			OUTPUT_DIR = CONFIG.getProperty("outputFileDirectory");
			INPUT_FILE = CONFIG.getProperty("inputFileName");
			CARDS_FILE = CONFIG.getProperty("cardsFileName");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}