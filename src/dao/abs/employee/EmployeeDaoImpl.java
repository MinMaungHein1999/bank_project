package dao.abs.employee;

import dao.abs.branch.BranchDao;
import dao.abs.branch.BranchDaoImpl;
import dao.abs.user_roles.UserRoleDao;
import dao.abs.user_roles.UserRoleDaoImpl;
import exception.AutheticationFailException;
import model.Branch;
import model.Employee;
import model.EmployeeStatus;
import model.UsersRole;

import javax.xml.transform.Result;
import java.sql.*;

public class EmployeeDaoImpl extends EmployeeDao {

    private BranchDao branchDao;
    private UserRoleDao usersRoleDao;
    public EmployeeDaoImpl() {
        this.branchDao = new BranchDaoImpl();
        this.usersRoleDao = new UserRoleDaoImpl();
    }

    @Override
    public String getTableName() {
        return "employees";
    }

    @Override
    public Employee converToObject(ResultSet resultset) {
        Employee employee = null;
        try {
           int id =  resultset.getInt("id");
           String username = resultset.getString("username");
           String email = resultset.getString("email");
           String password = resultset.getString("password");
           String phoneNumber = resultset.getString("phone_number");
           int status = resultset.getInt("status");
           String position = resultset.getString("position");
           String department = resultset.getString("department");
           Date confirmedAt = resultset.getDate("confirmed_at");
           int users_role_id =  resultset.getInt("users_role_id");
           int branchID = resultset.getInt("branch_id");
           Date createdAt =resultset.getDate("created_at");
           Date updatedAt = resultset.getDate("updated_at");
           int created_by = resultset.getInt("created_by");
           int updated_by = resultset.getInt("updated_by");

           Branch branch = this.branchDao.getById(branchID);
           UsersRole usersRole= this.usersRoleDao.getById(users_role_id);
           Employee createdBy = this.getById(created_by);
           Employee updatedBy= this.getById(updated_by);

           employee = new Employee(id, username, email, password, phoneNumber, EmployeeStatus.fromInt(status),
                                    position, department, confirmedAt, branch, usersRole, createdAt, updatedAt, createdBy, updatedBy);

        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        return employee;
    }

    @Override
    public String getInsertQuery() {
        //insert into employees(name,email,password,phone_number,status,position,department,confirm_at,branch_id,users_role_id,created_by,updated_by)
        return "insert into "+this.getTableName()+" (username, email, password, phone_number, status, position, department, confirmed_at, users_role_id, branch_id, created_by, updated_by)" +
                " values (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "update "+this.getTableName()+" set first_name = ?, last_name = ?, email = ?, phone_number = ?, employee_position = ?, salary = ?, branch_id = ? encrypt_password = ? where id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "delete from "+this.getTableName()+" where id = ?";
    }

    @Override
    public void prepareParams(PreparedStatement preparedStatement, Employee object) {
        try {
            preparedStatement.setString(1, object.getUsername());
            preparedStatement.setString(2, object.getEmail());
            preparedStatement.setString(3, object.getPassword());
            preparedStatement.setString(4, object.getPhoneNumber());
            preparedStatement.setInt(5, object.getStatus().getValue());
            preparedStatement.setString(6, object.getPosition());
            preparedStatement.setString(7, object.getDepartment());
            preparedStatement.setDate(8, object.getConfirmedAt());
            preparedStatement.setInt(9, object.getUsersRole().getId());
            preparedStatement.setInt(10, object.getBranch().getId());
            if(object.getCreatedBy() != null) {
                preparedStatement.setInt(11, object.getCreatedBy().getId());
            }else{
                preparedStatement.setNull(11, Types.INTEGER);
            }
            if(object.getUpdatedBy() != null) {
                preparedStatement.setInt(12, object.getUpdatedBy().getId());
            }else{
                preparedStatement.setNull(12, Types.INTEGER);
            }
        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }

    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, Employee object) {
//        try {
//            preparedStatement.setString(1, object.getfirstName());
//            preparedStatement.setString(2, object.getlastName());
//            preparedStatement.setString(3, object.getEmail());
//            preparedStatement.setString(4, object.getPhoneNumber());
//            preparedStatement.setString(5, object.getPosition());
//            preparedStatement.setFloat(6, (float)object.getSalary());
//            preparedStatement.setInt(7, object.getBranch().getId());
//            preparedStatement.setString(8, object.getEncryptPassword());
//            preparedStatement.setInt(9, object.getId());
//        }catch(SQLException e) {
//            System.out.print("SQL Exception for : "+e.getMessage());
//        }
    }


    @Override
    public Employee findByName(String name) {
        Employee employee = null;
        try {
            String query = "Select id from "+this.getTableName()+" where first_name like ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                employee = this.getById(id);
            }
        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
        return employee;
    }


    @Override
    public boolean isEmailExists(String email) {
        boolean exists = false;
        try{
            String query = "SELECT id FROM "+this.getTableName()+" WHERE email = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            exists = resultSet.next();
        }catch (SQLException e) {
            System.out.print("SQL Exception for isEmailExists: " + e.getMessage());
        }
        return exists;
    }


    @Override
    public boolean isPhoneExists(String phoneNumber) {
        boolean exists = false;
        try {
            String query = "SELECT id FROM "+this.getTableName()+" WHERE phone_number = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            exists = resultSet.next();
        }catch(SQLException e) {
            System.out.print("SQL Exception for isPhoneNumberExists: "+e.getMessage());
        }
        return exists;
    }

    @Override
    public boolean isUsernameExists(String username) {
        boolean exist = false;
        try {
            String query = "SELECT id FROM " + this.getTableName() + " WHERE username = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            exist = resultSet.next();
        } catch (SQLException e) {
            System.out.println("SQL Exception for isUserNameExists: " + e.getMessage());
        }
        return exist;
    }


    @Override
    public Employee validateEmployee(String username,String password) {

        Employee employee = null;
        try {
            String query = "Select * from "+this.getTableName()+" where username = ? AND password = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee = this.converToObject(resultSet);
        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
        return employee;

    }


    @Override
    public void updateLoginToken(Employee employee) {
        String query = "update "+this.getTableName()+" set login_token = ? where id = ?";
        try {
            Connection connection = connectionFactory.createConnection() ;
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            Date sqlDate = new Date(System.currentTimeMillis());
            prepareStatement.setString(1, employee.getLoginToken());
            prepareStatement.setInt(2, employee.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }

    }


    @Override
    public Employee validateLoginToken(Employee currentUser)throws AutheticationFailException{
        String query = "select * from "+this.getTableName()+" where id = ? AND login_token = ?";
        Employee object = null;
        try {
            if(currentUser == null){
                throw new AutheticationFailException("Unauthorized User!!!");
            }
            Connection connection = connectionFactory.createConnection() ;
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, currentUser.getId());
            prepareStatement.setString(2, currentUser.getLoginToken());
            ResultSet resultSet = prepareStatement.executeQuery();
            if(resultSet.next()) {
                object = this.converToObject(resultSet);
                return object;
            }else{
                throw new AutheticationFailException("Invalid Login Token For user Id: "+ currentUser.getId());
            }
        } catch (SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
        return object;

    }


    @Override
    public Employee getEmployeeByEmployeeEmail(String email) {
        Employee object = null;
        try {
            String query = "SELECT * FROM "+this.getTableName()+" WHERE email = ?";
            Connection connection = connectionFactory.createConnection() ;
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, email);
            ResultSet resultSet = prepareStatement.executeQuery();

            if(resultSet.next()) {
                object = this.converToObject(resultSet);
            }

        } catch (SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
        return object;
    }


    @Override
    public void setConfimedAt(Employee employee) {
        try {
            String query = "Update "+this.getTableName()+" set confirmed_at = ? WHERE id = ?";
            Connection connection = connectionFactory.createConnection() ;
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            Date sqlDate = new Date(System.currentTimeMillis());
            prepareStatement.setDate(1,sqlDate);
            prepareStatement.setInt(2, employee.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
    }

    @Override
    public void confirmByEmp(Employee employee) {
        try {
            String query = "Update "+this.getTableName()+" set confirmed_at = ? WHERE id = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            Date sqlDate = new Date(System.currentTimeMillis());
            prepareStatement.setDate(1,sqlDate);
            prepareStatement.setInt(2,employee.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
    }
}
