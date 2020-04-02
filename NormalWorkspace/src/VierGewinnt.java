import java.util.Arrays;
import java.util.Scanner;

public class VierGewinnt {

	static int x = 6;
	static int y = 7;
	static int xmax = 5;
	static int ymax = 6;
	static int[][] spielfeld = new int[x][y];
	static boolean spieler;
	static boolean running = true;

	public static void main(String[] args) {
//		spielfeld[0][0] = 100;
//		spielfeld[xmax][0] = 200;
//		spielfeld[0][ymax] = 300;
//		spielfeld[xmax][ymax] = 400;

		printSpielfeld();
		spielen();
	}
	
	public static void spielen() {
		
		while (running) {
			Scanner s = new Scanner(System.in);
			System.out.println("In welches y möchtest du deine Münze legen (0-6) ?");
			int y = s.nextInt();
			
			while(spielfeld[0][y] != 0) {
				System.out.println("Das Feld ist voll, bitte ein anderes y wählen");
				y = s.nextInt();
			}

			// MÜNZE LEGEN
			for (int i = xmax; i >= 0; i--) {
				if (spielfeld[i][y] == 0) {
					if(spieler) {
						spielfeld[i][y] = 3;
					} else {
						spielfeld[i][y] = 1;
					}
					
					siegesCheck();
					
					System.out.println("MÜNZE GESETZT BEI spielfeld[" + i + "]" + "[" + y + "]");
					break;
				}			
				
			}
			
			spieler = !spieler;

			printSpielfeld();
		}
	}
	
	public static void siegesCheck() {
		System.out.println("Siegescheck");
		int countSpieler = 0;
		int countGegner = 0;
		
		// vertikal
		for (int i = 0; i < y; i++) {
			countSpieler = 0;
			for (int j = 0; j < x; j++) {
				if(spielfeld[j][i] == 1) {
					countSpieler++;
					if(countSpieler == 4) {
						System.out.println("Du hast gewonnen!");
						running = false;
						break;
					}
				}
			}
		}
	
		
		// horizontal
//		for (int i = 0; i < x; i++) {
//			countSpieler = 0;
//			for (int j = 0; j < y; j++) {
//				if(spielfeld[i][j] == 1) {
//					countSpieler++;
//					if(countSpieler == 4) {
//						System.out.println("Du hast gewonnen!");
//						running = false;
//						break;
//					}
//				}
//			}
//		}
		
		// diagonal
	}

	public static void printSpielfeld() {
		for (int i = 0; i < x; i++) {
			System.out.println();
			for (int j = 0; j < y; j++) {
				System.out.print(spielfeld[i][j] + " ");
			}
		}
		System.out.println("\n");
	}
}
