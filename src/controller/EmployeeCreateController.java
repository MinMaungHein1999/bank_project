package controller;

import dao.abs.branch.BranchDaoImpl;
import dao.abs.employee.EmployeeDao;
import dao.abs.employee.EmployeeDaoImpl;
import dao.abs.user_roles.UserRoleDaoImpl;
import dto.EmployeeDto;
import exception.AlreadyExistsException;
import exception.EmptyFieldException;
import exception.PasswordsDontMatchException;
import model.Branch;
import model.Employee;
import model.UsersRole;
import service.CheckPasswordsService;
import service.EmployeeService;
import service.EmployeeValidationService;
import view.employee.EmployeeCreateWindow;

import javax.swing.*;

public class EmployeeCreateController {
    private BranchDaoImpl branchDao;
    private UserRoleDaoImpl userRoleDao;
    private EmployeeCreateWindow window;
    private EmployeeService empService;
    private EmployeeValidationService empValidationService;
    private CheckPasswordsService checkPasswordsService;
    private EmployeeDao employeeDao;

    public EmployeeCreateController(){

        this.userRoleDao = new UserRoleDaoImpl();
        this.branchDao = new BranchDaoImpl();
        this.window = new EmployeeCreateWindow();
        this.empService = new EmployeeService();
        this.empValidationService = new EmployeeValidationService();
        this.checkPasswordsService = new CheckPasswordsService();
        this.employeeDao = new EmployeeDaoImpl();

        prepareFormData();
        addCreateBtnAction();
    }

    public void addCreateBtnAction(){
        this.window.getCreateButton().addActionListener(e -> createBtnAction());
    }

    private void createBtnAction() {
        EmployeeDto employeeDto =  getEmpInfo();
        try {
            this.empValidationService.validate(employeeDto);
            this.checkPasswordsService.isPasswordEquals(employeeDto.getPassword(), employeeDto.getConfirmPassword());
            Employee employee = this.empService.createProcess(employeeDto);
            this.window.dispose();
            JOptionPane.showMessageDialog(this.window, "Employee Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            new OtpController(employee);
        } catch (AlreadyExistsException | PasswordsDontMatchException | EmptyFieldException e) {
            JOptionPane.showMessageDialog(this.window, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private EmployeeDto getEmpInfo(){
        String username = this.window.getUserNameTF().getText();
        String email = this.window.getEmailTF().getText();
        String password = new String(this.window.getPasswordTF().getPassword());
        String confirmPassword = new String(this.window.getConfirmPasswordTF().getPassword());
        String phone = this.window.getPhoneNumberTF().getText();
        String department = this.window.getDepartmentTF().getText();
        Branch selectedBranch = (Branch)this.window.getCbBranches().getSelectedItem();
        UsersRole usersRole = (UsersRole)this.window.getCbUserRoles().getSelectedItem();
        String position = this.window.getPositionTF().getText();
        EmployeeDto employeeDto = new EmployeeDto(username, email, phone, password, confirmPassword, position, usersRole, selectedBranch, department);
        return employeeDto;
    }

    public void prepareFormData(){
        Branch[] branches = this.branchDao.getAll().toArray(new Branch[0]);
        UsersRole[] usersRolesArr = this.userRoleDao.getAll().toArray(new UsersRole[0]);

        for(Branch branch : branches){
            this.window.getCbBranches().addItem(branch);
        }
        for(UsersRole userRole : usersRolesArr) {
            this.window.getCbUserRoles().addItem(userRole);
        }
    }
}
