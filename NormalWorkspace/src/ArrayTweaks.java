
public class ArrayTweaks {

	public static void main(String[] args) {
		System.out.println("hallo");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				int k = i + j;
				if(k == 2) {
					continue;
				}
				System.out.println(i + " " + j);
				
			}
		}
	}

}
