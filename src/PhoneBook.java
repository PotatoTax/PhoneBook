import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class PhoneBook {
    private ArrayList<PhoneEntry> phoneBook;    //declare an array

    private PhoneBook() {
        phoneBook = new ArrayList<>();

        phoneBook.add(new PhoneEntry( "Stew", "Pid", "(418)665-1223"));
        phoneBook.add(new PhoneEntry( "Ima", "Knob", "(860)399-3044"));
        phoneBook.add(new PhoneEntry("Ug", "Lee", "(815)439-9271"));
        phoneBook.add(new PhoneEntry(  "Ali", "Katt", "(312)223-1937"));
        phoneBook.add(new PhoneEntry(  "Jo", "King", "(913)883-2874"));
    }

    private void Search() {
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        boolean found;
        ArrayList<PhoneEntry> byFirstName = new ArrayList<>();
        System.out.print("\nFirst Name : ");
        firstName = scanner.nextLine().toUpperCase();
        if (!firstName.equalsIgnoreCase("none")) {
            for (PhoneEntry entry : phoneBook) {
                if (entry.getFirstName().equalsIgnoreCase(firstName))
                { byFirstName.add(entry); }
            }
        } else {
            byFirstName = phoneBook;
        }

        System.out.print("Last Name : ");
        lastName = scanner.nextLine().toUpperCase();
        found = false;
        if (!lastName.equalsIgnoreCase("none")) {
            for (PhoneEntry entry : byFirstName) {
                if (entry.getLastName().equalsIgnoreCase(lastName)) {
                    System.out.println("\n" + entry.getPhone());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("\n" + firstName + " " + lastName + " not found in directory");
            }
        }
        else {
            for (PhoneEntry entry : byFirstName) {
                System.out.println("\n" + entry.getFirstName() + " " + entry.getLastName() + " " + entry.getPhone());
            }
        }
    }

    private void AddEntry() {
        System.out.println("ADDING USER");
        System.out.print("First Name : ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.print("Last Name : ");
        String lastName = scanner.nextLine();
        System.out.println("Phone Number in format (000)000-0000 : ");
        String phoneNumber = scanner.nextLine();

        phoneBook.add(new PhoneEntry(firstName, lastName, phoneNumber));
        System.out.println("Entry Added :\n" + phoneBook.get(phoneBook.size()-1));
    }

    private void DeleteEntry() {
        System.out.println("DELETING USER");
        System.out.print("First Name : ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.print("First Name : ");
        String lastName = scanner.nextLine();

        for (PhoneEntry p : phoneBook) {
            if (p.getFirstName().equalsIgnoreCase(firstName)) {
                if (p.getLastName().equalsIgnoreCase(lastName)) {
                    phoneBook.remove(p);
                    break;
                }
            }
        }
    }
/*
    private void SaveToFile()
        throws IOException {
            String str = "Hello";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(str);

            writer.close();
        }
    }*/

    private void MainLoop()
    {
        while (true)
        {
            System.out.println("\n(1) Search for an entry\n(2) Add an entry\n(3) Delete an entry\n(4) Display all names\n(5) Save to file\n(6) Quit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Search();
                    break;
                case 2:
                    AddEntry();
                    break;
                case 3:
                    DeleteEntry();
                    break;
                case 4:
                    System.out.println(this);
                    break;
                case 6:
                    System.exit(1);
            }
        }
    }

    @Override
    public java.lang.String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (PhoneEntry p : phoneBook) {
            stringBuilder.append(p.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.MainLoop();
    }
}