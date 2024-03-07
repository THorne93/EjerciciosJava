package capitulo08.bloque01;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class CrudCoche {

	public static void main(Connection conn) throws SQLException, ParseException {
		boolean end = false;

		do {
			int selector = Utils.BBDD
					.requestNumber("0 - Salir \n1 - Listar todos los registros \n2 - Crear un nuevo Coche"
							+ "\n3 - Modificar un Coche \n4 - Eliminar un Coche", "COCHES");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				Utils.BBDD.consultarTabla(conn, "coche");
				break;
			case 2:
				newCoche(conn);
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

		Utils.BBDD.consultarTabla(conn, "coche");
		int id = Utils.BBDD.getValidID(conn, "coche", "Escribe la ID para borrar");
		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("Delete from " + "tutorialjavacoches.coche " + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void modificar(Connection conn) throws SQLException, ParseException {

		Utils.BBDD.consultarTabla(conn, "coche");
		int id = Utils.BBDD.getValidID(conn, "coche", "Escribe ID");
		Utils.BBDD.consultarTabla(conn, "fabricante");
		int idFab = Utils.BBDD.requestNumber("Insertar nueva ID del Fabricante", "COCHES");
		Utils.BBDD.consultarTablaUnidad(conn, "coche", id);
		String bastidor = Utils.BBDD.requestString("Insertar nuevo bastidor", "COCHES");
		String modelo = Utils.BBDD.requestString("Insertar nuevo modelo", "COCHES");
		String color = Utils.BBDD.requestString("Insertar nuevo color", "COCHES");

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate(
				"update tutorialjavacoches.coche " + "set idfabricante = '" + idFab + "', " + "bastidor = '" + bastidor
						+ "', " + "modelo = '" + modelo + "', " + "color = '" + color + "'\r\n" + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void newCoche(Connection conn) throws SQLException, ParseException {

		Utils.BBDD.consultarTabla(conn, "coche");
		int idFab = Utils.BBDD.requestNumber("Escribe la ID del Fabricante", "COCHES");

		String bastidor = Utils.BBDD.requestString("Escribe el bastidor", "COCHES");
		String modelo = Utils.BBDD.requestString("Escribe el modelo", "COCHES");
		String color = Utils.BBDD.requestString("Escribe el color", "COCHES");

		Statement s = (Statement) conn.createStatement();
		int filasAfectadas = s.executeUpdate(
				"INSERT INTO tutorialjavacoches.coche (id, idfabricante, bastidor, modelo, color) VALUES ("
						+ getSiguienteIdValidoCoche(conn) + ", '" + idFab + "', '" + bastidor + "', '" + modelo + "', '"
						+ color + "')");

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

//	private static void showList(Connection conn) throws SQLException {
//
//			Statement s = (Statement) conn.createStatement();
//			ResultSet rs = s.executeQuery("select * from coche");
//			while (rs.next()) {
//				System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
//			}
//			rs.close();
//			s.close();
//	
//	}

	private static int getSiguienteIdValidoCoche(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) as maximoId " + "from tutorialjavacoches.coche");

		if (rs.next()) {
			return rs.getInt(1) + 1;
		}

		return 1;
	}

}
