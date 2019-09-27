import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PhoneBookGui {
    private PhoneBook phoneBook;

    private JPanel rootPanel;

    private JButton refreshButton;
    private JButton enterButton;
    private JButton enterButton2;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNumberField;
    private JTextField firstNameDeleteField;
    private JTextField lastNameDeleteField;
    private JTextField firstNameSearchField;
    private JTextField lastNameSearchField;

    private JTable entryTable;

    private PhoneBookGui() {
        phoneBook = new PhoneBook();
        Refresh();

        ActionListener actionListener = e -> {
            if (e.getSource() == refreshButton) {
                Refresh();
            } else if (e.getSource() == enterButton) {
                AddEntry();
            } else if (e.getSource() == enterButton2) {
                DeleteEntry();
            }
        };

        refreshButton.addActionListener(actionListener);
        enterButton.addActionListener(actionListener);
        enterButton2.addActionListener(actionListener);
    }

    private void Refresh() {
        String firstName = firstNameSearchField.getText();
        String lastName = lastNameSearchField.getText();

        ArrayList<PhoneEntry> entries = new ArrayList<>();

        if (firstName.equals("") && lastName.equals("")) {
            entries.addAll(phoneBook.getPhoneBook());
        } else if (!firstName.equals("") && lastName.equals("")) {
            for (PhoneEntry p : phoneBook.getPhoneBook()) {
                if (p.getFirstName().startsWith(firstName)) {
                    entries.add(p);
                }
            }
        } else if (firstName.equals("")) {
            for (PhoneEntry p : phoneBook.getPhoneBook()) {
                if (p.getLastName().startsWith(lastName)) {
                    entries.add(p);
                }
            }
        } else {
            for (PhoneEntry p : phoneBook.getPhoneBook()) {
                if (p.getLastName().startsWith(lastName) && p.getFirstName().startsWith(firstName)) {
                    entries.add(p);
                }
            }
        }

        String[] firstNames = new String[entries.size()];
        String[] lastNames = new String[entries.size()];
        String[] phoneNumbers = new String[entries.size()];

        for (int i = 0; i < entries.size(); i++) {
            firstNames[i] = entries.get(i).getFirstName();
            lastNames[i] = entries.get(i).getLastName();
            phoneNumbers[i] = entries.get(i).getPhone();
        }

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("First", firstNames);
        tableModel.addColumn("Last", lastNames);
        tableModel.addColumn("Phone", phoneNumbers);

        entryTable.setModel(tableModel);
    }

    private void AddEntry() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();

        firstNameField.setText("");
        lastNameField.setText("");
        phoneNumberField.setText("");

        phoneBook.AddEntry(firstName, lastName, phoneNumber);
        Refresh();
    }

    private void DeleteEntry() {
        String firstName = firstNameDeleteField.getText();
        String lastName = lastNameDeleteField.getText();

        firstNameDeleteField.setText("");
        lastNameDeleteField.setText("");

        for (PhoneEntry p : phoneBook.getPhoneBook()) {
            if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
                phoneBook.getPhoneBook().remove(p);
                break;
            }
        }
        Refresh();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setContentPane(new PhoneBookGui().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
