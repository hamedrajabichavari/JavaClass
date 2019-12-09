package ca.hamed;

public class Invoice_details {

    private int id;
    private int product_id;
    private int quantity;
    private int currency_id;

    public Invoice_details(int id, int product_id, int quantity, int currency_id) {
        this.id = id;
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
        return "Invoice_details{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", currency_id=" + currency_id +
                '}';
    }
}
