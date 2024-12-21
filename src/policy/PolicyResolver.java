package policy;

import model.Customer;
import model.Employee;

import java.util.HashMap;
import java.util.Map;

public class PolicyResolver {

    private static final Map<Class<?>, Policy<?>> policies = new HashMap<>();

    static{
        policies.put(Customer.class, new CustomerPolicy());
        policies.put(Employee.class, new EmployeePolicy());
    }
    @SuppressWarnings("unchecked")
    public static <T> Policy<T> getPolicy(Class<T> resourcesClass){
        return (Policy<T>) policies.get(resourcesClass);
    }

}
