import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<ItemOrder> shoppingList;

    public ShoppingCart(ArrayList<ItemOrder> s) {

        shoppingList = s;

    }

    public void setShoppingList(ArrayList<ItemOrder> s) {
        shoppingList = s;
    }

    public ArrayList<ItemOrder> getShoppingList() {
        return shoppingList;
    }

    public void addItem(ItemOrder i) {
        shoppingList.add(i);
    }

    public void removeItem(ItemOrder i) {

        for (int j = 0; j < shoppingList.size(); j++) {

            if(shoppingList.get(j) == i) {
                shoppingList.remove(j);
            }

        }

    }

    public ItemOrder searchForItem(Item i) {

        for(ItemOrder items: shoppingList) {

            if(items.getItem() == i) {
                return items;
            }

        }

        return new ItemOrder(new Item("Item not found", 0), 0);

    }

}
