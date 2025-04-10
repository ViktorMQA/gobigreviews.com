package utils;
import java.util.Random;
import java.util.UUID;

public class DataGenerator {

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final int NAME_LENGTH = 8;
	private static final int PASSWORD_LENGTH = 12;
	private static final Random RANDOM = new Random();

	public static String generateRandomName() {
		StringBuilder name = new StringBuilder();
		name.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
		for (int i = 1; i < NAME_LENGTH; i++) {
			name.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
		}
		return name.toString();
	}

	public static String generateRandomEmail() {
		String domain = "@email.net";
		String localPart = "user" + RANDOM.nextInt(10000);
		return localPart + domain;
	}

	public static String generateRandomPassword() {
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			if (i % 3 == 0) {
				password.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
			} else if (i % 3 == 1) {
				password.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
			} else {
				password.append((char) (RANDOM.nextInt(15) + 33));
			}
		}
		return password.toString();
	}

}
