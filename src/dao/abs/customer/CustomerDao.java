package dao.abs.customer;

import dao.AbstractDao;
import model.Customer;

public abstract class CustomerDao extends AbstractDao<Customer> {
    public abstract Customer findByName(String name);
    public abstract boolean isEmailExists(String email);
    public abstract boolean isPhoneExists(String phoneNumber);

}
