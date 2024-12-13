package policy;

import model.Account;
import model.Employee;

import java.util.List;

public interface Policy<T> {
    boolean canView(T resource, Employee loginUser);
    List<T> canListing(List<T> resources, Employee loginUser);
    boolean canEdit(T resource, Employee loginUser); // to render upadate view
    boolean canUpdate(T resource, Employee loginUser);
    boolean canNew(T resource, Employee loginUser); // to render create view
    boolean canCreate(T resource, Employee loginUser);
    boolean canDelete(T resource, Employee loginUser); // to render destory view
    boolean canDestory(T resource, Employee loginUser);

}
