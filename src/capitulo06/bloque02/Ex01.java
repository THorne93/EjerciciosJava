package capitulo06.bloque02;

public class Ex01 {

	public static void main(String[] args) {
		float x = 0;
		float y = 0, z = 0;
		
		while ((y-z) < 0.001) {
			y = (float) Math.sqrt(x);
			z = ((float) Math.log(x) *-1);
			x += 0.001;
		}
		System.out.println("x - " +x +", y - " +y);
		
	}

}
