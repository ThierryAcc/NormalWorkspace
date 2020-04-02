import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Schatzsuche {

	static int[] coordinates = new int[3];
	static int treasure = 1;
	static int[] treasurecoordinates = new int[3];
	static Random r = new Random();


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Input size of your 3D Playground: ");
		int size = s.nextInt();

		int[] x = new int[size];
		int[] y = new int[size];
		int[] z = new int[size];

		int r1 = r.nextInt(size);
		int r2 = r.nextInt(size);
		int r3 = r.nextInt(size);
		x[r1] = treasure;
		y[r2] = treasure;
		z[r3] = treasure;
		treasurecoordinates[0] = r1;
		treasurecoordinates[1] = r2;
		treasurecoordinates[2] = r3;
		System.out.println(Arrays.toString(treasurecoordinates));
		
		// STRATEGY?
		System.out.println("Strategy Loop=1 or Random=2?");
		int strategy = s.nextInt();
		System.out.println(strategy);
		if(strategy == 1) {
			loopTreasure(x, size, 0);
			loopTreasure(y, size, 1);
			loopTreasure(z, size, 2);
			System.out.println("Loop has found it here: " + Arrays.toString(coordinates));
		} else if (strategy == 2) {
			System.out.println("How many tries? ");
			int tries = s.nextInt();
			randomTreasure(size, tries);
		}
		
	}
	
	public static void randomTreasure(int size, int tries) {
		boolean found = false;
		for (int i = 0; i < tries; i++) {
			int x = r.nextInt(size);
			int y = r.nextInt(size);
			int z = r.nextInt(size);
			int[] trier = {x,y,z};
			
			if(Arrays.equals(treasurecoordinates, trier)) {
				System.out.println("Found at: " + Arrays.toString(trier));
				found = true;
				break;
			}
		}
		
		if (!found) {
			System.out.println("not found");
		}
		
	}

	public static void loopTreasure(int[] array, int size, int counter) {
		for (int i = 0; i < size; i++) {
			if (array[i] == treasure) {
				coordinates[counter] = i;
			}
		}
	}

}
