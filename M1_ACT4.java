
/**
 *
 */
package ph.com.bpi.hello;

/**
 *
 */
import java.util.Scanner;
public class M1_ACT4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        // Conditional statements
        if (age < 18) {
            System.out.println("Minor");
        } else if (age >= 18 && age <= 59) {
            System.out.println("Adult");
        } else {
            System.out.println("Senior");
        }
    }
}
