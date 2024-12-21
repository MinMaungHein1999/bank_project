package controller;

import dto.CustomerDto;
import dto.EmployeeDto;
import model.Customer;
import model.Employee;
import service.AuthorizationService;
import service.CustomerService;
import view.customer.CustomerCreatePage;

import javax.swing.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class CustomerCreateController extends BaseController{

    private static CustomerCreatePage page = new CustomerCreatePage();;
    private CustomerService customerService;

    public CustomerCreateController(){
        super(page);
        this.customerService = new CustomerService();
        page.getCreateBtn().addActionListener(e-> handleCreateBtnAction());
        page.getCancelBtn().addActionListener(e-> handleCancelBtnAction());

    }

    private void handleCancelBtnAction() {

    }

    private void handleCreateBtnAction() {
        CustomerDto customerDto = getCustomerInfo();
        try {
            Customer customer = this.customerService.createProcess(customerDto);
        }catch(Exception e){
            JOptionPane.showMessageDialog(page, e.getMessage(), "Fail", JOptionPane.INFORMATION_MESSAGE);
        }
        page.dispose();
        JOptionPane.showMessageDialog(page, "Employee Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private CustomerDto getCustomerInfo() {
        String firstName = page.getFirstnameTextField().getText();
        String lastName = page.getLastnameTextField().getText();
        Date dateOfBirth= (Date) page.getDatePanel().getModel().getValue();
        String nrc = page.getNrcTextField().getText();
        String phone = page.getPhoneTextField().getText();
        String email = page.getEmailTextField().getText();
        String address = page.getAddressTextField().getText();
        CustomerDto customerDto = new CustomerDto(firstName, lastName, dateOfBirth, nrc, phone, email,  address );
        return customerDto;
    }
}
