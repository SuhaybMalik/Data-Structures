public class ItemOrder {

    private Item item;
    private int quantity;
    private double bulkPrice;

    public ItemOrder(Item i, int q) {

        item = i;

        if (q >= 0) {
            quantity = q;
        }

        else {
            quantity = 0;
        }

        bulkPrice = i.getItemPrice() * 0.75;

    }

    public void setItem(Item i) {
        item = i;
    }

    public Item getItem() {
        return item;
    }

    public void setQuantity(int q) {
        quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {

        if (quantity == 0 || quantity == 1) {

            return (item.getItemPrice() * quantity);

        }

        else {

            if (quantity % 2 == 0) {
                return (bulkPrice * quantity);
            }

            else {
                return ((bulkPrice * (quantity - 1)) + item.getItemPrice());
            }

        }

    }

}
