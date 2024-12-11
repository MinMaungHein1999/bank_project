package util;

import java.util.Random;

public class CardGenerator {

    public static void main(String[] args) {
        // Generate a Credit Card
        CardDetails creditCard = generateCardDetails("4", 16);
        System.out.println("Credit Card Details:");
        System.out.println(creditCard);

        // Generate a Debit Card
        CardDetails debitCard = generateCardDetails("5", 16);
        System.out.println("\nDebit Card Details:");
        System.out.println(debitCard);

        // Generate a Savings Card
        CardDetails savingsCard = generateCardDetails("6", 16);
        System.out.println("\nSavings Card Details:");
        System.out.println(savingsCard);
    }

    /**
     * Generates a card number with CVV and expiration date.
     *
     * @param prefix The starting digits of the card number (e.g., "4" for Visa).
     * @param length The total length of the card number.
     * @return A CardDetails object containing card number, CVV, and expiration date.
     */
    public static CardDetails generateCardDetails(String prefix, int length) {
        String cardNumber = generateCardNumber(prefix, length);
        String expirationDate = generateExpirationDate();
        String cvv = generateCVV();

        return new CardDetails(cardNumber, expirationDate, cvv);
    }

    /**
     * Generates a valid card number using the Luhn algorithm.
     *
     * @param prefix The starting digits of the card number (e.g., "4" for Visa).
     * @param length The total length of the card number.
     * @return A valid card number as a String.
     */
    private static String generateCardNumber(String prefix, int length) {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder(prefix);

        // Generate random digits to fill the card number, leaving space for the check digit
        while (cardNumber.length() < length - 1) {
            cardNumber.append(random.nextInt(10));
        }

        // Compute and append the check digit
        int checkDigit = calculateLuhnCheckDigit(cardNumber.toString());
        cardNumber.append(checkDigit);

        return cardNumber.toString();
    }

    /**
     * Calculates the Luhn check digit for a given card number.
     *
     * @param cardNumber The card number without the check digit.
     * @return The Luhn check digit.
     */
    private static int calculateLuhnCheckDigit(String cardNumber) {
        int sum = 0;
        boolean alternate = false;

        // Start from the last digit and move left
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

    /**
     * Generates a random expiration date in MM/YY format.
     *
     * @return A random expiration date as a String.
     */
    private static String generateExpirationDate() {
        Random random = new Random();
        int month = random.nextInt(12) + 1; // Month between 1 and 12
        int year = random.nextInt(10) + 24; // Year between 2024 and 2033

        return String.format("%02d/%02d", month, year);
    }

    /**
     * Generates a random 3-digit CVV.
     *
     * @return A random CVV as a String.
     */
    private static String generateCVV() {
        Random random = new Random();
        int cvv = random.nextInt(900) + 100; // CVV between 100 and 999

        return String.valueOf(cvv);
    }
}

/**
 * A simple class to store card details.
 */
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
