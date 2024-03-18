public class DeliveryPizza extends Pizza {

    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String[] t, int n, String a, int pN) {

        super(t, n);
        deliveryAddress = a;
        if((super.getPrice() * pN) > 18) {
            deliveryFee = 3;
        }

        else {
            deliveryFee = 5;
        }

    }

    public void setDeliveryFee(double d) {
        deliveryFee = d;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryAddress(String a) {
        a = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

}
