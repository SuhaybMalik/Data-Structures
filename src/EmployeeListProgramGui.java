import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeListProgramGui extends JFrame {

    //initializing variables such as window size
    int width = 1200;
    int height = 600;
    String tempEmployeeList = " Current List: ";
    String errorMessage = "Please Re-Check Input in Fields: \n";
    EmployeeLinkedList list = new EmployeeLinkedList();

    //creating assets, including buttons for the program
    JLabel titleLabel = new JLabel("Employee Tracker");
    JLabel listLabel = new JLabel(tempEmployeeList);
    JTextField employeeNameField = new JTextField("");
    JTextField employeeIDField = new JTextField("");
    JTextField employeeSalaryField = new JTextField("");
    JTextField copyKeyField = new JTextField("");
    JTextField duplicateKeyField = new JTextField("");
    JTextField afterKeyField = new JTextField("");
    JButton clearButton = new JButton("Clear List");
    JButton insertButton = new JButton("Insert Employee");
    JButton maxSalaryButton = new JButton("Maximum Salary");
    JButton copyButton = new JButton("Copy Starting From Key");
    JButton removeDuplicateButton = new JButton("Remove All Instances");
    JButton removeAfterButton = new JButton("Remove Next Employee");

    public static boolean isInt(String s) {

        try {

            Integer.parseInt(s);
            return true;

        }

        catch(Exception e) {
            return false;
        }

    }

    public static boolean isSalary(String s) {

        if(isInt(s)) {

            if(Integer.parseInt(s) < 10000 || Integer.parseInt(s) > 150000) {
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

    public static boolean isID(String s) {

        if(isInt(s)) {

            if(Integer.parseInt(s) < 0 || Integer.parseInt(s) >= 10000) {
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

    public EmployeeListProgramGui() {

        super("Employee Tracker");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Employee Tracker");

        //adjusting title font
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = titleLabel.getFont();
        titleLabel.setFont(new Font(font.getName(), Font.BOLD, 20));

        //creating a panel wth grid layout
        JPanel panel = new JPanel(new GridLayout(20, 1));

        //adding all assets to panel in order
        panel.add(titleLabel);
        panel.add(new JLabel(" Enter Employee Name (as a string): "));
        panel.add(employeeNameField);
        panel.add(new JLabel(" Enter Employee ID# (Integer between 0 and 9999 inclusive): "));
        panel.add(employeeIDField);
        panel.add(new JLabel(" Enter Employee Salary in $ (Integer between 10000 and 150000 inclusive): "));
        panel.add(employeeSalaryField);
        panel.add(listLabel);
        panel.add(insertButton);
        panel.add(clearButton);
        panel.add(new JLabel(" Enter Employee Name to Start a Copied List From (as a case sensitive string): "));
        panel.add(copyKeyField);
        panel.add(copyButton);
        panel.add(new JLabel(" Enter Employee Name to Remove From List (as a case sensitive string): "));
        panel.add(duplicateKeyField);
        panel.add(removeDuplicateButton);
        panel.add(new JLabel(" Enter Employee Name to Remove the One That Comes After (as a case sensitive string): "));
        panel.add(afterKeyField);
        panel.add(removeAfterButton);
        panel.add(maxSalaryButton);

        ActionListener insertNodeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                errorMessage = "Please Re-Check Input in Fields: \n";
                if(!isSalary(employeeSalaryField.getText()) || !isID(employeeIDField.getText()) || employeeNameField.getText().isEmpty()) {

                    if(employeeNameField.getText().isEmpty()) {
                        errorMessage += "No Name Has Been Entered!\n";
                    }

                    if(!isID(employeeIDField.getText())) {
                        errorMessage += "Must Enter Id as Integer Between 0 and 9999 Inclusive!\n";
                    }

                    if(!isSalary(employeeSalaryField.getText())) {
                        errorMessage += "Must Enter Salary as an Integer Between 10000 and 150000 Inclusive!\n";
                    }

                    JOptionPane.showMessageDialog(null, errorMessage);

                }

                else {

                    tempEmployeeList = " Current List: ";
                    list.insertNode(new Employee(employeeNameField.getText() , Integer.parseInt(employeeIDField.getText()), Integer.parseInt(employeeSalaryField.getText())));
                    tempEmployeeList += list.listFormat();
                    listLabel.setText(tempEmployeeList);

                }

            }
        };

        ActionListener clearListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                list.clear();
                tempEmployeeList = " Current List: ";
                listLabel.setText(tempEmployeeList);

            }
        };

        ActionListener copyListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if(list.searchNode(copyKeyField.getText()) != null) {

                        EmployeeLinkedList copiedList = list.copy(list.searchNode(copyKeyField.getText()));
                        String copiedDisplay = copiedList.toString();
                        JOptionPane.showMessageDialog(null, copiedDisplay);

                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Employee not Found in List");
                    }

                }

                catch(NullPointerException e1) {

                    JOptionPane.showMessageDialog(null, "Employee not Found in List");

                }

            }
        };

        ActionListener removeDuplicateListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if(list.searchNode(duplicateKeyField.getText()) != null) {

                        list.removeDuplicate(duplicateKeyField.getText());
                        tempEmployeeList = " Current List: ";
                        tempEmployeeList += list.listFormat();
                        listLabel.setText(tempEmployeeList);

                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Employee not Found in List");
                    }

                }

                catch(NullPointerException e1) {

                    JOptionPane.showMessageDialog(null, "Employee not Found in List");

                }

            }
        };

        ActionListener removeAfterListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if(list.searchNode(afterKeyField.getText()) != null) {

                        list.removeAfter(list.searchNode(afterKeyField.getText()));
                        tempEmployeeList = " Current List: ";
                        tempEmployeeList += list.listFormat();
                        listLabel.setText(tempEmployeeList);

                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Employee not Found in List");
                    }

                }

                catch(NullPointerException e1) {

                    JOptionPane.showMessageDialog(null, "Employee not Found in List");

                }

            }
        };

        ActionListener maxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(list.max(list.getHead()) == 0) {
                    JOptionPane.showMessageDialog(null, "No Employees in List!");
                }

                else {
                    JOptionPane.showMessageDialog(null, "Highest Salary is: $" + list.max(list.getHead()));
                }

            }
        };

        insertButton.addActionListener(insertNodeListener);
        clearButton.addActionListener(clearListListener);
        copyButton.addActionListener(copyListener);
        removeDuplicateButton.addActionListener(removeDuplicateListener);
        removeAfterButton.addActionListener(removeAfterListener);
        maxSalaryButton.addActionListener(maxListener);

        getContentPane().add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeListProgramGui();
            }
        });

    }

}
