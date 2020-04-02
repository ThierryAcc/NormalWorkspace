import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Schatzsuche {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int treasure = 1;
		
		System.out.println("Input size of your 3D Playground: ");
		int size = s.nextInt();
		
		int[] x = new int[size];
		int[] y = new int[size];
		int[] z = new int[size];
		
		Random r = new Random();
		x[r.nextInt(size)] = treasure;
		y[r.nextInt(size)] = treasure;
		z[r.nextInt(size)] = treasure;
		
		int[] coordinates = new int[3];
		
		// i for x
		for (int i = 0; i < size; i++) {
			if(x[i] == treasure) {
				coordinates[0] = i;
				
				// j for y
				for (int j = 0; j < size; j++) {	
					if(y[j] == treasure) {
						coordinates[1] = j;
						
						// k for z
						for (int k = 0; k < size; k++) {
							if(z[k] == treasure) {
								coordinates[2] = k;
							}
						}
					}
				}
			}
		}
		
		System.out.println("Treasure was found here: ");
		System.out.println(Arrays.toString(coordinates));
		

	}

}
