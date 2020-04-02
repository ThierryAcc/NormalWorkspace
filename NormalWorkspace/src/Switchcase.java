import java.util.Scanner;

public class Switchcase {

	
	public static void main(String[] args) {
		System.out.println("Zeit?");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		
		//String y = (x >= 5 && x <= 12) ? "Guten Morgen" : (x >= 13 && x <= 17) ? "Guten Tag" : "Gute Nacht";
		
		switch (x) {
			case 5: case 6: case 7: case 8: case 9: case 10: case 11: case 12:
			System.out.println("Guten Morgen"); break;
			
			case 13: case 14: case 15: case 16: case 17:
			System.out.println("Guten Tag"); break;
			
			default:
			System.out.println("Guten Abend"); 
			break;
		}
	}
	
	
}
