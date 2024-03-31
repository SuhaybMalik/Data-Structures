import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPatient {

    public static int isInt(Scanner sc) {
        //keeps asking for input until a valid integer is added
        boolean check = false;
        int myInt = 0;

        while(!check) {

            try {

                myInt = sc.nextInt();
                check = true;

            }

            catch(InputMismatchException e) {

                System.out.println("Invalid Input! Must Enter as an Integer. Please Re-Enter: ");
                sc.nextLine();

            }

        }

        return myInt;

    }

    public static int AgeLimit(Scanner sc) {
        //sets and age limit of 0 to 100 on the entered age
        boolean check = false;
        int myAge = isInt(sc);

        while(!check) {

            if(myAge < 0 || myAge > 100) {

                System.out.println("Age must be within 0 and 100. Re-enter: ");
                myAge = isInt(sc);

            }

            else {
                check = true;
            }

        }

        return myAge;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Patient patientA = new Patient();

        System.out.println("Enter Blood Type of Patient B (A, B, AB or O): ");
        String tempBloodType = sc.nextLine().toUpperCase();
        tempBloodType = TestBloodData.stringInEnum(tempBloodType, sc);
        System.out.println("Enter Rh Factor of Patient B (+ or -): ");
        String tempRh = sc.nextLine();
        tempRh = TestBloodData.rhInEnum(tempBloodType, tempRh, sc);

        System.out.println("Enter the ID # of Patient B (as an integer): ");
        //checks whether id input is actually an int
        int id = isInt(sc);
        System.out.println("Enter the age of Patient B (as an integer between 0 and 100): ");
        //checks if input is an integer
        int age = AgeLimit(sc);

        Patient patientB = new Patient(id, age, new BloodData(tempBloodType, tempRh));

        System.out.println("Enter the ID # of Patient C (as an integer): ");
        id = isInt(sc);
        System.out.println("Enter the age of Patient C (as an integer between 0 and 100): ");
        age = AgeLimit(sc);
        Patient patientC = new Patient(id, age, new BloodData());
        sc.close();

        System.out.println("Patient A: " + patientA);
        System.out.println("Patient B: " + patientB);
        System.out.println("Patient C: " + patientC);

    }

}
