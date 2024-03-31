import java.util.Scanner;

public class TestBloodData {

    public static String stringInEnum(String tempBloodType, Scanner sc) {

        boolean check = false;

        while(!check) {

            try {

                BloodGroups.valueOf(tempBloodType);
                check = true;

            }

            catch (IllegalArgumentException e) {

                System.out.println("Invalid Blood Type Entered! Please Re-enter (A, B, AB or O): ");
                tempBloodType = sc.nextLine().toUpperCase();

            }

        }

        return tempBloodType;

    }

    public static String rhInEnum(String tempBloodType, String tempRh, Scanner sc) {

        boolean check = false;

        while(!check) {

            if(!BloodGroups.valueOf(tempBloodType).getNegative().equals(tempRh) && !BloodGroups.valueOf(tempBloodType).getPositive().equals(tempRh)) {

                System.out.println("Invalid Input! Please Re-Enter Rh (+ or -): ");
                tempRh = sc.nextLine();

            }

            else {
                check = true;
            }

        }

        return tempRh;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Blood Type for Data A (A, B, AB or O): ");
        String tempBloodType = sc.nextLine().toUpperCase();

        //checks whether the bloodtype entered is in the enum
        tempBloodType  = stringInEnum(tempBloodType, sc);

        System.out.println("Enter the Rh factor for Data A (+ or -): ");
        String tempRh = sc.nextLine();

        //checks whether user entered rh is in the enum (+ or -)
        tempRh = rhInEnum(tempBloodType, tempRh, sc);

        sc.close();
        BloodData dataA = new BloodData(tempBloodType, tempRh);
        BloodData dataB = new BloodData();

        System.out.println("Data A: " + dataA);
        System.out.println("Default Data B: " + dataB);

        //sets the second blood data to user input
        dataB.setBloodType(tempBloodType);
        dataB .setRh(tempRh);

        System.out.println("After changing Data B: \n" + dataB);

    }

}
