package view.employee;

import model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class EmployeeListingWindow extends JFrame {

    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private String[] columns = {"Id", "Username", "Email", "Phone Number", "Status", "Position", "Department",
            "Confirmed at", "Created at", "Updated at", "User Role", "Branch", "Created by", "Updated by"};
    private JPanel buttonPanel;
    private JButton createButton;
    private JButton updateButton;
    private JButton deleteButton;

    public EmployeeListingWindow() {
        initializeComponents();
        designFrame();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.setTitle("Employee List Window");
        this.setSize(1300, 500);
        this.setLayout(new BorderLayout());

        this.tableModel = new DefaultTableModel(null, this.columns);
        this.employeeTable = new JTable(this.tableModel);

        // Enable auto-resize for dynamic column adjustment
        this.employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

        // Adjust column widths to fit content
        this.employeeTable.setPreferredScrollableViewportSize(this.employeeTable.getPreferredSize());

        this.scrollPane = new JScrollPane(this.employeeTable);

        this.buttonPanel = new JPanel();
        this.createButton = new JButton("Create");
        this.updateButton = new JButton("Update");
        this.deleteButton = new JButton("Delete");
    }


    private void designFrame() {
        this.add(scrollPane, BorderLayout.CENTER);
        this.buttonPanel.setLayout(new GridLayout(1, 3));
        this.buttonPanel.add(createButton);
        this.buttonPanel.add(updateButton);
        this.buttonPanel.add(deleteButton);

        this.add(scrollPane);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

}
