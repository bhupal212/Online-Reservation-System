import javax.swing.*;
import java.awt.*;

public class ReservationPanel extends JPanel {
    public ReservationPanel(JFrame parentFrame) {
        setLayout(new GridLayout(8, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel trainNumberLabel = new JLabel("Train Number:");
        JTextField trainNumberField = new JTextField();
        JLabel trainNameLabel = new JLabel("Train Name:");
        JTextField trainNameField = new JTextField();
        JLabel classTypeLabel = new JLabel("Class Type:");
        JTextField classTypeField = new JTextField();
        JLabel dateOfJourneyLabel = new JLabel("Date of Journey (dd/mm/yyyy):");
        JTextField dateOfJourneyField = new JTextField();
        JLabel fromLabel = new JLabel("From:");
        JTextField fromField = new JTextField();
        JLabel toLabel = new JLabel("To:");
        JTextField toField = new JTextField();

        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(e -> {
            String name = nameField.getText();
            String trainNumber = trainNumberField.getText();
            String trainName = trainNameField.getText();
            String classType = classTypeField.getText();
            String dateOfJourney = dateOfJourneyField.getText();
            String from = fromField.getText();
            String to = toField.getText();

            String pnr = ReservationService.makeReservation(name, trainNumber, trainName, classType, dateOfJourney, from, to);
            JOptionPane.showMessageDialog(this, "Reservation successful! Your PNR is " + pnr);
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> parentFrame.setContentPane(new MainPanel(parentFrame, new UserService())));

        add(nameLabel);
        add(nameField);
        add(trainNumberLabel);
        add(trainNumberField);
        add(trainNameLabel);
        add(trainNameField);
        add(classTypeLabel);
        add(classTypeField);
        add(dateOfJourneyLabel);
        add(dateOfJourneyField);
        add(fromLabel);
        add(fromField);
        add(toLabel);
        add(toField);
        add(insertButton);
        add(backButton);
    }
}
