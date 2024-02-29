import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class UseDinnerParty extends JFrame {

    final int width = 1200;
    final int height = 600;
    int menuChoice = 0;
    DinnerParty myDinnerParty;
    String message;

    JLabel preferenceLabel = new JLabel("Please Enter Preferences/Food Allergies");

    //button group for menu items
    ButtonGroup menuItems = new ButtonGroup();
    JRadioButton chicken = new JRadioButton("Chicken and Rice Dinner", false);
    JRadioButton vegetarian = new JRadioButton("Vegetable Stir Fry", false);
    JRadioButton beef = new JRadioButton("Beef and Potatoes", false);
    JRadioButton seaFood = new JRadioButton("Sea Food Platter", false);
    JRadioButton tofu = new JRadioButton("Tofu Salad", false);

    //textarea to get user preferences
    JTextField guestBox = new JTextField(4);
    JTextArea preferenceBox = new JTextArea();

    //button to finalize invitation
    JButton generateInvitation = new JButton("Create Invitation");

    public UseDinnerParty() {

        super("Dinner Party!");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dinner Party");
        preferenceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 8));

        //adding radio buttons to button group
        menuItems.add(chicken);
        menuItems.add(beef);
        menuItems.add(vegetarian);
        menuItems.add(seaFood);
        menuItems.add(tofu);

        //creating grid layout display and displaying all buttons
        JPanel panel = new JPanel(new GridLayout(7, 7));

        //row 1
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel("Create Dinner Party!"));
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        //row 2
        panel.add(new JLabel("Enter # of guests: "));
        panel.add(guestBox);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        //row 3
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel("Choose the Menu:"));
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        //row 4
        panel.add(new JLabel());
        panel.add(chicken);
        panel.add(vegetarian);
        panel.add(beef);
        panel.add(seaFood);
        panel.add(tofu);
        panel.add(new JLabel());

        //row 5
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(preferenceLabel);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        //row 6
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(preferenceBox);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        //row 7
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(generateInvitation);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        getContentPane().add(panel);
        setVisible(true);

        ActionListener menuSelector = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menuChoice = 0;

                if((JRadioButton) e.getSource() == chicken) {
                    menuChoice = 1;
                }

                else if((JRadioButton) e.getSource() == vegetarian) {
                    menuChoice = 2;
                }

                else if((JRadioButton) e.getSource() == beef) {
                    menuChoice = 3;
                }

                else if((JRadioButton) e.getSource() == seaFood) {
                    menuChoice = 4;
                }

                else if((JRadioButton) e.getSource() == tofu) {
                    menuChoice = 5;
                }

                else {
                    menuChoice = 0;
                }

            }
        };

        ActionListener invitationMaker = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myDinnerParty = new DinnerParty(Integer.parseInt(guestBox.getText()), menuChoice, preferenceBox.getText());

                if(myDinnerParty.getDinnerChoice() == 0) {

                    JOptionPane.showMessageDialog(null, "Invalid! Please Select a meal!");

                }

                else if(myDinnerParty.getDinnerChoice() == 1) {

                    message = "The Dinner Party has " + myDinnerParty.getGuests() + " guests.\n" + "The Menu for the Party is Chicken and Rice.\n" + "We Will Adhere to Your Preferences: " + myDinnerParty.getPreferences() + "\n" + myDinnerParty.displayInvitation();
                    JOptionPane.showMessageDialog(null, message);

                }

                else if(myDinnerParty.getDinnerChoice() == 2) {

                    message = "The Dinner Party has " + myDinnerParty.getGuests() + " guests.\n" + "The Menu for the Party is Vegetable Stir Fry.\n" + "We Will Adhere to Your Preferences: " + myDinnerParty.getPreferences() + "\n" + myDinnerParty.displayInvitation();
                    JOptionPane.showMessageDialog(null, message);

                }

                else if(myDinnerParty.getDinnerChoice() == 3) {

                    message = "The Dinner Party has " + myDinnerParty.getGuests() + " guests.\n" + "The Menu for the Party is Beef and Potatoes.\n" + "We Will Adhere to Your Preferences: " + myDinnerParty.getPreferences() + "\n" + myDinnerParty.displayInvitation();
                    JOptionPane.showMessageDialog(null, message);

                }

                else if(myDinnerParty.getDinnerChoice() == 4) {

                    message = "The Dinner Party has " + myDinnerParty.getGuests() + " guests.\n" + "The Menu for the Party is SeaFood Platter.\n" + "We Will Adhere to Your Preferences: " + myDinnerParty.getPreferences() + "\n" + myDinnerParty.displayInvitation();
                    JOptionPane.showMessageDialog(null, message);

                }

                else if(myDinnerParty.getDinnerChoice() == 5) {

                    message = "The Dinner Party has " + myDinnerParty.getGuests() + " guests.\n" + "The Menu for the Party is Tofu Salad.\n" + "We Will Adhere to Your Preferences: " + myDinnerParty.getPreferences() + "\n" + myDinnerParty.displayInvitation();
                    JOptionPane.showMessageDialog(null, message);

                }

            }
        };

        chicken.addActionListener(menuSelector);
        beef.addActionListener(menuSelector);
        vegetarian.addActionListener(menuSelector);
        seaFood.addActionListener(menuSelector);
        tofu.addActionListener(menuSelector);

        generateInvitation.addActionListener(invitationMaker);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UseDinnerParty();
            }
        });

    }

}
