import java.text.DecimalFormat;
import java.util.Scanner;

public class Floatty {

	public static void main(String[] args) {
		normalFormatter();
	}
	
	public static void normalFormatter() {
		Scanner s = new Scanner(System.in);
		String f1s = "";
		String f2s = "";
		
		for (int i = 0; i < 2; i++) {
			System.out.print("number " + i + "=");
			if(i==0) {	
				f1s = String.format("%.2f", s.nextFloat());
				System.out.println(f1s);
			} else if(i==1) {
				f2s = String.format("%.2f", s.nextFloat());
				System.out.println(f2s);
			}
		}	
		
		if(f1s.equals(f2s)) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}
	
}
