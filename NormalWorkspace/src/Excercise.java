import java.util.Arrays;
import java.util.Random;

public class Excercise {

	public static void main(String[] args) {
		Random r = new Random();
		int[] numbers = new int[25];
		System.out.println(Arrays.toString(numbers));
		
		for (int i = 0; i < 1000; i++) {
			int number = 1 + r.nextInt(25);
			numbers[number-1]++;
		}
		
		System.out.println(Arrays.toString(numbers));
		
	}

}
