package view.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeWindow extends JFrame {
    private JLabel titleLabel;
    private JPanel buttonPanel;
    private JButton accountManagementBtn;
    private JButton employeeManagementBtn;
    private JButton transactionManagementBtn;



    private JButton cardManagementBtn;

    public HomeWindow(){
        initComponent();
    }

    private void initComponent() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setLayout(new BorderLayout(20, 20));
        titleLabel = new JLabel("Home Page", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        this.add(titleLabel, BorderLayout.NORTH);
        this.buttonPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        this.accountManagementBtn = new JButton("Account Management");
        this.employeeManagementBtn = new JButton("Employee Management");
        this.transactionManagementBtn = new JButton("Transaction Management");
        this.cardManagementBtn = new JButton("Card Management");

        buttonPanel.add(createButton(this.accountManagementBtn));
        buttonPanel.add(createButton(this.employeeManagementBtn));
        buttonPanel.add(createButton(this.cardManagementBtn));
        buttonPanel.add(createButton(this.transactionManagementBtn));

        this.add(buttonPanel, BorderLayout.CENTER);
        JLabel footerLabel = new JLabel("Select an option to manage", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        this.add(footerLabel, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static JButton createButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        return button;
    }

    public void setCardManagementBtnAction(ActionListener e){
        this.cardManagementBtn.addActionListener(e);
    }

    public void setAccountManagementBtnAction(ActionListener e) {
        this.accountManagementBtn.addActionListener(e);
    }


    public void setEmployeeManagementBtnAction(ActionListener e) {
        this.employeeManagementBtn.addActionListener(e);
    }

    public void setTransactionManagementBtn(ActionListener e) {
        this.transactionManagementBtn.addActionListener(e);
    }
}
