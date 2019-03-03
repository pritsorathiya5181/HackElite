package getgood.dogood.bestocr;

public class Receipt {
    String textBill;
    private Float payment;
    private String place;
    private Integer i;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Receipt() {
    }

    public String getTextBill() {
        return textBill;
    }

    public void setTextBill(String textBill) {
        this.textBill = textBill;
    }

    public Float getPayment() {
        return payment;
    }

    public void setPayment(Float payment) {
        this.payment = payment;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}