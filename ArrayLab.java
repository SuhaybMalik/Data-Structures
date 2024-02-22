import java.util.Scanner;

public class ArrayLab {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] arr = new double[20];
        double temp;
        int count = arr.length;

        for (int i = 0; i < arr.length; i++) {

            System.out.println("Enter number " + (i + 1) + ": (99999 to quit)");
            temp = sc.nextDouble();

            if(i == 0) {

                if(temp == 99999) {

                    System.out.println("Error! You left the array empty.");
                    count = i;
                    break;

                }

                else{
                    arr[i] = temp;
                }

            }

            else if(temp == 99999) {
                count = i;
                break;
            }

            else {
                arr[i] = temp;
            }

        }

        System.out.println();

        if(count > 0) {

            for (int i = 0; i < count; i++) {

                System.out.println("Element " + (i + 1) + " = " + arr[i]);

            }

        }

    }

}
