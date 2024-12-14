package view.card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CardCreateWindow extends JFrame {
    private JLabel titleLabel;
    private JLabel numberLBL;
    private JLabel cardTypeLBL;
    private JLabel ExpireDateLBL;
    private JLabel SecurityCodeLBL;

    private JTextField numberTF;
    private JComboBox<String> cardTypeTF;
    private JFormattedTextField ExpireDateTF;
    private JTextField SecurityCodeTF;

    private JButton createBtn;
    private JButton cancelBtn;

    public CardCreateWindow(){
        initializeComponent();
        configureLayout();
        addComponentsToUI();
        this.setTitle("Card Inserting");
        this.setSize(500, 315);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void initializeComponent(){
        this.titleLabel = new JLabel("Adding Payment Method");
        this.titleLabel.setFont(new Font("Arial", Font.BOLD,18));
        this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.numberLBL = new JLabel("Number:");
        this.cardTypeLBL = new JLabel("Card Type:");
        this.ExpireDateLBL = new JLabel("Expire Date:");
        this.SecurityCodeLBL = new JLabel("Security Code:");

        this.numberTF = new JTextField(20);
        this.cardTypeTF = new JComboBox<>(new String[]{"PREPAID", "DEBIT", "CREDIT"});
        this.SecurityCodeTF = new JTextField(20);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.setLenient(false); //for invalid date
        this.ExpireDateTF = new JFormattedTextField(dateFormat);
        this.ExpireDateTF.setColumns(7);

        this.createBtn = new JButton("Create");
        this.cancelBtn = new JButton("Cancel");
        addCancelButtonAction();
    }

    private void configureLayout(){
        this.setLayout(new GridBagLayout());
    }
    private void addComponentsToUI(){
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets= new Insets(10,10,10,10);
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.anchor = GridBagConstraints.WEST;

        gb.gridwidth = 2;
        gb.gridx= 0;
        this.add(titleLabel,gb);

        gb.gridwidth = 1;
        addRow(numberLBL,numberTF,gb,1);
        addRow(cardTypeLBL,cardTypeTF,gb,2);
        addRow(ExpireDateLBL,ExpireDateTF,gb,3);
        addRow(SecurityCodeLBL,SecurityCodeTF,gb,4);

        gb.gridx = 0;
        gb.gridy = 10;
        gb.gridwidth = 1;
        this.add(createBtn,gb);

        gb.gridx = 1;
        this.add(cancelBtn,gb);

    }
    private void addRow(JLabel label, JComponent component, GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        this.add(label, gbc);

        gbc.gridx = 1;
        this.add(component, gbc);
    }
    private void addCancelButtonAction() {
        this.cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
    }
    private void closeWindow() {
        this.dispose();
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JLabel getNumberLBL() {
        return numberLBL;
    }

    public void setNumberLBL(JLabel numberLBL) {
        this.numberLBL = numberLBL;
    }

    public JLabel getCardTypeLBL() {
        return cardTypeLBL;
    }

    public void setCardTypeLBL(JLabel cardTypeLBL) {
        this.cardTypeLBL = cardTypeLBL;
    }

    public JLabel getExpireDateLBL() {
        return ExpireDateLBL;
    }

    public void setExpireDateLBL(JLabel expireDateLBL) {
        ExpireDateLBL = expireDateLBL;
    }

    public JLabel getSecurityCodeLBL() {
        return SecurityCodeLBL;
    }

    public void setSecurityCodeLBL(JLabel securityCodeLBL) {
        SecurityCodeLBL = securityCodeLBL;
    }

    public JTextField getNumberTF() {
        return numberTF;
    }

    public void setNumberTF(JTextField numberTF) {
        this.numberTF = numberTF;
    }

    public JComboBox getCardTypeTF() {
        return cardTypeTF;
    }

    public void setCardTypeTF(JComboBox cardTypeTF) {
        this.cardTypeTF = cardTypeTF;
    }

    public JFormattedTextField getExpireDateTF() {
        return ExpireDateTF;
    }

    public void setExpireDateTF(JFormattedTextField expireDateTF) {
        ExpireDateTF = expireDateTF;
    }

    public JTextField getSecurityCodeTF() {
        return SecurityCodeTF;
    }

    public void setSecurityCodeTF(JTextField securityCodeTF) {
        SecurityCodeTF = securityCodeTF;
    }

    public JButton getCreateBtn() {
        return createBtn;
    }

    public void setCreateBtn(JButton createBtn) {
        this.createBtn = createBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

}
