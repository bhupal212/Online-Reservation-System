import javax.swing.*;

public class main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Online Reservation System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            UserService userService = new UserService();
            MainPanel mainPanel = new MainPanel(frame, userService);

            frame.setContentPane(mainPanel);
            frame.setVisible(true);
        });
    }
}
