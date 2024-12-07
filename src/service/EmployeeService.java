package service;

import dao.abs.employee.EmployeeDao;
import dao.abs.employee.EmployeeDaoImpl;
import dto.EmployeeDto;
import model.Employee;
import util.mapper.EmployeeConverter;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(){
        this.employeeDao = new EmployeeDaoImpl();
    }

    public Employee createProcess(EmployeeDto employeeDto){
        Employee employee = EmployeeConverter.dtoToEmployee(employeeDto);
        employee.setCreatedBy(AuthenticationService.currentUser);
        employee.setUpdatedBy(AuthenticationService.currentUser);
        Employee createdEmployee = this.employeeDao.create(employee);
        return employee;
    }
}
