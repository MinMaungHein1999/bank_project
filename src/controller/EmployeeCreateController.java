package controller;

import dao.abs.branch.BranchDaoImpl;
import dao.abs.user_roles.UserRoleDaoImpl;
import dto.EmployeeDto;
import model.Branch;
import model.UsersRole;
import service.EmployeeService;
import view.employee.EmployeeCreateWindow;

public class EmployeeCreateController {
    private BranchDaoImpl branchDao;
    private UserRoleDaoImpl userRoleDao;
    private EmployeeCreateWindow window;
    private EmployeeService empService;

    public EmployeeCreateController(){

        this.userRoleDao = new UserRoleDaoImpl();
        this.branchDao = new BranchDaoImpl();
        this.window = new EmployeeCreateWindow();
        this.empService = new EmployeeService();
        prepareFormData();
        addCreateBtnAction();
    }

    public void addCreateBtnAction(){
        this.window.getCreateButton().addActionListener(e -> createBtnAction());
    }

    private void createBtnAction() {
        EmployeeDto employeeDto =  getEmpInfo();
        this.empService.createProcess(employeeDto);
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
