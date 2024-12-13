package dao.abs.employee;
import dao.AbstractDao;
import exception.AutheticationFailException;
import model.Employee;

public abstract class EmployeeDao extends AbstractDao<Employee> {
    public abstract Employee findByName(String name);
    public abstract boolean isEmailExists(String email);
    public abstract boolean isPhoneExists(String phoneNumber);
    public abstract boolean isUsernameExists(String username);
    public abstract Employee getEmployeeByEmployeeEmail(String email);
    public abstract Employee validateEmployee(String username,String password);
    public abstract void updateLoginToken(Employee employee);
    public abstract Employee validateLoginToken(Employee employee)throws AutheticationFailException;
    public abstract void setConfimedAt(Employee employee);
    public abstract void confirmByEmp(Employee employee);
}
 