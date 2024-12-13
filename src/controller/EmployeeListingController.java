package controller;


import service.EmployeeListingService;
import view.employee.EmployeeListingWindow;

public class EmployeeListingController {

    private EmployeeCreateController employeeCreateController;
    private EmployeeListingWindow window;
    private EmployeeListingService employeeListingService;


    public EmployeeListingController() {
        this.window = new EmployeeListingWindow();
        this.employeeListingService = new EmployeeListingService();
        addCreateButton();
    }


    public void addCreateButton() {
        this.window.getCreateButton().addActionListener(e -> createButtonAction());
    }


    private void createButtonAction() {
        this.employeeCreateController = new EmployeeCreateController();
    }


}
