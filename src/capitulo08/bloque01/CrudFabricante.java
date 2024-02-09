package capitulo08.bloque01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudFabricante {

	public static void main(Connection conn) throws SQLException {
		boolean end = false;

		do {
			int selector = Utils.BBDD
					.requestNumber("0 - Salir \n1 - Listar todos los registros \n2 - Crear un nuevo Fabricante"
							+ "\n3 - Modificar un Fabricante \n4 - Eliminar un Fabricante", "FABRICANTE");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				Utils.BBDD.consultarTabla(conn, "fabricante");
				break;
			case 2:
				newFabricante(conn);
				break;
			case 3:
				modificar(conn);
				break;
			case 4:
				remove(conn);
				break;
			}

		} while (end == false);

	}

	private static void remove(Connection conn) throws SQLException {
		Utils.BBDD.consultarTabla(conn, "fabricante");

		int id = Utils.BBDD.getValidID(conn, "fabricante", "Escribe la ID para borrar");

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("Delete from " + "tutorialjavacoches.fabricante " + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void modificar(Connection conn) throws SQLException {

		Utils.BBDD.consultarTabla(conn, "fabricante");

		int id = Utils.BBDD.getValidID(conn, "fabricante", "Escribe ID");
		Utils.BBDD.consultarTablaUnidad(conn, "fabricante", id);

		String cif = Utils.BBDD.requestString("Insertar nueva CIF", "FABRICANTE");
		String nombre = Utils.BBDD.requestString("Insertar nuevo Nombre", "FABRICANTE");

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("update tutorialjavacoches.fabricante " + "set cif = '" + cif + "', "
				+ "nombre = '" + nombre + "'\r\n" + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void newFabricante(Connection conn) throws SQLException {

		Utils.BBDD.consultarTabla(conn, "fabricante");

		String cif = Utils.BBDD.requestString("Insertar CIF", "FABRICANTE");
		String nombre = Utils.BBDD.requestString("Insertar Nombre", "FABRICANTE");

		Statement s = (Statement) conn.createStatement();
		int filasAfectadas = s.executeUpdate("INSERT INTO tutorialjavacoches.fabricante (id, cif, nombre) VALUES ("
				+ getSiguienteIdValidoFabricante(conn) + ", '" + cif + "', '" + nombre + "')");

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

//	public static void showList(Connection conn) throws SQLException {
//
//
//			Statement s = (Statement) conn.createStatement();
//			ResultSet rs = s.executeQuery("select * from fabricante");
//			while (rs.next()) {
//				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
//			}
//			rs.close();
//			s.close();
//
//	
//	}

	private static int getSiguienteIdValidoFabricante(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) as maximoId " + "from tutorialjavacoches.fabricante");

		if (rs.next()) {
			return rs.getInt(1) + 1;
		}

		return 1;
	}

}