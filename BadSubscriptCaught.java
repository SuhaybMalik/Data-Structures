import java.util.Scanner;

public class BadSubscriptCaught {

    public static void main(String[] args) {

        String[] firstNames = new String[10];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < firstNames.length; i++) {

            firstNames[i] = "Name " + (i + 1);

        }

        try {

            System.out.println("Enter the index (0 - 9) of the name you want to see: ");
            int index = sc.nextInt();
            System.out.println(firstNames[index]);

        }

        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Error! Invalid index given.");

        }

    }

}
