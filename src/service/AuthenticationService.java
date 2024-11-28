package service;

import dao.abs.employee.EmployeeDaoImpl;
import model.Employee;

public class AuthenticationService {

    public static Employee currentUser;

    public EmployeeDaoImpl employeeDao;

    public AuthenticationService(){
        this.employeeDao = new EmployeeDaoImpl();
    }

    public void authenticate(){
        this.employeeDao.validateLoginToken(currentUser);
    }

    public void loginWithUsername(String username, String password) throws Exception {
        Employee employee = this.employeeDao.validateEmployee(username, password);
        if(employee!=null){
            currentUser = employee;
            this.employeeDao.updateLoginToken(currentUser);
        }else{
            throw new Exception("Username or Password Incorrect");
        }

    }

}
