package service;


import dao.abs.card.CardDao;
import dao.abs.card.CardDaoImpl;
import model.Card;
import dto.CardDto;
import util.mapper.CardConverter;

public class CardService {
    private CardDao cardDao;

    public CardService(){
        this.cardDao = new CardDaoImpl() {
        };
    }

    public Card createProcess(CardDto cardDto){
        Card card = CardConverter.dtoToCard(cardDto);
        cardDao.create(card);

        return  card;
    }
}
