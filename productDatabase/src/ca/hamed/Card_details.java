package ca.hamed;

public class Card_details {
    private int id;
    private int card_id;
    private int product_id;
    private int quantity;
    private int currency_id;

    public Card_details(int id, int card_id, int product_id, int quantity, int currency_id) {
        this.id = id;
        this.card_id = card_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.currency_id = currency_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    @Override
    public String toString() {
        return "Card_details{" +
                "id=" + id +
                ", card_id=" + card_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", currency_id=" + currency_id +
                '}';
    }
}
