import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

class PhoneBook {
    private ArrayList<PhoneEntry> phoneBook;    //declare an array

    PhoneBook() {
        phoneBook = new ArrayList<>();

        String firstName;
        String lastName;
        String phoneNumber;

        Faker faker = new Faker(new Locale("en-US"));

        for (int i = 0; i < 500; i++) {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            phoneNumber = faker.numerify("(###)###-####");

            phoneBook.add(new PhoneEntry(firstName, lastName, phoneNumber));
        }
    }

    void AddEntry(String firstName, String lastName, String phoneNumber) {
        phoneBook.add(new PhoneEntry(firstName, lastName, phoneNumber));
    }

    ArrayList<PhoneEntry> getPhoneBook() {
        return phoneBook;
    }
}