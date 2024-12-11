package dao.abs.card;

import dao.abs.account.AccountDao;
import dao.abs.account.AccountDaoImpl;
import model.Account;
import model.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl extends CardDao{
    private AccountDao accountDao;

    public CardDaoImpl(){
        this.accountDao = new AccountDaoImpl();
    }
    @Override
    public String getTableName() {
        return "cards";
    }

    @Override
    public Card converToObject(ResultSet resultset) {
        Card card = null;
        try{
            int id = resultset.getInt("id");
            String number = resultset.getString("number");
            int cardType = resultset.getInt("card_type");
            Date expireDate = resultset.getDate("expire_date");;
            String secCode = resultset.getString("security_code");
            int acc_id = resultset.getInt("account_id");


            Account account = this.accountDao.getById(acc_id);
            card = new Card();
            card.setId(id);
            card.setCardNumber(number);
            card.setCardType(cardType);
            card.setCardExpireDate((java.sql.Date) expireDate);
            card.setSecurityCode(secCode);

        }catch (SQLException e){
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        return card;
    }

    @Override
    public String getInsertQuery() {
        // insert into cards (card_type,expire_date,security_code)
        return "insert into "+this.getTableName()+" (card_type,expire_date,security_code)"+"values (?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "update"+this.getTableName()+" set ";
    }

    @Override
    public String getDeleteQuery() {
        return "delete from "+this.getTableName()+" where id = ?";
    }

    @Override
    public void prepareParams(PreparedStatement preparedStatement, Card object) {
        try{
            preparedStatement.setString(1,object.getCardNumber());
            preparedStatement.setInt(2,object.getCardType());
            preparedStatement.setDate(3,object.getCardExpireDate());
            preparedStatement.setString(4,object.getSecurityCode());
            preparedStatement.setObject(5,object.getAccountId());

        }catch(SQLException e){
            System.out.print("SQL Exception for: "+e.getMessage());
        }
    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, Card object) {

    }

//

    @Override
    public List<Card> getCardsByAccountID(int accID) {
        Card card = null;
        List<Card> cards = new ArrayList<>();
        // select * from cards where account_id = ?
        try{String query = "select * from "+ this.getTableName()+" where account_id = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,accID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                card = new Card();
                card.setId(resultSet.getInt("id"));
                card.setCardNumber(resultSet.getString("number"));
                card.setCardType(resultSet.getInt("card_type"));
                card.setCardExpireDate(resultSet.getDate("expire_date"));
                card.setSecurityCode(resultSet.getString("security_code"));

                cards.add(card);
            }
        } catch (SQLException e){
            System.out.print("SQL Exception for: "+e.getMessage());
        }finally {
            this.connectionFactory.closeConnection();

        }
    return cards;
    }


    @Override
    public boolean isCardExists(String cardNumber) {
        boolean flag =  false;
        try{
            String query = "SELECT number FROM "+this.getTableName()+" WHERE number = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,cardNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            flag = resultSet.next();
        }catch (SQLException e){
            System.out.print("SQL Exception from isCardExists: "+e.getMessage());
        }
        return flag;
    }

    @Override
    public String getCardExpire(Date withinDate) {
        if (withinDate == null) {
            return "Invalid date provided.";
        }

        Date currentDate = new Date(System.currentTimeMillis());
        long timeDifference = withinDate.getTime() - currentDate.getTime();

        if (timeDifference < 0) {
            return "Card has already expired.";
        }

        long daysRemaining = timeDifference / (1000 * 60 * 60 * 24);
        return daysRemaining + " days remaining until expiration.";
    }



}
