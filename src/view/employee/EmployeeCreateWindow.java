package view.employee;

import dao.abs.user_roles.UserRoleDaoImpl;
import model.Branch;
import model.UsersRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeCreateWindow extends JFrame {

    private JLabel titleLabel;
    private JLabel userNameLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel phoneNumberLabel;
    private JLabel positionLabel;
    private JLabel departmentLabel;
    private JLabel selectUserRole;
    private JLabel selectBranch;
    private JComboBox<UsersRole> cbUserRoles;
    private JComboBox<Branch> cbBranches;
    private JTextField userNameTF;
    private JTextField emailTF;
    private JPasswordField passwordTF;
    private JPasswordField confirmPasswordTF;
    private JTextField phoneNumberTF;
    private JTextField positionTF;
    private JTextField departmentTF;


    private JButton createButton;
    private JButton cancelButton;

    public EmployeeCreateWindow() {
        initializeComponents();
        configureLayout();
        addComponentsToUI();
        this.setTitle("Create Employee");
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the window
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.titleLabel = new JLabel("Employee Registration");
        this.titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Labels and Text Fields
        this.userNameLabel = new JLabel("Username:");
        this.emailLabel = new JLabel("Email:");
        this.passwordLabel = new JLabel("Password:");
        this.confirmPasswordLabel = new JLabel("Confirm Password:");
        this.phoneNumberLabel = new JLabel("Phone Number:");
        this.positionLabel = new JLabel("Position:");
        this.departmentLabel = new JLabel("Department:");
        this.selectBranch = new JLabel("Select Branch:");
        this.selectUserRole = new JLabel("Select User Role:");

        this.userNameTF = new JTextField(20);
        this.emailTF = new JTextField(20);
        this.passwordTF = new JPasswordField(20);
        this.confirmPasswordTF = new JPasswordField(20);
        this.phoneNumberTF = new JTextField(20);
        this.cbUserRoles = new JComboBox<>();
        this.cbBranches = new JComboBox<>();
        this.positionTF = new JTextField(20);
        this.departmentTF = new JTextField(20);

        // Buttons
        this.createButton = new JButton("Create");
        this.cancelButton = new JButton("Cancel");
        addCancelButtonAction();
    }

    private void configureLayout() {
        this.setLayout(new GridBagLayout());
    }

    private void addComponentsToUI() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Title
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(titleLabel, gbc);

        // Labels and Fields
        gbc.gridwidth = 1;

        addRow(userNameLabel, userNameTF, gbc, 1);
        addRow(emailLabel, emailTF, gbc, 2);
        addRow(passwordLabel, passwordTF, gbc, 3);
        addRow(confirmPasswordLabel, confirmPasswordTF, gbc, 4);
        addRow(phoneNumberLabel, phoneNumberTF, gbc, 5);
        addRow(positionLabel, positionTF, gbc, 6);
        addRow(selectUserRole, cbUserRoles, gbc, 7);
        addRow(selectBranch, cbBranches, gbc, 8);
        addRow(departmentLabel, departmentTF, gbc, 9);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        this.add(createButton, gbc);

        gbc.gridx = 1;
        this.add(cancelButton, gbc);
    }

    private void addRow(JLabel label, JComponent component, GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        this.add(label, gbc);

        gbc.gridx = 1;
        this.add(component, gbc);
    }

    private void addCancelButtonAction() {
        this.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
    }

    public JComboBox<UsersRole> getCbUserRoles() {
        return cbUserRoles;
    }

    public void setCbUserRoles(JComboBox<UsersRole> cbUserRoles) {
        this.cbUserRoles = cbUserRoles;
    }

    private void closeWindow() {
        this.dispose();
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JComboBox<Branch> getCbBranches() {
        return cbBranches;
    }

    public void setCbBranches(JComboBox<Branch> cbBranches) {
        this.cbBranches = cbBranches;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JPasswordField getConfirmPasswordTF() {
        return confirmPasswordTF;
    }

    public void setConfirmPasswordTF(JPasswordField confirmPasswordTF) {
        this.confirmPasswordTF = confirmPasswordTF;
    }

    public JTextField getPhoneNumberTF() {
        return phoneNumberTF;
    }

    public void setPhoneNumberTF(JTextField phoneNumberTF) {
        this.phoneNumberTF = phoneNumberTF;
    }

    public JTextField getPositionTF() {
        return positionTF;
    }

    public void setPositionTF(JTextField positionTF) {
        this.positionTF = positionTF;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JTextField getDepartmentTF() {
        return departmentTF;
    }

    public void setDepartmentTF(JTextField departmentTF) {
        this.departmentTF = departmentTF;
    }

    public JPasswordField getPasswordTF() {
        return passwordTF;
    }

    public void setPasswordTF(JPasswordField passwordTF) {
        this.passwordTF = passwordTF;
    }

    public JTextField getEmailTF() {
        return emailTF;
    }

    public void setEmailTF(JTextField emailTF) {
        this.emailTF = emailTF;
    }

    public JTextField getUserNameTF() {
        return userNameTF;
    }

    public void setUserNameTF(JTextField userNameTF) {
        this.userNameTF = userNameTF;
    }
}
