package capitulo06.bloque01.wrappers;

public class NumerosEnCodigoHexidecimal {

	public static void main(String[] args) {

		for (int i = 0; i <= 100; i++) {
			System.out.println(i +": " +Integer.toHexString(i));
			
		}
	}

}
