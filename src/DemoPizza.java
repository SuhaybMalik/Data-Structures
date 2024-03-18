import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DemoPizza extends JFrame {

    //setting frame size and other variables
    final int width = 1000;
    final int height = 500;
    String[] tempToppingList = new String[10];
    String tempTopping = "Current Toppings: ";
    int toppingCount = 0;
    int numberOfPizzas;

    //creating text fields and other assets
    JTextField toppingField = new JTextField("");
    JButton addToppingButton = new JButton("Add Topping");
    JCheckBox deliverCheckBox = new JCheckBox("Deliver?");
    JButton clearToppingsButton = new JButton("Clear Toppings");
    JButton placeOrderButton = new JButton("Place Order");
    JTextField numberField = new JTextField("");
    JLabel toppingLabel = new JLabel(tempTopping);

    public DemoPizza() {

        super("Scoob Pizza Store");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Scoob's Pizza Store");

        //creating a grid layout
        JPanel gridPanel = new JPanel(new GridLayout(10, 0));

        //adding all the components to the layout
        gridPanel.add(new JLabel("SCOOB'S PIZZA"));
        gridPanel.add(new JLabel("Enter Toppings: (Enter as String): "));
        gridPanel.add(toppingField);
        gridPanel.add(addToppingButton);
        gridPanel.add(new JLabel("Enter the number of pizzas you want to order (Enter as Integer): "));
        gridPanel.add(numberField);
        gridPanel.add(deliverCheckBox);
        gridPanel.add(toppingLabel);
        gridPanel.add(clearToppingsButton);
        gridPanel.add(placeOrderButton);


        ActionListener toppingArrayGenerator = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(toppingCount < 10) {

                    if(Objects.equals(toppingField.getText(), "") || toppingField.getText() == null) {

                        JOptionPane.showMessageDialog(null, "Cannot Add Empty Topping!");

                    }

                    else {

                        toppingCount += 1;
                        tempToppingList[toppingCount - 1] = toppingField.getText();
                        toppingField.setText("");

                        tempTopping = "Current Toppings: ";
                        for(int i = 0; i < toppingCount; i++) {

                            if(i < toppingCount - 1) {
                                tempTopping += tempToppingList[i];
                                tempTopping += ", ";
                            }

                            else {
                                tempTopping += tempToppingList[i];
                            }
                            toppingLabel.setText(tempTopping);
                        }

                    }

                }

                else {
                    JOptionPane.showMessageDialog(null, "Cannot Exceed 10 Toppings!");
                }

            }
        };

        ActionListener toppingArrayClearer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                toppingCount = 0;
                tempToppingList = new String[10];
                tempTopping = "Current Toppings: ";
                toppingLabel.setText(tempTopping);

            }
        };

        ActionListener pizzaOrderGenerator = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] toppingList = new String[toppingCount];

                if(toppingCount > 0) {

                    for(int i = 0; i < toppingCount; i++) {
                        toppingList[i] = tempToppingList[i];
                    }

                }

                //create a deliverypizza object if delivering and a regular pizza object if not delivering
                if(deliverCheckBox.isSelected()) {

                    try {

                        numberOfPizzas = Integer.parseInt(numberField.getText());
                        String deliveryAddress = JOptionPane.showInputDialog(null, "Enter the Delivery Address: ");
                        DeliveryPizza myDeliveryPizza = new DeliveryPizza(toppingList, toppingCount, deliveryAddress, numberOfPizzas);

                        JOptionPane.showMessageDialog(null, "Order Placed!\n" + myDeliveryPizza + ". The total price of " + numberOfPizzas + " is $" + (numberOfPizzas * myDeliveryPizza.getPrice()) + ". There is an additional delivery fee of $" + myDeliveryPizza.getDeliveryFee() + "\nThe pizza will be delivered to: " + myDeliveryPizza.getDeliveryAddress());
                        toppingCount = 0;
                        tempToppingList = new String[10];
                        tempTopping = "Current Toppings: ";
                        toppingLabel.setText(tempTopping);
                        numberField.setText("");

                    }

                    catch(NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Must enter number of pizzas as an integer!");
                    }

                    catch(Exception e1) {
                        JOptionPane.showMessageDialog(null, "Invalid Input! Please Re-check all Fields!");
                    }

                }

                else {

                    try {

                        numberOfPizzas = Integer.parseInt(numberField.getText());
                        Pizza myPizza = new Pizza(toppingList, toppingCount);

                        JOptionPane.showMessageDialog(null, "Order Placed!\n" + myPizza + ". The total Price of " + numberOfPizzas + " is $" + (numberOfPizzas * myPizza.getPrice()));
                        toppingCount = 0;
                        tempToppingList = new String[10];
                        tempTopping = "Current Toppings: ";
                        toppingLabel.setText(tempTopping);
                        numberField.setText("");

                    }

                    catch(NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Must enter number of pizzas as an integer!");
                    }

                    catch(Exception e1) {
                        JOptionPane.showMessageDialog(null, "Invalid Input! Please Re-check all Fields!");
                    }

                }

            }
        };

        addToppingButton.addActionListener(toppingArrayGenerator);
        clearToppingsButton.addActionListener(toppingArrayClearer);
        placeOrderButton.addActionListener(pizzaOrderGenerator);

        getContentPane().add(gridPanel);
        setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DemoPizza();
            }
        });

    }

}