package view.otp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OTPConfirmationForm extends JFrame {

    private JPanel mainPanel;
    private JLabel instructionLabel;
    private JLabel messageLabel;
    private JTextField otpField;
    private JButton confirmButton;
    private JButton resendButton;

    public OTPConfirmationForm() {
        initializeUI();
        configureFrame();
    }

    private void initializeUI() {
        // Initialize components
        mainPanel = new JPanel(new GridBagLayout());
        instructionLabel = new JLabel("Enter the OTP sent to your email:", JLabel.CENTER);
        messageLabel = new JLabel(" ", JLabel.CENTER); // Space for consistent layout even when empty
        otpField = new JTextField(20);
        confirmButton = new JButton("Confirm OTP");
        resendButton = new JButton("Resend OTP");

        // Add components to main panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Instruction label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(instructionLabel, gbc);

        // OTP field
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(otpField, gbc);

        // Confirm button
        gbc.gridy = 2;
        gbc.gridx = 0;
        mainPanel.add(confirmButton, gbc);

        // Resend button
        gbc.gridx = 1;
        mainPanel.add(resendButton, gbc);

        // Add main panel and message label
        add(mainPanel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);
    }

    private void configureFrame() {
        setTitle("OTP Confirmation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on screen
        setResizable(false);
        setVisible(true);
    }

    // Public methods to interact with the form
    public String getOtp() {
        return otpField.getText().trim();
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    public void setConfirmButtonListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

    public void setResendButtonListener(ActionListener listener) {
        resendButton.addActionListener(listener);
    }

    public void clearOtpField() {
        otpField.setText("");
    }
}
