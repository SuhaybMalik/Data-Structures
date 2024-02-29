import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class TestWedding extends JFrame {

    //setting size of the screen
    final int width = 1200;
    final int height = 600;
    String themeChar = "Invalid";

    //text fields for getting information
    JTextField firstName1 = new JTextField(10);
    JTextField lastName1 = new JTextField(10);
    JTextField firstName2 = new JTextField(10);
    JTextField lastName2 = new JTextField(10);
    JTextField location = new JTextField(10);

    //fields to set our date
    JTextField month = new JTextField(2);
    JTextField day = new JTextField(2);
    JTextField year = new JTextField(4);
    JTextField hours = new JTextField(2);
    JTextField minutes = new JTextField(2);

    //initializing instances of our classes
    Person p1;
    Person p2;
    Couple c1;
    Wedding W;
    Date d;

    //button to create wedding
    JButton generateWedding = new JButton("Create Wedding");

    //button group to choose the wedding theme
    ButtonGroup themes = new ButtonGroup();
    JRadioButton standardTheme = new JRadioButton("Standard", false);
    JRadioButton spookyTheme = new JRadioButton("Spooky", false);
    JRadioButton gardenTheme = new JRadioButton("Garden", false);
    JRadioButton rusticTheme = new JRadioButton("Rustic", false);

    public TestWedding() {

        super("Wedding Creator");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wedding Creator");

        //adding radio buttons to button group
        themes.add(standardTheme);
        themes.add(spookyTheme);
        themes.add(gardenTheme);
        themes.add(rusticTheme);

        //creating a grid layout and displaying all assets
        JPanel panel = new JPanel(new GridLayout(10, 7));

        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel("Wedding Planner"));
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Enter first name of groom: "));
        panel.add(firstName1);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Enter last name of groom: "));
        panel.add(lastName1);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Enter first name of bride: "));
        panel.add(firstName2);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Enter last name of bride: "));
        panel.add(lastName2);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Enter location: "));
        panel.add(location);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Month (mm): "));
        panel.add(month);
        panel.add(new JLabel("Day (dd): "));
        panel.add(day);
        panel.add(new JLabel("Year (yyyy): "));
        panel.add(year);
        panel.add(new JLabel());

        panel.add(new JLabel("Hour (24 hr): "));
        panel.add(hours);
        panel.add(new JLabel("Minutes: "));
        panel.add(minutes);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        panel.add(new JLabel("Select Theme:"));
        panel.add(standardTheme);
        panel.add(spookyTheme);
        panel.add(new JLabel());
        panel.add(rusticTheme);
        panel.add(gardenTheme);
        panel.add(new JLabel());

        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(generateWedding);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        getContentPane().add(panel);
        setVisible(true);

        //actionlistener for selecting theme
        ActionListener themeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                themeChar = "Invalid";

                if((JRadioButton) e.getSource() == standardTheme) {
                    themeChar = "Standard";
                }

                else if((JRadioButton) e.getSource() == spookyTheme) {
                    themeChar = "Spooky";
                }

                else if((JRadioButton) e.getSource() == gardenTheme) {
                    themeChar = "Garden";
                }

                else if((JRadioButton) e.getSource() == rusticTheme) {
                    themeChar = "Rustic";
                }

                else {
                    themeChar = "Invalid";
                }

            }
        };

        //actionlistener for wedding generation
        ActionListener weddingGen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(themeChar == "Invalid") {
                    JOptionPane.showMessageDialog(null, "Invalid Input! Please Select a theme");
                }

                else {

                    p1 = new Person(firstName1.getText(), lastName1.getText());
                    p2 = new Person(firstName2.getText(), lastName2.getText());
                    c1 = new Couple(p2, p1);
                    d = new Date(Integer.parseInt(year.getText()) - 1900, Integer.parseInt(month.getText()) - 1, Integer.parseInt(day.getText()), Integer.parseInt(hours.getText()), Integer.parseInt(minutes.getText()), 0);
                    W = new Wedding(d, c1, location.getText(), themeChar);

                    String message = "You are invited to the wedding of the groom " + W.getCoupleBeingMarried().getGroom().getFirstName() + " " + W.getCoupleBeingMarried().getGroom().getLastName() + " and the bride " + W.getCoupleBeingMarried().getBride().getFirstName() + " " + W.getCoupleBeingMarried().getBride().getLastName() +
                            " on " + W.getLocalDate() + " at " + W.getLocation() + ". The theme of the wedding is " + W.getTheme() + ".";

                    if(themeChar == "Standard") {

                        JPanel invitation = new JPanel();
                        JLabel invitationLabel = new JLabel(message);
                        invitationLabel.setOpaque(true);
                        invitationLabel.setBackground(Color.WHITE);
                        invitation.add(invitationLabel);
                        JOptionPane.showMessageDialog(null, invitation, "Wedding", JOptionPane.INFORMATION_MESSAGE);

                    }

                    else if(themeChar == "Spooky") {

                        JPanel invitation = new JPanel();
                        JLabel invitationLabel = new JLabel(message);
                        invitationLabel.setOpaque(true);
                        invitationLabel.setBackground(Color.BLACK);
                        invitationLabel.setForeground(Color.WHITE);
                        invitation.add(invitationLabel);
                        JOptionPane.showMessageDialog(null, invitation, "Wedding", JOptionPane.INFORMATION_MESSAGE);

                    }

                    else if(themeChar == "Rustic") {

                        JPanel invitation = new JPanel();
                        JLabel invitationLabel = new JLabel(message);
                        invitationLabel.setOpaque(true);
                        invitationLabel.setBackground(Color.ORANGE);
                        invitation.add(invitationLabel);
                        JOptionPane.showMessageDialog(null, invitation, "Wedding", JOptionPane.INFORMATION_MESSAGE);

                    }

                    else if(themeChar == "Garden") {

                        JPanel invitation = new JPanel();
                        JLabel invitationLabel = new JLabel(message);
                        invitationLabel.setOpaque(true);
                        invitationLabel.setBackground(Color.GREEN);
                        invitation.add(invitationLabel);
                        JOptionPane.showMessageDialog(null, invitation, "Wedding", JOptionPane.INFORMATION_MESSAGE);

                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Invalid Input!");
                    }

                }

            }
        };

        standardTheme.addActionListener(themeListener);
        gardenTheme.addActionListener(themeListener);
        rusticTheme.addActionListener(themeListener);
        spookyTheme.addActionListener(themeListener);

        generateWedding.addActionListener(weddingGen);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestWedding();
            }
        });

    }

}
