import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class PhoneBook {
    private ArrayList<PhoneEntry> phoneBook;    //declare an array

    PhoneBook() {
        phoneBook = new ArrayList<>();

        String firstName;
        String lastName;
        String phoneNumber;

        Faker faker = new Faker();

        for (int i = 0; i < 5; i++) {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            phoneNumber = faker.numerify("(###)###-####");

            phoneBook.add(new PhoneEntry(firstName, lastName, phoneNumber));
        }
    }

    void AddEntry(String firstName, String lastName, String phoneNumber) {
        phoneBook.add(new PhoneEntry(firstName, lastName, phoneNumber));
    }

    void SaveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("phonebook.txt"));
            for (PhoneEntry p : phoneBook) {
                writer.write(p.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<PhoneEntry> getPhoneBook() {
        return phoneBook;
    }
}