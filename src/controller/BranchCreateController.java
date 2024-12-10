package controller;
import view.branch.CreateBranchPage;

public class BranchCreateController {

    private CreateBranchPage createBranchPage;

    public BranchCreateController(){
        this.createBranchPage  = new CreateBranchPage();
        System.out.println("Adding create Branch controller");
        addCreateBtnAction();
    }

    public void addCreateBtnAction(){
        this.createBranchPage.getCreateBtn().addActionListener(e-> createBtnAction());
    }

    public void createBtnAction(){
        System.out.print("Create Branch");
    }
}
