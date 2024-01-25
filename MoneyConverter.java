import java.util.Scanner;
import static java.lang.Character.isDigit;

public class MoneyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean is_double = false;
        boolean digit = true;
        int point_counter = 0;

        // taking user input using scanner object
        System.out.print("Enter the Amount : $");
        String temp_amount = sc.nextLine();

        while(!is_double) {

            digit = true;
            point_counter = 0;

            for(int i = 0; i < temp_amount.length(); i++) {

                if(!isDigit(temp_amount.charAt(i)) && temp_amount.charAt((i)) != '.') {
                    digit = false;
                }

                else if(temp_amount.charAt(i) == '.') {

                    point_counter += 1;

                    if(point_counter > 1) {
                        digit = false;
                    }

                }

            }

            if(!digit) {

                System.out.print("Invalid Input! Please Re-enter: $");
                temp_amount = sc.nextLine();

            }

            else {
                is_double = true;
            }

        }

        double amount = Double.parseDouble(temp_amount);
        int remaining = (int) (Math.round(amount * 100));

        // finding the number of each coin and remaining cents afterward
        int quarters = (remaining / 25);
        remaining %= 25;

        int dimes = (remaining / 10);
        remaining %= 10;

        int nickels = (remaining / 5);
        remaining %= 5;

        int cents = remaining;

        System.out.println("\nChange:");

        // display the number of each coin and does not display if it is zero

        if(quarters == 1) {
            System.out.println(quarters + " quarter");
        }

        else if(quarters > 1) {
            System.out.println(quarters + " quarters");
        }

        if(dimes == 1) {
            System.out.println(dimes + " dime");
        }

        else if(dimes > 1) {
            System.out.println(dimes + " dimes");
        }

        // can only have either 1 or 0 nickels
        if(nickels == 1){
            System.out.println(nickels + " nickel");
        }

        if(cents == 1) {
            System.out.println(cents + " cent");
        }

        else if(cents > 1) {
            System.out.println(cents + " cents");
        }

        System.out.println("Given this change,the weight of your wallet will be: ");

        double weight_grams = (quarters * 5.67) + (dimes * 2.268) + (nickels * 5) + (cents * 2.5);

        System.out.println(weight_grams + " grams");
        System.out.println((weight_grams/1000) + " kilograms");
        System.out.println((weight_grams*0.00220462) + " pounds");

    }

}