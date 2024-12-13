package util.mapper;

import dto.EmployeeDto;
import model.Employee;
import model.EmployeeStatus;
import util.PasswordUtil;

public class EmployeeConverter {

    public static Employee dtoToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setUsername(employeeDto.getUsername());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(PasswordUtil.encryptPassword(employeeDto.getPassword()));
        employee.setBranch(employeeDto.getBranch());
        employee.setUsersRole(employeeDto.getUsersRole());
        employee.setPosition(employeeDto.getPosition());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setStatus(EmployeeStatus.ACTIVE);
        employee.setPhoneNumber(employeeDto.getPhone());
        return employee;
    }

}
