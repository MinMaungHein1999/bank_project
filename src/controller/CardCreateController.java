package controller;

import dao.abs.card.CardDao;
import dao.abs.card.CardDaoImpl;
import dto.CardDto;
import service.CardService;
import model.Card;
import view.card.CardCreateWindow;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardCreateController {
    private CardDao cardDao;
    private CardCreateWindow myWindow;
    private CardService cardService;


    public CardCreateController(){
        this.cardDao = new CardDaoImpl();
        myWindow = new CardCreateWindow();

    }
    private void createBtnAction() {
        CardDto cardDto =  getCardInfo();
        Card card = this.cardService.createProcess(cardDto);
        this.myWindow.dispose();
        JOptionPane.showMessageDialog(this.myWindow, "Card Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//        new OtpController(card);
    }

    private CardDto getCardInfo(){
        String number = this.myWindow.getNumberTF().getText();
        String cardType = (String)this.myWindow.getCardTypeTF().getSelectedItem();
        Date expireDate = getExpireDate();
        String securityCode = this.myWindow.getSecurityCodeTF().getText();

        CardDto cardDto = new CardDto(number,cardType,expireDate,securityCode);

        return cardDto;
    }

    private Date getExpireDate()  {
        String dateText = this.myWindow.getExpireDateTF().getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.setLenient(false);

        try{
            return dateFormat.parse(dateText);
        }catch (ParseException e){
            System.out.println("CardCreateControllerError in date format....");
            return null;
        }
    }

}
