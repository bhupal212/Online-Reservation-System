import javax.swing.*;
import java.awt.*;

public class CancellationPanel extends JPanel {
    public CancellationPanel(JFrame parentFrame) {
        setLayout(new GridLayout(3, 2));

        JLabel pnrLabel = new JLabel("PNR Number:");
        JTextField pnrField = new JTextField();
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");

        submitButton.addActionListener(e -> {
            String pnr = pnrField.getText();
            String reservationDetails = ReservationService.getReservationDetails(pnr);
            if (reservationDetails != null) {
                int confirm = JOptionPane.showConfirmDialog(this, reservationDetails + "\nDo you want to cancel this reservation?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    ReservationService.cancelReservation(pnr);
                    JOptionPane.showMessageDialog(this, "Reservation cancelled successfully.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No reservation found with the provided PNR.");
            }
        });

        backButton.addActionListener(e -> parentFrame.setContentPane(new MainPanel(parentFrame, new UserService())));

        add(pnrLabel);
        add(pnrField);
        add(submitButton);
        add(backButton);
    }
}
