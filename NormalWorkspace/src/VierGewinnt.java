import java.util.Scanner;

public class VierGewinnt {

	final static String spielerGewinnt = "Du hast gewonnen";
	final static String gegnerGewinnt = "Gegner hat gewonnen";

	static int countSpieler = 0;
	static int countGegner = 0;
	static int _x = 6;
	static int _y = 7;
	static int[][] spielfeld = new int[_x][_y];
	static boolean spieler;
	static boolean running = true;
	static int gegnerwert = 3;
	static int spielerwert = 1;

	public static void main(String[] args) {
		printSpielfeld();
		spielen();
	}

	public static void spielen() {
		Scanner s = new Scanner(System.in);

		while (running) {
			System.out.println("In welches y möchtest du deine Münze legen (0-6) ?");

			int y = 1000;
			try {
				y = Integer.valueOf(s.nextLine());
			} catch (Exception e) {

			}

			while (!(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5 || y == 6)) {
				System.out.println("Please type a number between 0 and 6");
				try {
					y = Integer.valueOf(s.nextLine());
				} catch (Exception e) {

				}
			}

			while (spielfeld[0][y] != 0) {
				System.out.println("Das Feld ist voll, bitte ein anderes y wählen");
				try {
					y = Integer.valueOf(s.nextLine());
				} catch (Exception e) {

				}
			}

			// MÜNZE LEGEN
			zug(y);

			spieler = !spieler;

			printSpielfeld();
		}

		s.close();
	}

	public static void zug(int y) {
		for (int i = _x - 1; i >= 0; i--) {
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
	}

	// links oben nach rechts unten
	public static void diagonalLORU(int x, int y) {
		countSpieler = 0;
		countGegner = 0;

		for (int i = 0; (x + i < 6) && (y + i < 7); i++) {
			int x2 = (x + i);
			int y2 = (y + i);
			if (spielfeld[x2][y2] == spielerwert) {
				System.out.println("[" + x2 + "]" + "[" + y2 + "]");
				countSpieler++;
				System.out.println("Addition: " + countSpieler);
			} else if (spielfeld[x2][y2] == gegnerwert) {
				System.out.println("[" + x2 + "]" + "[" + y2 + "]");
				countGegner++;
				System.out.println("Addition: " + countGegner);
			}

			else {
				break;
			}
		}

		for (int i = 1; (x - i > 0) && (y - i > 0); i++) {
			int x2 = (x - i);
			int y2 = (y - i);
			if (spielfeld[x2][y2] == spielerwert) {
				countSpieler++;
			} else if (spielfeld[x2][y2] == gegnerwert) {
				countGegner++;
			} else {
				break;
			}
		}

		gewonnen(countSpieler, spielerGewinnt);
		gewonnen(countGegner, gegnerGewinnt);
	}

	// links unten nach rechts oben
	public static void diagonalLURO(int x, int y) {
		countSpieler = 0;
		countGegner = 0;

		for (int i = 0; (x - i > 0) && (y + i < 7); i++) {
			int x2 = (x - i);
			int y2 = (y + i);
			if (spielfeld[x2][y2] == spielerwert) {
				countSpieler++;
			} else if (spielfeld[x2][y2] == gegnerwert) {
				countGegner++;
			} else {
				break;
			}
		}

		for (int i = 0; (x + i < 6) && (y - i > 0); i++) {
			int x2 = (x + i);
			int y2 = (y - i);
			if (spielfeld[x2][y2] == spielerwert) {
				countSpieler++;
			} else if (spielfeld[x2][y2] == gegnerwert) {
				countGegner++;
			} else {
				break;
			}
		}

		gewonnen(countSpieler, spielerGewinnt);
		gewonnen(countGegner, "Gegner hat gewonnen");
	}

	// vertikal
	public static void vertikal() {
		for (int i = 0; i < _y; i++) {
			countSpieler = 0;
			countGegner = 0;
			for (int j = 0; j < _x; j++) {
				if (spielfeld[j][i] == spielerwert) {
					countSpieler++;
					gewonnen(countSpieler, spielerGewinnt);
				} else {
					countSpieler = 0;
				}
				if (spielfeld[j][i] == gegnerwert) {
					countGegner++;
					gewonnen(countGegner, gegnerGewinnt);

				} else {
					countGegner = 0;
				}
			}
		}
	}

	// horizontal
	public static void horizontal() {
		for (int i = 0; i < _x; i++) {
			countSpieler = 0;
			countGegner = 0;
			for (int j = 0; j < _y; j++) {
				if (spielfeld[i][j] == spielerwert) {
					countSpieler++;
					gewonnen(countSpieler, spielerGewinnt);
				} else {
					countSpieler = 0;
				}
				if (spielfeld[i][j] == gegnerwert) {
					countGegner++;
					gewonnen(countGegner, gegnerGewinnt);

				} else {
					countGegner = 0;
				}
			}
		}
	}

	public static void siegesCheck(int x, int y) {
		System.out.println("Siegescheck\n-------------------");

		diagonalLORU(x, y);
		diagonalLURO(x, y);
		vertikal();
		horizontal();
	}

	public static void gewonnen(int countSpieler, String message) {
		if (countSpieler >= 4) {
			System.out.println(message);
			running = false;
		}
	}

	public static void printSpielfeld() {
		for (int i = 0; i < _x; i++) {
			System.out.println();
			for (int j = 0; j < _y; j++) {
				System.out.print(spielfeld[i][j] + " ");
			}
		}
		System.out.println("\n");
	}
}
