package ph.com.bpi.hello;

public class M1_ACT5 {

		public static void main(String[] args) {
			int res = calcSum(1,50);
			System.out.println("Sum = " + res);
	        

		}
		
		public static int calcSum(int a, int b) {
			int sum = 0;

			for (int i = a; i <= b; i++) {
	            sum += i;
	        }
			
			return sum;

	}

}
