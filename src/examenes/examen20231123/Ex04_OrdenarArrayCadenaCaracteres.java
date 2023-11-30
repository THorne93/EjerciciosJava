package examenes.examen20231123;

import java.util.Iterator;

public class Ex04_OrdenarArrayCadenaCaracteres {

	public static void main(String[] args) {

		String[] miArray = {"pera", "manzana", "uva", "naranja", "kiwi"};
		
		compararCadenas(miArray);
		
		for (int i = 0; i < miArray.length; i++) {
			System.out.print(miArray[i] +" ");
		}
	}
	
	
	public static void compararCadenas(String[] miArray) {
		String temp = "";
		boolean hayCambios;
			
		
		do {
			 hayCambios = false;
				for (int i = 0; i < miArray.length-1; i++) {
					String temp1 = miArray[i].toString();
					String temp2 = miArray[i+1].toString();
					if (temp1.charAt(0) > temp2.charAt(0)) {
						hayCambios = true;
						temp = miArray[i+1];
						miArray[i+1] = miArray[i];
						miArray[i] = temp;
					}
				}
		} while (hayCambios == true);
		
	}	
	
	

}