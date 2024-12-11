package util.mapper;

import dto.CardDto;
import model.Card;

public class CardConverter {
    public static Card dtoToCard(CardDto cardDto){
        Card card = new Card();
        card.setCardNumber(card.getCardNumber());
        card.setCardType(card.getCardType());
        card.setCardExpireDate(card.getCardExpireDate());
        card.setSecurityCode(card.getSecurityCode());
        card.setAccountId(card.getAccountId());

        return card;

    }
}
