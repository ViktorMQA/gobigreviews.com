package utils;

import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {

	public static void dataWriter(String filePath, String text){
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(text);
			System.out.println("Файл записано в: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
