package view.card;

import view.employee.EmployeeCreateWindow;
import view.employee.EmployeeUpdateWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardListingWindow extends JFrame{
    private JTable CardTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private String[] columns = {"Id","number","card_type","expire_date","security_code","account_id"};
    private JPanel buttonPanel;
    private JButton createButton;
    private JButton updateButton;

    public CardListingWindow(){
        initializeComponents();
        designFrame();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents(){
        this.setTitle("Card List Window");
        this.setSize(800,500);
        this.setLayout(new BorderLayout());

        this.tableModel = new DefaultTableModel(null,this.columns);
        this.CardTable = new JTable(this.tableModel);

        TableColumn column = this.CardTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);

        this.scrollPane = new JScrollPane(this.CardTable);

        this.buttonPanel = new JPanel();
        this.createButton = new JButton("Create");
        this.updateButton = new JButton( "Update");

        addCreateButtonAction();
        addUpdateButtonAction();
    }
    private void designFrame() {
        this.add(scrollPane, BorderLayout.CENTER);
        this.buttonPanel.setLayout(new GridLayout(1, 2));
        this.buttonPanel.add(createButton);
        this.buttonPanel.add(updateButton);

        this.add(scrollPane);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    private void addCreateButtonAction() {
        this.createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CardCreateWindow();
            }
        });
    }
    private void addUpdateButtonAction() {
        this.updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CardUpdateWindow();
            }
        });
    }
}
