import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {

    //setting window size and initializing other variables
    final int width = 1000;
    final int height = 500;
    String receiptMessage;
    double totalPrice = 0;

    //declaring and initializing the items that are being sold
    Item apple = new Item("Apple", 3);
    Item banana = new Item("Banana", 2);
    Item milk = new Item("Milk", 2);
    Item cereal = new Item("Cereal", 4);
    Item soda = new Item("Soda", 2.5);

    //initializing labels and textfields to get input
    JLabel storeLabel = new JLabel("Ace Grocery Store");
    JLabel bulkOfferLabel = new JLabel("Buy 2, get 25% off");
    JLabel promptLabel = new JLabel("Enter the amount of each product you wish to buy:");
    JLabel appleLabel = new JLabel("Apple ($3)");
    JLabel bananaLabel = new JLabel("Banana ($2)");
    JLabel milkLabel = new JLabel("Milk ($2)");
    JLabel cerealLabel = new JLabel("Cereal ($4)");
    JLabel sodaLabel = new JLabel("Soda ($2.50)");

    JTextField appleField = new JTextField("0", 3);
    JTextField bananaField = new JTextField("0", 3);
    JTextField milkField = new JTextField("0", 3);
    JTextField cerealField = new JTextField("0", 3);
    JTextField sodaField = new JTextField("0", 3);

    //creating a button to generate receipt
    JButton generateReceipt = new JButton("Generate Receipt");

    public Main() {

        super("Ace Grocery Store");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ace Grocery Store");
        storeLabel.setFont(storeLabel.getFont().deriveFont(30.0f));

        JPanel panel = new JPanel(new GridLayout(0, 1));

        //adding all assets to our layout
        panel.add(storeLabel);
        panel.add(bulkOfferLabel);
        panel.add(promptLabel);
        panel.add(appleLabel);
        panel.add(appleField);
        panel.add(bananaLabel);
        panel.add(bananaField);
        panel.add(milkLabel);
        panel.add(milkField);
        panel.add(cerealLabel);
        panel.add(cerealField);
        panel.add(sodaLabel);
        panel.add(sodaField);
        panel.add(generateReceipt);

        getContentPane().add(panel);
        setVisible(true);

        ActionListener ReceiptGenerator = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    ItemOrder appleOrder = new ItemOrder(apple, Integer.parseInt(appleField.getText()));
                    ItemOrder bananaOrder = new ItemOrder(banana, Integer.parseInt(bananaField.getText()));
                    ItemOrder milkOrder = new ItemOrder(milk, Integer.parseInt(milkField.getText()));
                    ItemOrder cerealOrder = new ItemOrder(cereal, Integer.parseInt(cerealField.getText()));
                    ItemOrder sodaOrder = new ItemOrder(soda, Integer.parseInt(sodaField.getText()));

                    ArrayList<ItemOrder> ItemList = new ArrayList<>();
                    ItemList.add(appleOrder);
                    ItemList.add(bananaOrder);
                    ItemList.add(milkOrder);
                    ItemList.add(cerealOrder);
                    ItemList.add(sodaOrder);

                    ShoppingCart customerCart = new ShoppingCart(ItemList);

                    totalPrice = appleOrder.getTotalPrice() + bananaOrder.getTotalPrice() + milkOrder.getTotalPrice() + cerealOrder.getTotalPrice() + sodaOrder.getTotalPrice();
                    receiptMessage = "Item      Qty      Price\n";

                    if (customerCart.getShoppingList().get(0).getQuantity() > 0) {

                        receiptMessage += customerCart.getShoppingList().get(0).getItem().getItemName() + "      " + customerCart.getShoppingList().get(0).getQuantity() + "      " + customerCart.getShoppingList().get(0).getTotalPrice() + "\n";

                    }

                    if (customerCart.getShoppingList().get(1).getQuantity() > 0) {

                        receiptMessage += customerCart.getShoppingList().get(1).getItem().getItemName() + "      " + customerCart.getShoppingList().get(1).getQuantity() + "      " + customerCart.getShoppingList().get(1).getTotalPrice() + "\n";

                    }

                    if (customerCart.getShoppingList().get(2).getQuantity() > 0) {

                        receiptMessage += customerCart.getShoppingList().get(2).getItem().getItemName() + "      " + customerCart.getShoppingList().get(2).getQuantity() + "      " + customerCart.getShoppingList().get(2).getTotalPrice() + "\n";

                    }

                    if (customerCart.getShoppingList().get(3).getQuantity() > 0) {

                        receiptMessage += customerCart.getShoppingList().get(3).getItem().getItemName() + "      " + customerCart.getShoppingList().get(3).getQuantity() + "      " + customerCart.getShoppingList().get(3).getTotalPrice() + "\n";

                    }

                    if (customerCart.getShoppingList().get(4).getQuantity() > 0) {

                        receiptMessage += customerCart.getShoppingList().get(4).getItem().getItemName() + "      " + customerCart.getShoppingList().get(4).getQuantity() + "      " + customerCart.getShoppingList().get(4).getTotalPrice() + "\n";

                    }

                    receiptMessage += "Total: $" + totalPrice;
                    JOptionPane.showMessageDialog(Main.this, receiptMessage, "Receipt", JOptionPane.INFORMATION_MESSAGE);

                }

                catch (NumberFormatException e1) {
                    System.out.println("Incorrect input! Please enter a number");
                }



            }
        };

        generateReceipt.addActionListener(ReceiptGenerator);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }
}