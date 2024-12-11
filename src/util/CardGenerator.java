package util;

import java.util.Random;

public class CardGenerator {

    public static void main(String[] args) {
        CardDetails creditCard = generateCardDetails("4", 16);
        System.out.println("Credit Card Details:");
        System.out.println(creditCard);

        CardDetails debitCard = generateCardDetails("5", 16);
        System.out.println("\nDebit Card Details:");
        System.out.println(debitCard);

        CardDetails savingsCard = generateCardDetails("6", 16);
        System.out.println("\nSavings Card Details:");
        System.out.println(savingsCard);
    }


    public static CardDetails generateCardDetails(String prefix, int length) {
        String cardNumber = generateCardNumber(prefix, length);
        String expirationDate = generateExpirationDate();
        String cvv = generateCVV();

        return new CardDetails(cardNumber, expirationDate, cvv);
    }


    public static String generateCardNumber(String prefix, int length) {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder(prefix);

        while (cardNumber.length() < length - 1) {
            cardNumber.append(random.nextInt(10));
        }


        int checkDigit = calculateLuhnCheckDigit(cardNumber.toString());
        cardNumber.append(checkDigit);

        return cardNumber.toString();
    }


    public static int calculateLuhnCheckDigit(String cardNumber) {
        int sum = 0;
        boolean alternate = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return (10 - (sum % 10)) % 10;
    }


    public static String generateExpirationDate() {
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int year = random.nextInt(10) + 24;

        return String.format("%02d/%02d", month, year);
    }


    public static String generateCVV() {
        Random random = new Random();
        int cvv = random.nextInt(900) + 100;

        return String.valueOf(cvv);
    }
}


class CardDetails {
    private final String cardNumber;
    private final String expirationDate;
    private final String cvv;

    public CardDetails(String cardNumber, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Card Number: " + cardNumber +
                "\nExpiration Date: " + expirationDate +
                "\nCVV: " + cvv;
    }
}
