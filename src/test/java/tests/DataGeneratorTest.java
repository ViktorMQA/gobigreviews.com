package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import net.datafaker.Faker;
import org.testng.annotations.Test;
import utils.DataWriter;

@Epic("User registration")
@Feature("Registration Page")
public class DataGeneratorTest {

	Faker faker = new Faker();

	public String firstName;
	public String lastName;
	public String fullName;
	public String email;
	public String address;
	public String companyName;
	public Timestamp birthDay;
	public String randomDigits;
	public String randomText;

	@Test
	public void displayData(){

		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		fullName = faker.name().fullName();
		email = faker.internet().emailAddress();
		address = faker.address().fullAddress();
		companyName = faker.company().name();
		birthDay = faker.date().birthday();
		randomDigits = faker.number().digits(10);
		randomText = faker.lorem().sentence(100);


		DataWriter.dataWriter("src/test/resources/generatedFile/file.txt", randomText);


		System.out.println(
				"the first name: " + firstName
		);
		System.out.println(
				"the last name: " + lastName
		);
		System.out.println(
				"full name: " + fullName
		);
		System.out.println(
				"Email: " + email
		);
		System.out.println(
				"address: " + address
		);
		System.out.println(
				"companyName: " + companyName
		);
		System.out.println(
				"birthDay: " + birthDay
		);
		System.out.println(
				"randomDigits: " + randomDigits
		);
		System.out.println(
				"randomText: " + randomText
		);

	}

}
