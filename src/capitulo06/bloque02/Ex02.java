package capitulo06.bloque02;

public class Ex02 {

	public static void main(String[] args) {
		float piB = 1;
		float pi = 0;
		float piA = 0;
		float count = 1;
		int alternate = -1;

		while ((piB) > 0.00001) {
			if (pi == 0) {
				pi = 4 / count;
			}
			piA = pi;
			count += 2;
			pi += (4 / count)*alternate;
			alternate *= -1;
			piB = pi - piA;
			if (piB < 0) {
				piB *= -1;
			}
			
			System.out.println(pi);

		}
	}
}
