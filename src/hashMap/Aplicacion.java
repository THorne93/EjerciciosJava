package hashMap;

import java.util.HashMap;
import java.util.Iterator;

public class Aplicacion {

	public static void main(String[] args) {
		
		boolean end = false;
		HashMap<String, Articulo> hm = new HashMap<String, Articulo>();
		
		do {
			int selector = Utils.Arrays.requestNumber(
					"0 - Salir \n1 - Lista de artículos \n2 - Crear un nuevo artículo"
							+ "\n3 - Eliminar un artículo \n4 - Actualizar un artículo");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				showList(hm);
				break;
			case 2:
				newArticle(hm);
				break;
			case 3:
				removeArticle(hm);
				break;
			case 4:
				updateArticle(hm);
				break;
			}
			

		} while (end == false);


	}

	private static void updateArticle(HashMap<String, Articulo> hm) {
		
		String codigoBorrar = Utils.Arrays.requestString("Introduzca el codigo");
		Articulo articuloTemp = hm.get(codigoBorrar);
		hm.remove(codigoBorrar);

		Articulo articuloNewTemp = new Articulo();
		articuloNewTemp.setCodigo(codigoBorrar);
		articuloNewTemp.setNumeroEstante(Utils.Arrays.requestString("Numero estante original: " +articuloTemp.getNumeroEstante() +"\nIntroduzca el nuevo numero de estante"));
		articuloNewTemp.setCantidad(Utils.Arrays.requestNumber("Cantidad original: " +articuloTemp.getCantidad() +"\nIntroduzca la nueva cantidad"));
		hm.put(codigoBorrar, articuloNewTemp);
		
	}

	private static void removeArticle(HashMap<String, Articulo> hm) {

		String codigoBorrar = Utils.Arrays.requestString("Introduzca el codigo");
		hm.remove(codigoBorrar);
		
	}

	private static void newArticle(HashMap<String, Articulo> hm) {
		
		String newCodigo = Utils.Arrays.requestString("Introduzca el codigo");
		Articulo articuloTemp = new Articulo();
		articuloTemp.setCodigo(newCodigo);
		articuloTemp.setNumeroEstante(Utils.Arrays.requestString("Introduzca el numero de estante"));
		articuloTemp.setCantidad(Utils.Arrays.requestNumber("Introduzca la cantidad"));
		hm.put(newCodigo, articuloTemp);
		
	}

	private static void showList(HashMap<String, Articulo> hm) {

		Iterator<Articulo> articulos = hm.values().iterator();
		while (articulos.hasNext()) {
			System.out.println(articulos.next());
		}
		
	}

}
