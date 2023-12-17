package capitulo05.bloque01Herencia.coleccionAntiguedades;

import capitulo05.bloque01Herencia.articulosComestibles.Articulo;

public class ColeccionAntiguedades {

	public static void main(String[] args) {

		boolean close = false;
		int cantidad = 0;
		int selector = 0;
		
		
		cantidad = Utils.Arrays.requestNumber("Cuántos Antiguedades vas a añadir?");
		Antiguedad[] antiguedades = new Antiguedad[cantidad];
		

		for (int i = 0; i < antiguedades.length; i++) {
			crearAntiguedad(antiguedades, i);		
			System.out.println(antiguedades[i]);
		}
			
			
	}




	private static void crearAntiguedad(Antiguedad[] antiguedades, int i) {
		int selector;
		selector = Utils.Arrays.requestNumber("1 para Joya \n2 para Libro \n3 para Moneda \n4 para Cabeza");
		switch (selector) {
		case 1:
			Joya j = new Joya();
			j.pideDatos();
			antiguedades[i] = j;
			break;
		case 2:
			Libro l = new Libro();
			l.pideDatos();
			antiguedades[i] = l;
			break;
		case 3:
			Moneda m = new Moneda();
			m.pideDatos();
			antiguedades[i] = m;
			break;
		case 4:
			CabezaReducida c = new CabezaReducida();
			c.pideDatos();
			antiguedades[i] = c;
			break;
		}
	}

}
