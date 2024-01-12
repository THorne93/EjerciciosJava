package capitulo06.bloque01.wrappers;

public class Contrasena {

	public static void main(String[] args) {
		String password;
		boolean incorrect = true;
		do {
			
			password = Utils.Arrays.requestString("Intruduzca nueva contraseña \nDebes incluir: \n1. Al menos una mayúscula"
					+ "\n2. Al menos una minúscula \n3. Al menos un dígito \n4. Al menos un carácter no alfanumérico");
			
			incorrect = checkPassword(password, incorrect);
			System.out.println(incorrect);
			
		} while (incorrect);
			
		
	}

	public static boolean checkPassword(String password, boolean incorrect) {
		int mayuscula = 0;
		int minuscula = 0;
		int numero = 0;
		int noAlfanumerico = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				mayuscula += 1;
			}
			else if (Character.isLowerCase(password.charAt(i))) {
				minuscula += 1;
			}
			else if (Character.isDigit(password.charAt(i))) {
				numero += 1;
			}
			else noAlfanumerico += 1;
		}
		System.out.println(mayuscula +" " +minuscula + " " +numero +" " +noAlfanumerico);
		if (mayuscula > 0 && minuscula > 0 && numero > 0 && noAlfanumerico > 0) {
			System.out.println("test");
			incorrect = false;

		} 
		else {
			System.out.println("No has incluido todo");
		}
		return incorrect;
	}
		
	
}
