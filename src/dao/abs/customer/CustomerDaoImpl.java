package dao.abs.customer;

import dao.abs.employee.EmployeeDaoImpl;
import model.Customer;
import model.CustomerStatus;
import model.Employee;
import dao.abs.employee.EmployeeDao;

import java.sql.*;

public class CustomerDaoImpl extends CustomerDao{
    private EmployeeDao employeeDaoImpl;

    public CustomerDaoImpl(){
        this.employeeDaoImpl = new EmployeeDaoImpl();
    }

    @Override
    public String getTableName() {
        return "customers";
    }

    @Override
    public Customer converToObject(ResultSet resultset) {
        Customer customer =null;
        try{
            int id = resultset.getInt("id");
            String firstName = resultset.getString("first_name");
            String lastName = resultset.getString("last_name");
            String email =resultset.getString("email");
            String nrc = resultset.getString("nrc");
            String phone = resultset.getString("phone");
            String address = resultset.getString("address");
            int status = resultset.getInt("status");
            Date dateOfBirth = resultset.getDate("date_of_birth");
            Date confirmedAt = resultset.getDate("confirmed_at");
            Date createdAt = resultset.getDate("created_at");
            Date updatedAt = resultset.getDate("updated_at");
            int createdById = resultset.getInt("created_by");
            int updatedById = resultset.getInt("updated_by");
            Employee createdBy = this.employeeDaoImpl.getById(createdById);
            Employee updatedBy = this.employeeDaoImpl.getById(updatedById);
            customer = new Customer(id, firstName, lastName, email, nrc, phone, address, CustomerStatus.fromInt(status), dateOfBirth, confirmedAt, createdAt, updatedAt, createdBy, updatedBy);
        }catch(
    SQLException e) {
        System.out.print("SQL Exception for : "+e.getMessage());
    }
        return customer;
}

    @Override
    public String getInsertQuery() {
        return "INSERT INTO "+this.getTableName()+" ( first_name, last_name, email, nrc, phone, address, status, date_of_birth, confirmed_at, created_at, updated_at, created_by, updated_by)" +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, Customer object) {

    }
    @Override
    public String getUpdateQuery() {
        return "UPDATE "+this.getTableName()+" SET first_name = ?, last_name = ?, email = ?, nrc = ?, phone = ? , address = ?, date_of_birth = ?  WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM "+this.getTableName()+" WHERE id = ?";
    }

    @Override
    public Customer findByName(String name) {
        Customer customer = null;
        try {
            String query = "SELECT id FROM "+this.getTableName()+" WHERE first_name like ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                customer = this.getById(id);
            }
        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
        return customer;
    }

    @Override
    public Customer findByEmail(String email) {
        try{
            String query = "SELECT * FROM "+this.getTableName()+" WHERE email = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Customer customer = this.converToObject(resultSet);
            return customer;
        }catch (SQLException e) {
            System.out.print("SQL Exception for Find By Email : " + e.getMessage());
        }finally {
            this.connectionFactory.closeConnection();
        }
        return null;
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
            String query = "SELECT id FROM "+this.getTableName()+" WHERE phone = ?";
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
    public void prepareParams(PreparedStatement preparedStatement, Customer object) {

        try {
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getLastName());
            preparedStatement.setString(3, object.getEmail());
            preparedStatement.setString(4, object.getNrc());
            preparedStatement.setString(5, object.getPhone());
            preparedStatement.setString(6, object.getAddress());
            preparedStatement.setInt(7, object.getStatus().getValue());
            preparedStatement.setDate(8, object.getDateOfBirth());
            preparedStatement.setDate(9, object.getConfirmedAt());
            preparedStatement.setDate(10, object.getCreatedAt());
            preparedStatement.setDate(11, object.getUpdatedAt());
            if(object.getCreatedBy() != null) {
                preparedStatement.setInt(12, object.getCreatedBy().getId());
            }else{
                preparedStatement.setNull(12, Types.INTEGER);
            }
            if(object.getUpdatedBy() != null) {
                preparedStatement.setInt(13, object.getUpdatedBy().getId());
            }else{
                preparedStatement.setNull(13, Types.INTEGER);
            }
        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }

    }

}



