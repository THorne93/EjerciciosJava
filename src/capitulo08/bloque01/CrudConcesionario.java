package capitulo08.bloque01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudConcesionario {

	public static void main(Connection conn) throws SQLException {
		boolean end = false;

		do {
			int selector = Utils.BBDD
					.requestNumber(
							"0 - Salir \n1 - Listar todos los registros \n2 - Crear un nuevo Concesionario"
									+ "\n3 - Modificar un Concesionario \n4 - Eliminar un Concesionario",
							"CONCESIONARIO");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				Utils.BBDD.consultarTabla(conn, "concesionario");
				break;
			case 2:
				newConcesionario(conn);
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

		Utils.BBDD.consultarTabla(conn, "concesionario");

		int id = Utils.BBDD.getValidID(conn, "concesionario", "Escribe la ID para borrar");

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("Delete from " + "tutorialjavacoches.concesionario " + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void modificar(Connection conn) throws SQLException {

		Utils.BBDD.consultarTabla(conn, "concesionario");

		int id = Utils.BBDD.getValidID(conn, "concesionario", "Escribe ID");
		Utils.BBDD.consultarTablaUnidad(conn, "concesionario", id);

		String cif = Utils.BBDD.requestString("Insertar nueva CIF", "CONCESIONARIO");
		String nombre = Utils.BBDD.requestString("Insertar nuevo nombre", "CONCESIONARIO");
		String localidad = Utils.BBDD.requestString("Insertar nueva localidad", "CONCESIONARIO");

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("update tutorialjavacoches.concesionario " + "set cif = '" + cif + "', "
				+ "nombre = '" + nombre + "', " + "localidad = '" + localidad + "'\r\n" + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void newConcesionario(Connection conn) throws SQLException {
		Utils.BBDD.consultarTabla(conn, "concesionario");

		String cif = Utils.BBDD.requestString("Insertar CIF", "CONCESIONARIO");
		String nombre = Utils.BBDD.requestString("Insertar Nombre", "CONCESIONARIO");
		String localidad = Utils.BBDD.requestString("Insertar localidad", "CONCESIONARIO");

		Statement s = (Statement) conn.createStatement();
		int filasAfectadas = s
				.executeUpdate("INSERT INTO tutorialjavacoches.concesionario (id, cif, nombre, localidad) VALUES ("
						+ getSiguienteIdValidoConcesionario(conn) + ", '" + cif + "', '" + nombre + "', '" + localidad
						+ "')");

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

//	private static void showList(Connection conn) throws SQLException {
//
//			Statement s = (Statement) conn.createStatement();
//			ResultSet rs = s.executeQuery("select * from concesionario");
//			while (rs.next()) {
//				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
//			}
//			rs.close();
//			s.close();
//	
//
//	}

	private static int getSiguienteIdValidoConcesionario(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) as maximoId " + "from tutorialjavacoches.concesionario");

		if (rs.next()) {
			return rs.getInt(1) + 1;
		}

		return 1;
	}

}
