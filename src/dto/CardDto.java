package dto;

import java.util.Date;

public class CardDto {
    private String number;
    private String card_type;
    private Date expire_date;
    private String security_code;


    public CardDto(String number, String card_type, Date expire_date, String security_code) {
        this.number = number;
        this.card_type = card_type;
        this.expire_date = expire_date;
        this.security_code = security_code;

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
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




}
