import org.json.JSONPropertyName;

import java.io.Serializable;

public class Payment{

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Payment(double amountToPay, String name, String cardNumber) {
        this.amountToPay = amountToPay;
        this.name = name;
        this.cardNumber = cardNumber;
    }

    private double amountToPay;
    private String cardNumber;
    private String name;

}
