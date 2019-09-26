import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneBookGui implements ActionListener {
    private JButton searchForAnEntryButton;
    private JButton deleteAnEntryButton;
    private JButton displayAllEntriesButton;
    private JButton quitButton;
    private JButton saveToFileButton;
    private JButton addAnEntryButton;

    public
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
    }

    public static void main(String[] args) {
        PhoneBookGui app = new PhoneBookGui();
    }
}
