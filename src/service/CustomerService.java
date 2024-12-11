package service;

import dao.abs.customer.CustomerDao;
import dao.abs.customer.CustomerDaoImpl;
import dto.CustomerDto;
import model.Customer;
import util.mapper.CustomerConverter;

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService() {
        this.customerDao = new CustomerDaoImpl();
    }

    public Customer createProcess (CustomerDto customerDto){
        Customer customer = CustomerConverter.dtoToCustoer(customerDto);
        customer.setCreatedBy(AuthenticationService.currentUser);
        customer.setUpdatedBy(AuthenticationService.currentUser);
        this.customerDao.create(customer);
        //Customer createdCustomer = this.customerDao.
        return customer;
    }
}
