package capitulo06.bloque03;

public class PeticionNumeros {

	public static void main(String[] args) {

		pideNumeroPar();

	}

	private static void pideNumeroPar() {
		
		int numero = Utils.Arrays.requestNumber("Introduzca un número");
		
		try {
			checkEven(numero);
			System.out.println("El número " +numero +" es par");
		} catch (IllegalArgumentException e) {
			System.out.println("Mensaje de error: " +e.getLocalizedMessage());
		}
		
	}

	private static void checkEven(int numero) {
		if (numero % 2 != 0) {
			throw new IllegalArgumentException(numero +" es impar");
		}
	}

}
