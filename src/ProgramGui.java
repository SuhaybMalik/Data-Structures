import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramGui extends JFrame {

    //initializing window size and other useful variables
    int width = 1200;
    int height = 600;
    String tempMessage;
    Patient patient1 = new Patient();
    Patient patient2;
    Patient patient3;
    String errorMessage = "Please Re-Check Input in Fields: \n";

    //making components to use in the GUI window
    JLabel titleText = new JLabel("Patient Information: ");
    JButton generateID1 = new JButton("Generate Patient 1 ID");
    JTextField patient2IdField = new JTextField();
    JTextField patient2AgeField = new JTextField();
    JTextField patient2TypeField = new JTextField();
    JTextField patient2RhField = new JTextField();
    JButton generateID2 = new JButton("Generate Patient 2 ID");
    JTextField patient3IdField = new JTextField();
    JTextField patient3AgeField = new JTextField();
    JButton generateID3 = new JButton("Generate Patient 3 ID");

    public static boolean bloodTypeInEnum(String s) {
        //checks whether the string is in the enum and thus if it's a blood type
        try {

            BloodGroups.valueOf(s);
            return true;

        }

        catch(IllegalArgumentException e) {
            return false;
        }

    }

    public static boolean rhInEnum(String s) {
        //checks whether the rh is valid
        if(BloodGroups.O.getPositive().equals(s) || BloodGroups.O.getNegative().equals(s)) {
            return true;
        }

        else {
            return false;
        }

    }

    public static boolean isInt(String s) {

        try {

            Integer.parseInt(s);
            return true;

        }

        catch(Exception e) {
            return false;
        }

    }

    public static boolean isAge(String s) {
        //checks if age is an int b/w 0 and 100
        if(isInt(s)) {

            if(Integer.parseInt(s) < 0 || Integer.parseInt(s) > 100) {
                return false;
            }

            else {
                return true;
            }

        }

        else {
            return false;
        }

    }

    public ProgramGui() {

        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Patient ID Generator");

        //making our title bold
        titleText.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = titleText.getFont();
        titleText.setFont(new Font(font.getName(), Font.BOLD, 20));

        //create a grid layout for the components
        JPanel panel = new JPanel(new GridLayout(19, 1));

        panel.add(titleText);
        panel.add(new JLabel(" Patient 1: (All Default Fields): "));
        panel.add(generateID1);

        panel.add(new JLabel(" Patient 2 (All User Input Fields): "));
        panel.add(new JLabel(" Enter ID # (as an integer): "));
        panel.add(patient2IdField);
        panel.add(new JLabel(" Enter age (as an integer between 0 and 100): "));
        panel.add(patient2AgeField);
        panel.add(new JLabel(" Patient Blood Type (A, B, AB or O): "));
        panel.add(patient2TypeField);
        panel.add(new JLabel(" Patient Rh Factor (+ or -): "));
        panel.add(patient2RhField);
        panel.add(generateID2);

        panel.add(new JLabel(" Patient 3 (User Id and Age, default Blood Type): "));
        panel.add(new JLabel(" Enter ID # (as an integer): "));
        panel.add(patient3IdField);
        panel.add(new JLabel(" Enter age (as an integer between 0 and 100): "));
        panel.add(patient3AgeField);
        panel.add(generateID3);

        ActionListener generateIDListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == generateID1) {

                    tempMessage = "ID #: " + patient1.getIdNumber() + "\n"
                            + "Age: " + patient1.getAge() + "\n" +
                            "Blood Type: " + patient1.getBloodData().toString();

                    JOptionPane.showMessageDialog(null, tempMessage);

                }

                else if(e.getSource() == generateID2) {

                    errorMessage = "Please Re-Check Input in Fields: \n";
                    if(!bloodTypeInEnum(patient2TypeField.getText().toUpperCase()) || !rhInEnum(patient2RhField.getText()) || !isInt(patient2IdField.getText()) || !isAge(patient2AgeField.getText())) {

                        if(!isInt(patient2IdField.getText())) {
                            errorMessage += "Invalid ID! Needs to be an Integer! \n";
                        }

                        if(!isAge(patient2AgeField.getText())) {
                            errorMessage += "Invalid Age. Must be an Integer from 0 to 100! \n";
                        }

                        if(!bloodTypeInEnum(patient2TypeField.getText().toUpperCase())) {
                            errorMessage += "Invalid Blood type. Must be A, B, AB or O! \n";
                        }

                        if(!rhInEnum(patient2RhField.getText())) {
                            errorMessage += "Invalid Rh Factor. Must be + or - \n";
                        }

                        JOptionPane.showMessageDialog(null, errorMessage);

                    }

                    else {

                        patient2 = new Patient(Integer.parseInt(patient2IdField.getText()), Integer.parseInt(patient2AgeField.getText()), new BloodData(patient2TypeField.getText().toUpperCase(), patient2RhField.getText()));

                        tempMessage = "ID #: " + patient2.getIdNumber() + "\n"
                                + "Age: " + patient2.getAge() + "\n" +
                                "Blood Type: " + patient2.getBloodData().toString();

                        JOptionPane.showMessageDialog(null, tempMessage);

                    }

                }

                else if(e.getSource() == generateID3) {

                    errorMessage = "Please Re-Check Input in Fields: \n";
                    if(!isInt(patient3IdField.getText()) || !isAge(patient3AgeField.getText())) {

                        if(!isInt(patient3IdField.getText())) {
                            errorMessage += "Invalid ID! Needs to be an Integer! \n";
                        }

                        if(!isAge(patient3AgeField.getText())) {
                            errorMessage += "Invalid Age. Must be an Integer from 0 to 100! \n";
                        }

                        JOptionPane.showMessageDialog(null, errorMessage);

                    }

                    else {

                        patient3 = new Patient(Integer.parseInt(patient3IdField.getText()), Integer.parseInt(patient3AgeField.getText()), new BloodData());

                        tempMessage = "ID #: " + patient3.getIdNumber() + "\n"
                                + "Age: " + patient3.getAge() + "\n" +
                                "Blood Type: " + patient3.getBloodData().toString();

                        JOptionPane.showMessageDialog(null, tempMessage);

                    }

                }

            }
        };

        generateID1.addActionListener(generateIDListener);
        generateID2.addActionListener(generateIDListener);
        generateID3.addActionListener(generateIDListener);

        getContentPane().add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgramGui();
            }
        });

    }

}
