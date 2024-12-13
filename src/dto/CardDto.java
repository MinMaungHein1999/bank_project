package dto;

import java.util.Date;

public class CardDto {
    private String number;
    private int card_type;
    private Date expire_date;
    private String security_code;
    private int account_id;

    public CardDto(String number, int card_type, Date expire_date, String security_code, int account_id) {
        this.number = number;
        this.card_type = card_type;
        this.expire_date = expire_date;
        this.security_code = security_code;
        this.account_id = account_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCard_type() {
        return card_type;
    }

    public void setCard_type(int card_type) {
        this.card_type = card_type;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

}
