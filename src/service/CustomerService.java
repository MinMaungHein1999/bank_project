package service;

import dao.abs.customer.CustomerDao;
import dao.abs.customer.CustomerDaoImpl;
import dto.CustomerDto;
import exception.UnauthorizationFailForResource;
import model.Customer;
import model.CustomerStatus;
import util.mapper.CustomerConverter;

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService() {
        this.customerDao = new CustomerDaoImpl();
    }

    public Customer createProcess (CustomerDto customerDto) throws UnauthorizationFailForResource {

        customerDto.setCustomerStatus(CustomerStatus.ACTIVE);
        Customer customer = CustomerConverter.dtoToCustoer(customerDto);
        AuthorizationService.isAuthorized(AuthenticationService.currentUser, customer, "create");
        customer.setCreatedBy(AuthenticationService.currentUser);
        customer.setUpdatedBy(AuthenticationService.currentUser);
        this.customerDao.create(customer);
        customer = this.customerDao.findByEmail(customer.getEmail());
        return customer;
    }
}
