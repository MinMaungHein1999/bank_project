package util.mapper;

import model.Customer;
import dto.CustomerDto;


public class CustomerConverter {
    public static Customer dtoToCustoer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setNrc(customerDto.getNrc());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        return customer;

    }
}
