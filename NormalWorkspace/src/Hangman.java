import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	
	public static void main(String[] args) {
		
		// CREATE RANDOM WORD
		Random r = new Random();
		String[] words = {"easy", "mukibude", "discotier", "löwenpferd", "pooker"};
		char[] secret = words[r.nextInt(4)].toCharArray();
		char[] progress = new char[secret.length];
		for (int i = 0; i < progress.length; i++) {
			progress[i] = '_';
		}
		
		System.out.println(Arrays.toString(secret));
		System.out.println(Arrays.toString(progress));
				
		// PREPARE VARIABLES
		Scanner s = new Scanner(System.in);
		int errorcounter = 0;
		boolean running = true;
		
		// EXECUTE
		while(running) {			
			boolean hit = false;
			System.out.print("Input the next character: ");
			char input = s.nextLine().toCharArray()[0];
			
			
			
			for (int i = 0; i < secret.length; i++) {
				if(input == secret[i]) {
					progress[i] = input;
					hit = true;
					System.out.println("Match at position: " + i);
					System.out.println("Your progress: " + Arrays.toString(progress));
					
					if(Arrays.equals(progress, secret)) {
						System.out.println("-----------------");
						System.out.println("DAMN, YOU ROCK!");
						i = secret.length;
						running = false;
					}
				}
				
				if(errorcounter == 4) {
						System.out.println("-----------------");
						System.out.println("HANG THIS MAN");
						running = false;
						i = secret.length;
				}
			}	

			if(!hit) {
				System.out.println("Mäckk wrong!");
				errorcounter++;
			}
		}
		
		s.close();
	}
}

