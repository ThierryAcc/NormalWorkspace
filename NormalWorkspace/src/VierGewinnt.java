import java.util.Scanner;

public class VierGewinnt {

	static int x = 6;
	static int y = 7;
	static int xmax = 5;
	static int ymax = 6;
	static int[][] spielfeld = new int[x][y];
	static boolean spieler;
	static boolean running = true;
	static int gegnerwert = 3;
	static int spielerwert = 1;

	public static void main(String[] args) {
//		spielfeld[0][0] = 100;
//		spielfeld[xmax][0] = 200;
//		spielfeld[0][ymax] = 300;
//		spielfeld[xmax][ymax] = 400;

		printSpielfeld();
		spielen();
	}

	public static void spielen() {
		Scanner s = new Scanner(System.in);

		while (running) {
			System.out.println("In welches y möchtest du deine Münze legen (0-6) ?");
			int y = s.nextInt();

			while (spielfeld[0][y] != 0) {
				System.out.println("Das Feld ist voll, bitte ein anderes y wählen");
				y = s.nextInt();
			}

			while (y > 6) {
				System.out.println("Please type a number between 0 and 6");
				y = s.nextInt();
			}

			// MÜNZE LEGEN
			for (int i = xmax; i >= 0; i--) {
				if (spielfeld[i][y] == 0) {
					if (spieler) {
						spielfeld[i][y] = gegnerwert;
					} else {
						spielfeld[i][y] = spielerwert;
					}

					siegesCheck(i, y);

					System.out.println("MÜNZE GESETZT BEI spielfeld[" + i + "]" + "[" + y + "]");
					break;
				}

			}

			spieler = !spieler;

			printSpielfeld();
		}

		s.close();
	}

	public static void siegesCheck(int x, int y) {
		System.out.println("Siegescheck\n-------------------");
		int countSpieler = 0;
		int countGegner = 0;

		// links oben nach rechts unten
		for (int i = 0; (x + i < 6) && (y + i < 7); i++) {
			int x2 = (x + i);
			int y2 = (y + i);
			if (spielfeld[x2][y2] == spielerwert) {
				System.out.println("[" + x2 + "]" + "[" + y2 + "]");
				countSpieler++;
				System.out.println("Addition: " + countSpieler);
			} else {
				break;
			}
		}

		for (int i = 1; (x - i > 0) && (y - i > 0); i++) {
			int x2 = (x - i);
			int y2 = (y - i);
			if (spielfeld[x2][y2] == spielerwert) {
				System.out.println("[" + x2 + "]" + "[" + y2 + "]");
				countSpieler++;
				System.out.println("Subtraktion: " + countSpieler);
			} else {
				break;
			}
		}

		gewonnen(countSpieler, "Du hast gewonnen");
		gewonnen(countGegner, "Gegner hat gewonnen");
		System.out.println(countSpieler);
		System.out.println(countGegner);

		countSpieler = 0;
		countGegner = 0;

		// links unten nach rechts oben
		for (int i = 0; (x - i > 0) && (y + i < 7); i++) {
			int x2 = (x - i);
			int y2 = (y + i);
			if (spielfeld[x2][y2] == spielerwert) {
				countSpieler++;
				System.out.println("[" + x2 + "]" + "[" + y2 + "]");
				System.out.println("Mix1: " + countSpieler);
			} else {
				break;
			}
		}

		for (int i = 0; (x + i < 6) && (y - i > 0); i++) {
			int x2 = (x + i);
			int y2 = (y - i);
			if (spielfeld[x2][y2] == spielerwert) {
				countSpieler++;
				System.out.println("[" + x2 + "]" + "[" + y2 + "]");
				System.out.println("Mix2: " + countSpieler);
			} else {
				break;
			}
		}
		gewonnen(countSpieler, "Du hast gewonnen");
		gewonnen(countGegner, "Gegner hat gewonnen");
		System.out.println(countSpieler);
		System.out.println(countGegner);

		// vertikal
//		for (int i = 0; i < y; i++) {
//			countSpieler = 0;
//			countGegner = 0;
//			for (int j = 0; j < x; j++) {
//				if (spielfeld[j][i] == spielerwert) {
//					countSpieler++;
//					gewonnen(countSpieler, "Du hast gewonnen");
//				} else {
//					countSpieler = 0;
//				}
//				if (spielfeld[j][i] == gegnerwert) {
//					countGegner++;
//					gewonnen(countSpieler, "Gegner hat gewonnen");
//
//				} else {
//					countGegner = 0;
//				}
//			}
//		}

		// horizontal
//		for (int i = 0; i < x; i++) {
//			countSpieler = 0;
//			countGegner = 0;
//			for (int j = 0; j < y; j++) {
//				if (spielfeld[i][j] == spielerwert) {
//					countSpieler++;
//					if (countSpieler == 4) {
//						System.out.println("Du hast gewonnen!");
//						running = false;
//						break;
//					}
//				} else {
//					countSpieler = 0;
//				}
//				if (spielfeld[i][j] == gegnerwert) {
//					countGegner++;
//					if (countGegner == 4) {
//						System.out.println("Gegner hat gewonnen!");
//						running = false;
//						break;
//					}
//				} else {
//					countGegner = 0;
//				}
//			}
//		}

		// diagonal links oben nach rechts unten

	}

	public static void gewonnen(int countSpieler, String message) {
		if (countSpieler >= 4) {
			System.out.println(message);
			running = false;
		}
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
