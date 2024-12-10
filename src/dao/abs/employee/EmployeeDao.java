package dao.abs.employee;
import dao.AbstractDao;
import model.Employee;

public abstract class EmployeeDao extends AbstractDao<Employee> {
    public abstract Employee findByName(String name);
    public abstract boolean isEmailExists(String email);
    public abstract boolean isPhoneExists(String phoneNumber);
    public abstract boolean isUsernameExists(String username);
    public abstract Employee getEmployeeByEmployeeEmail(String email);
    public abstract Employee validateEmployee(String username,String password);
    public abstract void updateLoginToken(Employee employee);
    public abstract void validateLoginToken(Employee employee);
    public abstract void setConfimedAt(Employee employee);
    public abstract void confirmByEmp(Employee employee);
}
 