package ca.hamed;

public class Invoice {
    private int id;
    private int customer_id;
    private String name;
    private String due_date;
    private Invoice_details value;
    private int isPaid;
    private String payMethod;

    public Invoice(int id, int customer_id, String name, String due_date, Invoice_details value, int isPaid, String payMethod) {
        this.id = id;
        this.customer_id = customer_id;
        this.name = name;
        this.due_date = due_date;
        this.value = value;
        this.isPaid = isPaid;
        this.payMethod = payMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public Invoice_details getValue() {
        return value;
    }

    public void setValue(Invoice_details value) {
        this.value = value;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", name='" + name + '\'' +
                ", due_date='" + due_date + '\'' +
                ", value=" + value +
                ", isPaid=" + isPaid +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
