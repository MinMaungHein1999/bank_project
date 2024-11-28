package controller;

import dao.abs.branch.BranchDaoImpl;
import dao.abs.user_roles.UserRoleDaoImpl;
import model.Branch;
import model.UsersRole;
import view.employee.EmployeeCreateWindow;

public class EmployeeCreateController {
    private BranchDaoImpl branchDao;
    private UserRoleDaoImpl userRoleDao;
    private EmployeeCreateWindow window;
    public EmployeeCreateController(){

        this.userRoleDao = new UserRoleDaoImpl();
        this.branchDao = new BranchDaoImpl();

        Branch[] branches = this.branchDao.getAll().toArray(new Branch[0]);
        UsersRole[] usersRolesArr = this.userRoleDao.getAll().toArray(new UsersRole[0]);
        this.window = new EmployeeCreateWindow();

        for(Branch branch : branches){
            this.window.getCbBranches().addItem(branch);
        }
        for(UsersRole userRole : usersRolesArr) {
            this.window.getCbUserRoles().addItem(userRole);
        }
    }
}
