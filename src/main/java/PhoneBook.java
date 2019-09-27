import com.github.javafaker.Faker;

import java.util.ArrayList;

class PhoneBook {
    private ArrayList<PhoneEntry> phoneBook;    //declare an array

    PhoneBook() {
        phoneBook = new ArrayList<>();

        String firstName;
        String lastName;
        String phoneNumber;

        Faker faker = new Faker();

        for (int i = 0; i < 500000; i++) {
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