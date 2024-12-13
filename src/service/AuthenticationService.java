package service;

import dao.abs.employee.EmployeeDaoImpl;
import exception.AutheticationFailException;
import model.Employee;
import util.PasswordUtil;
import util.TokenUtil;

import java.util.Date;

public class AuthenticationService {

    public static Employee currentUser;

    public EmployeeDaoImpl employeeDao;

    public AuthenticationService(){
        this.employeeDao = new EmployeeDaoImpl();
    }

    public void authenticate() throws AutheticationFailException {
        this.employeeDao.validateLoginToken(currentUser);
    }

    public void loginWithUsername(String username, String password) throws Exception {
        password = PasswordUtil.encryptPassword(password);
        Employee employee = this.employeeDao.validateEmployee(username, password);
        if(employee!=null){
            currentUser = employee;
            String tokenInfo = currentUser.getUsername()+ new Date().toString();
            String loginToken = TokenUtil.encrypteToken(tokenInfo);
            currentUser.setLoginToken(loginToken);
            this.employeeDao.updateLoginToken(currentUser);
        }else{
            throw new Exception("Username or Password Incorrect");
        }

    }

}
