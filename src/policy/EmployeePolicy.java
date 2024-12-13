package policy;

import model.Customer;
import model.Employee;

import java.util.List;

public class EmployeePolicy implements Policy<Employee>{
    @Override
    public boolean canView(Employee resource, Employee loginUser) {
        return false;
    }

    @Override
    public List<Employee> canListing(List<Employee> resources, Employee loginUser) {
        return null;
    }

    @Override
    public boolean canEdit(Employee resource, Employee loginUser) {
        return false;
    }

    @Override
    public boolean canUpdate(Employee resource, Employee loginUser) {
        return false;
    }

    @Override
    public boolean canNew(Employee resource, Employee loginUser) {
        return this.canCreate(resource, loginUser);
    }

    @Override
    public boolean canCreate(Employee resource, Employee loginUser) {
        return loginUser.isAdmin();
    }

    @Override
    public boolean canDelete(Employee resource, Employee loginUser) {
        return false;
    }

    @Override
    public boolean canDestory(Employee resource, Employee loginUser) {
        return false;
    }
}
