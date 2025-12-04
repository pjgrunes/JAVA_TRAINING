package ph.com.bpi.hello;
import java.util.*;
public class M1_ACT2 {
 
	public static void main(String[] args) {

	      Scanner input = new Scanner(System.in);

	        System.out.print("Enter your age: ");
	        String age = input.nextLine();

	        int ageInt = Integer.parseInt(age);
	        double ageDoub = (double) ageInt;

	        System.out.println("your age as int: " + ageInt);
	        System.out.print("your age as double: " + ageDoub);


	}

}
