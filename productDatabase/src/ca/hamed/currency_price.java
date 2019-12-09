package ca.hamed;

public class currency_price {
    private int id;
    private int currency_id;
    private double value;

    public currency_price(int id, int currency_id, double value) {
        this.id = id;
        this.currency_id = currency_id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "currency_price{" +
                "id=" + id +
                ", currency_id=" + currency_id +
                ", value=" + value +
                '}';
    }
}
