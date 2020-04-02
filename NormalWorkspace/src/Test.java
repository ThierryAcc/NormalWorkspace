import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		for (int x = 0, y = 0; x < 100 && y < 5; x+=10, y++) {
			System.out.println("x: " + x + ", y: " + y);
		}
		
		int sum = 0;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 4; ++j) {
				sum += j;
				System.out.println(sum);
			}
		}
		
		int[] array1 = {1, 2, 3, 4};
		
		for (int z : array1) {
			System.out.println("foreach: " + z);
		}
				
		// Arrays.deepToString(multiarray);
		// Arrays.toString(singlearray);
		
		
		// ARRAYS
		int[] a1 = new int[10];
		int[] a2 = {1, 2, 3};
		a1[5] = 100;
		/*
		 * System.out.println(a1); System.out.println(a2);
		 * System.out.println(Arrays.toString(a1));
		 * System.out.println(Arrays.toString(a2));
		 */
		
		// MULTI ARRAYS
		int[][] m1 = new int[10][];
		m1[1] = new int[] { 1, 2, 3 };
		m1[3] = new int[4];
		
		int[][] m2 = {{ 1, 2, 3}, {20, 30, 40} }; // m2[0][0] = 1 // m2[0][1] = 2 // m2[1][2] = 40   
		
		
		System.out.println(Arrays.deepToString(m1));
		System.out.println(Arrays.deepToString(m2));
		
		
		
	}
	
	

}
