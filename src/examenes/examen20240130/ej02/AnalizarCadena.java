package examenes.examen20240130.ej02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import hashMap.Articulo;

public class AnalizarCadena {
	



	public static void main(String[] args) {
		HashMap<String, List<Character>> hm = new HashMap<String, List<Character>>();

		String input = Utils.Arrays.requestString("Introduzca un frase");
		List<Character> mayuscula = new ArrayList<Character>();
		List<Character> menuscula = new ArrayList<Character>();
		List<Character> integer = new ArrayList<Character>();
		List<Character> especial = new ArrayList<Character>();
		
		
		
		
		for (int i = 0; i < input.length(); i++) {
			if (Character.isUpperCase(input.charAt(i))) {
				mayuscula.add(input.charAt(i));
			}
			else if (Character.isLowerCase(input.charAt(i))) {
				menuscula.add(input.charAt(i));
			}
			else if (Character.isDigit(input.charAt(i))) {
				integer.add(input.charAt(i));
			}
			else {
				especial.add(input.charAt(i));
			}
		}
		

		
		hm.put("Letra mayúscula", mayuscula);
		hm.put("Letra minúscula", menuscula);
		hm.put("Dígito", integer);
		hm.put("Otro", especial);

		
		Iterator<List<Character>> lists = hm.values().iterator();
		while (lists.hasNext()) {
			System.out.println(lists.next());
;

		}
		
		

	}

}
