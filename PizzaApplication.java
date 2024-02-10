import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaApplication extends JFrame {

    //setting the frame size and global variables for calculations
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 500;
    float wallet_money = 0;
    float price = 0;
    int topping_count = 0;
    char pizza_size = 'i';

    //creating the assets, specifically buttons to display and use
    ButtonGroup sizes = new ButtonGroup();
    JRadioButton size_small = new JRadioButton("Small ($5)", false);
    JRadioButton size_medium = new JRadioButton("Medium ($10)", false);
    JRadioButton size_large = new JRadioButton("Large ($15)", false);
    JRadioButton size_super = new JRadioButton("Super ($20)", false);

    JCheckBox stuffed_crust = new JCheckBox("Stuffed Crust", false);

    JCheckBox pepperoni_button = new JCheckBox("Pepperoni");
    JCheckBox fajita_button = new JCheckBox("Chicken Fajita");
    JCheckBox vegetables_button = new JCheckBox("Veggies");
    JCheckBox cheese_button = new JCheckBox("Extra Cheese");
    JCheckBox chicken_wings = new JCheckBox("Buffalo Wings");
    JCheckBox ranch = new JCheckBox("Ranch Topping");

    //creating a toppings array so i can sort through it in a for loop
    JCheckBox[] toppings = new JCheckBox[6];

    public PizzaApplication(){

        super("Scoob's Pizzeria");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Scoob's Pizzeria");

        JLabel size_label = new JLabel("Select the Pizza Size:");
        JLabel toppings_label = new JLabel("Select Toppings:");
        JButton wallet_button = new JButton("Add to Wallet");
        JLabel wallet_display = new JLabel("Money: $" + 0);
        JButton buy_button = new JButton("Order");

        //adding all topping buttons to the array
        toppings[0] = pepperoni_button;
        toppings[1] = fajita_button;
        toppings[2] = vegetables_button;
        toppings[3] = cheese_button;
        toppings[4] = chicken_wings;
        toppings[5] = ranch;

        //adding size radio buttons to button group
        sizes.add(size_small);
        sizes.add(size_medium);
        sizes.add(size_large);
        sizes.add(size_super);

        //creating grid layout display and displaying all buttons
        JPanel panel = new JPanel(new GridLayout(8, 7));
        //panel.setLayout(new GridLayout(8, 9));
        panel.add(wallet_button);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel("SCOOB'S PIZZA"));
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(wallet_display);

        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(size_label);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        //panel.add(new JLabel());

        //panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(size_small);
        panel.add(size_medium);
        panel.add(size_large);
        panel.add(new JLabel());
        panel.add(new JLabel());
        //panel.add(new JLabel());

        //panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(size_super);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        //panel.add(new JLabel());

        //panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(toppings_label);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        //panel.add(new JLabel());

        //panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(toppings[0]);
        panel.add(toppings[1]);
        panel.add(toppings[2]);
        panel.add(toppings[3]);
        panel.add(toppings[4]);
        panel.add(new JLabel());
        //panel.add(new JLabel());

        //panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(toppings[5]);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        //panel.add(new JLabel());

        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(buy_button);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        getContentPane().add(panel);
        setVisible(true);

        //action listener for caclulating the toppings selected
        ActionListener max_toppings = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected_count = 0;
                for (JCheckBox checkbox : toppings) {
                    if (checkbox.isSelected()) {
                        selected_count++;
                    }
                }

                if (selected_count > 3) {
                    JOptionPane.showMessageDialog(PizzaApplication.this,
                            "You can only select up to 3 toppings.", "Topping Limit Exceeded",
                            JOptionPane.WARNING_MESSAGE);

                    // Unselect the last clicked checkbox
                    ((JCheckBox) e.getSource()).setSelected(false);
                }

                if (selected_count <= 3 && !toppings[3].isSelected()){
                    topping_count = selected_count;
                }

                else if (selected_count <= 3 && toppings[3].isSelected()){

                    if (selected_count > 0) {
                        topping_count = selected_count - 1;
                    }

                    else {
                        topping_count = 0;
                    }

                }

                else {
                    topping_count = 3;
                }

                //System.out.println(topping_count);

            }
        };

        for (JCheckBox checkbox : toppings) {
            checkbox.addActionListener(max_toppings);
        }

        //action listener for calculating money in our digital wallet
        ActionListener wallet_function = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wallet_money += Float.parseFloat(JOptionPane.showInputDialog(PizzaApplication.this, "How much money do you want to add?", "0"));
                //System.out.println(wallet_money);
                wallet_display.setText("Money: $" + wallet_money);

            }

        };

        wallet_button.addActionListener(wallet_function);

        //action listener for size selection
        ActionListener size_price = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pizza_size = 'i';

                if ((JRadioButton) e.getSource() == size_small) {
                    pizza_size = 's';
                }

                else if ((JRadioButton) e.getSource() == size_medium) {
                    pizza_size = 'm';
                }

                else if ((JRadioButton) e.getSource() == size_large) {
                    pizza_size = 'l';
                }

                else if ((JRadioButton) e.getSource() == size_super) {
                    pizza_size = 'S';
                }

                else {
                    pizza_size = 'i';
                }

                wallet_display.setText("Money: $" + wallet_money);

            }
        };

        //action listener for pizza size selection
        ActionListener price_calculator = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                price = 0;

                if (pizza_size == 's') {
                    price += 5;
                }

                else if (pizza_size == 'm') {
                    price += 10;
                }

                else if (pizza_size == 'l') {
                    price += 15;
                }

                else if (pizza_size == 'S') {
                    price += 20;
                }

                if (topping_count == 1) {
                    price += 0.5;
                }

                else if (topping_count == 2) {
                    price += 1;
                }

                else if (topping_count == 3) {
                    price += 1.25;
                }

                if (wallet_money >= price) {

                    System.out.println(pizza_size);

                    if (pizza_size == 'i') {
                        JOptionPane.showMessageDialog(null, "Invalid Input! Please select a Pizza size!");
                    }

                    else {

                        wallet_money -= price;
                        wallet_display.setText("Money: $" + wallet_money);

                        JOptionPane.showMessageDialog(null, "Order Confirmed for $" + price);


                    }

                }

                else {

                    if (pizza_size == 'i') {
                        JOptionPane.showMessageDialog(null, "Invalid Input! Please select a Pizza size.");
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Not enough funds in wallet to place order. Order Cancelled!");
                    }

                }

            }
        };

        buy_button.addActionListener(price_calculator);

        size_small.addActionListener(size_price);
        size_medium.addActionListener(size_price);
        size_large.addActionListener(size_price);
        size_super.addActionListener(size_price);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PizzaApplication();
            }
        });

    }

}
