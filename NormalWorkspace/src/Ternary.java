import java.util.Scanner;

public class Ternary {

	public static void main(String[] args) {
		System.out.println("Zeit?");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		
		String y = (x >= 5 && x <= 12) ? "Guten Morgen" : (x >= 13 && x <= 17) ? "Guten Tag" : "Gute Nacht";
		System.out.println(y);
		
		
		System.out.println("Exit with 0");
		boolean running = true;
		while(running) {
			int v  = s.nextInt();
			
			running = v!= 0;
		}
		s.close();
		System.out.println("Program finished");
		
		int i = 20;
		do {
			System.out.println("run once: " + i);
		} while (i < 20);
	}

}
