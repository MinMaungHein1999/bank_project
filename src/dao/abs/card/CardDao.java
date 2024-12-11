package dao.abs.card;
import java.util.Date;
import dao.AbstractDao;
import model.Card;
import java.util.List;

public abstract class CardDao extends AbstractDao<Card> {

    public abstract List<Card> getCardsByAccountID(int accID);

    public abstract boolean isCardExists(String cardNumber);
    public abstract String getCardExpire(Date withinDate);

}
