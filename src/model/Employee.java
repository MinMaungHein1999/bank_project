package model;

import java.sql.Date;

public class Employee {
    private int id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private EmployeeStatus status;
    private String position;
    private String department;
    private Date confirmedAt;
    private Branch branch;
    private UsersRole usersRole;
    private Date cratedAt;
    private Date updatedAt;
    private Employee CreatedBy;
    private Employee updatedBy;
    public Employee(){

    }
    public Employee(int id, String username, String email, String password, String phoneNumber, EmployeeStatus status, String position, String department, Date confirmedAt, Branch branch, UsersRole usersRole, Date cratedAt, Date updatedAt, Employee createdBy, Employee updatedBy) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.position = position;
        this.department = department;
        this.confirmedAt = confirmedAt;
        this.branch = branch;
        this.usersRole = usersRole;
        this.cratedAt = cratedAt;
        this.updatedAt = updatedAt;
        CreatedBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public UsersRole getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(UsersRole usersRole) {
        this.usersRole = usersRole;
    }

    public Date getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(Date cratedAt) {
        this.cratedAt = cratedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Employee getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Employee createdBy) {
        CreatedBy = createdBy;
    }

    public Employee getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Employee updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", confirmedAt=" + confirmedAt +
                ", branch=" + branch +
                ", usersRole=" + usersRole +
                ", cratedAt=" + cratedAt +
                ", updatedAt=" + updatedAt +
                ", CreatedBy=" + CreatedBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
