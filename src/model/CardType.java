package model;

public enum CardType {
    PREPAID (1),
    DEBIT(2),
    CREDIT(3);

    private final int value;
    CardType(int value) {
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    public static CardType fromInt(int value){
        for(CardType card : CardType.values()){
            if(card.value == value);
            return  card;
        }
        throw new IllegalArgumentException("Card Type value not found...");
    }

}
