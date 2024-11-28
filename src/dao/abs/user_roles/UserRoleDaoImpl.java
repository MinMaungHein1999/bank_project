package dao.abs.user_roles;


import model.UsersRole;

import java.sql.*;

public class UserRoleDaoImpl extends UserRoleDao{

    public UserRoleDaoImpl() {

    }

    @Override
    public String getTableName() {
        return "users_role";
    }

    @Override
    public UsersRole converToObject(ResultSet resultset) {
        UsersRole userRole = new UsersRole();
        try{
            int id = resultset.getInt("id");
            String name = resultset.getString("name");
            String description = resultset.getString("description");

            userRole.setId(id);
            userRole.setName(name);
            userRole.setDescription(description);

        }catch (SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        return userRole;
    }

    @Override
    public String getInsertQuery() {
        return "insert into" + this.getTableName() + "(name, description) values (?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "update" + this.getTableName() + "set name = ?, description = ? where id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "delete from" + this.getTableName() + "where id = ?";
    }

    @Override
    public void prepareParams(PreparedStatement preparedStatement, UsersRole object) {
        try{
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getDescription());

        } catch (SQLException e) {
            System.out.println("SQL Exception for: " + e.getMessage());
        }
    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, UsersRole object) {
        try{
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getDescription());
            preparedStatement.setInt(3, object.getId());

        } catch (SQLException e) {
            System.out.println("SQL Exception for: " + e.getMessage());
        }
    }
}

