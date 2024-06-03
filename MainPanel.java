import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JFrame parentFrame;
    private UserService userService;

    public MainPanel(JFrame parentFrame, UserService userService) {
        this.parentFrame = parentFrame;
        this.userService = userService;
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JLabel loginIdLabel = new JLabel("Login ID:");
        JTextField loginIdField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String loginId = loginIdField.getText();
            String password = new String(passwordField.getPassword());
            if (userService.login(loginId, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                navigateToMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login ID or password.");
            }
        });

        loginPanel.add(loginIdLabel);
        loginPanel.add(loginIdField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        add(loginPanel, BorderLayout.CENTER);
    }

    private void navigateToMenu() {
        JPanel menuPanel = new JPanel(new GridLayout(3, 1));
        JButton reservationButton = new JButton("Make a Reservation");
        JButton cancellationButton = new JButton("Cancel a Reservation");
        JButton exitButton = new JButton("Exit");

        reservationButton.addActionListener(e -> parentFrame.setContentPane(new ReservationPanel(parentFrame)));
        cancellationButton.addActionListener(e -> parentFrame.setContentPane(new CancellationPanel(parentFrame)));
        exitButton.addActionListener(e -> System.exit(0));

        menuPanel.add(reservationButton);
        menuPanel.add(cancellationButton);
        menuPanel.add(exitButton);

        parentFrame.setContentPane(menuPanel);
        parentFrame.revalidate();
    }
}
