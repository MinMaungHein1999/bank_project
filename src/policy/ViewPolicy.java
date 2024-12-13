package policy;

import model.Employee;

public interface ViewPolicy<T> {
    boolean canRenderPage(T page, Employee loginUser);
}
