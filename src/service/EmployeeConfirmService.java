package service;
import dao.abs.employee.EmployeeDao;
import dao.abs.employee.EmployeeDaoImpl;
import model.Employee;

public class EmployeeConfirmService {
    private EmployeeDao employeeDao;

    public EmployeeConfirmService(){
        this.employeeDao = new EmployeeDaoImpl();
    }

    public void confirm(Employee employee){
        this.employeeDao.confirmByEmp(employee);
    }
}
