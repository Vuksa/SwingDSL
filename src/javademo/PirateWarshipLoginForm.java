package javademo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

import static java.awt.EventQueue.invokeLater;

public class PirateWarshipLoginForm extends JFrame {

    private JPanel contentPanel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        invokeLater(() -> {
            new PirateWarshipLoginForm();
        });
    }

    /**
     * Create the frame.
     */
    public PirateWarshipLoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Pirate Warships");
        setBounds(new Rectangle(0, 0, 640, 400));
        setResizable(false);
        setLocationRelativeTo(null);

        contentPanel = new JPanel();
        contentPanel.setBounds(new Rectangle(0, 0, 640, 400));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            if (validateUser(username, password)) {
                JOptionPane.showMessageDialog(contentPanel, "Login successful.", "Information", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(contentPanel, "Wrong username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                Thread.interrupted();
            }
        });
        loginBtn.setBorder(new LineBorder(new Color(0, 0, 255), 1, true));
        loginBtn.setBounds(10, 211, 115, 23);
        contentPanel.add(loginBtn);

        JButton registrationBtn = new JButton("Registration");
        registrationBtn.setBorder(new LineBorder(new Color(0, 0, 255), 1, true));
        registrationBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(contentPanel, "Registration screen not available.", "Information", JOptionPane.INFORMATION_MESSAGE);
            Thread.interrupted();
        });
        registrationBtn.setBounds(10, 247, 115, 23);
        contentPanel.add(registrationBtn);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Arial Black", Font.BOLD, 11));
        usernameTextField.setOpaque(false);
        usernameTextField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        usernameTextField.setBounds(10, 91, 115, 20);
        contentPanel.add(usernameTextField);
        usernameTextField.setColumns(10);

        JLabel lblUser = new JLabel("User");
        lblUser.setFont(new Font("Ariel", Font.BOLD, 14));
        lblUser.setText("<html><font color='black'>User:</font></html>");
        lblUser.setBounds(10, 66, 46, 14);
        contentPanel.add(lblUser);

        passwordTextField = new JTextField();
        passwordTextField.setFont(new Font("Arial Black", Font.BOLD, 11));
        passwordTextField.setOpaque(false);
        passwordTextField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        passwordTextField.setBounds(10, 137, 115, 20);
        passwordTextField.setColumns(10);
        contentPanel.add(passwordTextField);

        JLabel lblPassword = new JLabel("");
        lblPassword.setFont(new Font("Ariel", Font.BOLD, 14));
        lblPassword.setText("<html><font color='black'>" + "Password:" + "</font></html>");
        lblPassword.setBounds(10, 113, 80, 23);

        contentPanel.add(lblPassword);

        JLabel background = new JLabel("");
        background.setHorizontalTextPosition(SwingConstants.CENTER);
        background.setHorizontalAlignment(SwingConstants.CENTER);
        background.setBounds(0, 0, 640, 400);
        ImageIcon icon = new ImageIcon(PirateWarshipLoginForm.class.getResource("../res/PirateShip.gif"));
        background.setIcon(icon);

        contentPanel.add(background);

        setContentPane(contentPanel);
    }

    private boolean validateUser(String username, String password) {
        return username.equals("user") && password.equals("user");
    }
}
