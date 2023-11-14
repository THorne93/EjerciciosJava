package captitulo04.bloque07;

public class Ex03CalculaLetraDNI {

	public static void main(String[] args) {

		String s = ("TRWAGMYFPDXBNJZSQVHLCKE");
		char[] letra = s.toCharArray();
		int dni = Utils.Arrays.requestNumber("Dame tu DNI");
		int calculo = dni % 23;
		System.out.println("Tu DNI completo es: " + letra[calculo] + dni);

	}

}
