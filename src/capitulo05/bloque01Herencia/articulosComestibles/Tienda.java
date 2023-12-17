package capitulo05.bloque01Herencia.articulosComestibles;

public class Tienda {

	public static void main(String[] args) {
		int selector;
		Articulo[] articulos = new Articulo[5];
		
		for (int i = 0; i < articulos.length; i++) {
			
			selector = Utils.Arrays.requestNumber("Pon 1 para perecedero, 2 para no perecedero");
			if (selector == 1) {
				ArticuloPerecedero a = new ArticuloPerecedero();
				a.setFechaCaducidad(Utils.Arrays.requestNumber("Introduzca la fecha de caducidad"));
				articulos[i] = a;

			}
			else	{
				ArticuloNoPerecedero a = new ArticuloNoPerecedero();
				articulos[i] = a;


			}

				
			articulos[i].setNombre(Utils.Arrays.requestString("Introduzca el nombre"));
			articulos[i].setCodigo(Utils.Arrays.requestString("Introduzca el código"));
			articulos[i].setPrecio(Utils.Arrays.requestNumber("Introduzca el precio"));
			System.out.println(articulos[i]);
		}
		
		for (int i = 0; i < articulos.length; i++) {
			System.out.println(articulos[i]);
		}
	}

}
