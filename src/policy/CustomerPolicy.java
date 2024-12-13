package policy;

import model.Customer;
import model.Employee;

import java.util.List;

public class CustomerPolicy implements   Policy<Customer>{

    @Override
    public boolean canView(Customer resource, Employee loginUser) {
        return loginUser.isAdmin() || loginUser.isEditor() || loginUser.isViewer();
    }

    @Override
    public List<Customer> canListing(List<Customer> resources, Employee loginUser) {
        return null;
    }

    @Override
    public boolean canEdit(Customer resource, Employee loginUser) {
        return loginUser.isAdmin() || (loginUser.isEditor() && loginUser.equals(resource.getCreatedBy()));
    }

    @Override
    public boolean canUpdate(Customer resource, Employee loginUser) {
        return false;
    }

    @Override
    public boolean canNew(Customer resource, Employee loginUser) {
        return this.canCreate(resource, loginUser);
    }


    @Override
    public boolean canCreate(Customer resource, Employee loginUser) {
        return loginUser.isAdmin();
    }

    @Override
    public boolean canDelete(Customer resource, Employee loginUser) {
        return loginUser.isAdmin() || loginUser.isEditor();
    }

    @Override
    public boolean canDestory(Customer resource, Employee loginUser) {
        return false;
    }
}
