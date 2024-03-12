public class Item {

    private String itemName;
    private double itemPrice;

    public Item(String n, double p) {

        itemName = n;
        itemPrice = p;

    }

    public void setItemName(String n) {
        itemName = n;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemPrice(double p) {
        itemPrice = p;
    }

    public double getItemPrice() {
        return itemPrice;
    }

}
