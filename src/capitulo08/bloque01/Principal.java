package capitulo08.bloque01;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import Utils.BBDD;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		boolean end = false;


		try {
			Connection conn = BBDD.getConexion();
		do {
			int selector = Utils.BBDD
					.requestNumber("0 - Salir \n1 - Fabricante \n2 - Concesionario"
							+ "\n3 - Cliente \n4 - Coche \n5 - Venta","PRINCIPAL" );

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				CrudFabricante.main(conn);
				break;
			case 2:
				CrudConcesionario.main(conn);
				break;
			case 3:
				CrudCliente.main(conn);
				break;
			case 4:
				CrudCoche.main(conn);
				break;
			case 5:
				CrudVenta.main(conn);
				break;
			}

		} while (end == false);
		conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
