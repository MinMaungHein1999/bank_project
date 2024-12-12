package service;

import dao.abs.employee.EmployeeDao;
import dao.abs.employee.EmployeeDaoImpl;
import dto.EmployeeDto;
import exception.AlreadyExistsException;
import exception.EmptyFieldException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeValidationService {

    private EmployeeDao employeeDao;

    public EmployeeValidationService() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    public void validate(EmployeeDto employeeDto) throws AlreadyExistsException, EmptyFieldException {
        List<String> errors = new ArrayList<>();
        checkRequiredField(employeeDto, errors);
        checkExist(employeeDto, errors);
    }

    private void checkExist(EmployeeDto employeeDto, List<String> errors) throws AlreadyExistsException{

        if (employeeDao.isUsernameExists(employeeDto.getUsername())) {
            errors.add("Username already exist.");
        }
        if (employeeDao.isEmailExists(employeeDto.getEmail())) {
            errors.add("Email already exists.");
        }
        if (employeeDao.isPhoneExists(employeeDto.getPhone())) {
            errors.add("Phone number already exists.");
        }
        if (!errors.isEmpty()) {
            throw new AlreadyExistsException(arrangedErrorMessages(errors));
        }


    }

    private void checkRequiredField(EmployeeDto employeeDto, List<String> errors) throws EmptyFieldException {
        if (employeeDto.getUsername().isEmpty()) {
            errors.add("Username can't be empty.");
        }
        if (employeeDto.getEmail().isEmpty()) {
            errors.add("Email can't be empty.");
        }
        if(employeeDto.getPhone().isEmpty()) {
            errors.add("Phone Number can't be empty.");
        }
        if (employeeDto.getPassword().isEmpty() || employeeDto.getConfirmPassword().isEmpty()) {
            errors.add("Password Field can't be empty.");
        }
        if (!errors.isEmpty()) {
            throw new EmptyFieldException(arrangedErrorMessages(errors));
        }

    }

    private String arrangedErrorMessages(List<String> errors) {
        String message = "";
        for (String s: errors) {
            message += s + "\n";
        }
        return message;
    }

}
