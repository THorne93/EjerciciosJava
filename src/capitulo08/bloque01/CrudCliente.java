package capitulo08.bloque01;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CrudCliente {

	public static void main(Connection conn) throws SQLException, ParseException {
		boolean end = false;

		do {
			int selector = Utils.BBDD
					.requestNumber("0 - Salir \n1 - Listar todos los registros \n2 - Crear un nuevo Cliente"
							+ "\n3 - Modificar un Cliente \n4 - Eliminar un Cliente", "CLIENTES");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				Utils.BBDD.consultarTabla(conn, "cliente");
				break;
			case 2:
				newCliente(conn);
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

		Utils.BBDD.consultarTabla(conn, "cliente");
		int id = Utils.BBDD.getValidID(conn, "cliente", "Escribe la ID para borrar");

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("Delete from " + "tutorialjavacoches.cliente " + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void modificar(Connection conn) throws SQLException, ParseException {
		Utils.BBDD.consultarTabla(conn, "cliente");
		int id = Utils.BBDD.getValidID(conn, "cliente", "Escribe ID");
		Utils.BBDD.consultarTablaUnidad(conn, "cliente", id);
		String nombre = Utils.BBDD.requestString("Insertar nuevo Nombre", "CLIENTES");
		String apellido = Utils.BBDD.requestString("Insertar nuevo apellido", "CLIENTES");
		String localidad = Utils.BBDD.requestString("Insertar nueva localidad", "CLIENTES");
		String dni = Utils.BBDD.requestString("Insertar nueva Dni/Nie", "CLIENTES");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = Utils.BBDD.requestString("Insertar nueva fecha de nacimiento (dd/mm/yyyy)", "CLIENTES");
		Date d = sdf2.parse(fecha);
		int activo;
		boolean correct = false;
		do {
			activo = Utils.BBDD.requestNumber("Es activo? (1 - si, 0 - no)", "CLIENTES");
			if (activo == 0 || activo == 1) {
				correct = true;
			}
		} while (correct == false);

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("update tutorialjavacoches.cliente " + "set nombre = '" + nombre + "', "
				+ "apellidos = '" + apellido + "', " + "localidad = '" + localidad + "', " + "dniNie = '" + dni + "', "
				+ "fechaNac = '" + sdf.format(d) + "', " + "activo = '" + activo + "'\r\n" + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void newCliente(Connection conn) throws SQLException, ParseException {

		Utils.BBDD.consultarTabla(conn, "cliente");

		String nombre = Utils.BBDD.requestString("Insertar Nombre", "CLIENTES");
		String apellido = Utils.BBDD.requestString("Insertar apellido", "CLIENTES");
		String localidad = Utils.BBDD.requestString("Insertar localidad", "CLIENTES");
		String dni = Utils.BBDD.requestString("Insertar Dni/Nie", "CLIENTES");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = Utils.BBDD.requestString("Insertar fecha de nacimiento (\"dd/MM/yyyy\")", "CLIENTES");
		Date d = sdf2.parse(fecha);
		int activo;
		boolean correct = false;
		do {
			activo = Utils.BBDD.requestNumber("Es activo? (1 - si, 0 - no)", "CLIENTES");
			if (activo == 0 || activo == 1) {
				correct = true;
			}
		} while (correct == false);

		Statement s = (Statement) conn.createStatement();
		int filasAfectadas = s.executeUpdate(
				"INSERT INTO tutorialjavacoches.cliente (id, nombre, apellidos, localidad, dniNie, fechaNac, activo) VALUES ("
						+ getSiguienteIdValidoCliente(conn) + ", '" + nombre + "', '" + apellido + "', '" + localidad
						+ "', '" + dni + "', '" + sdf.format(d) + "', '" + activo + "')");

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

//	private static void showList(Connection conn) throws SQLException {
//
//		Statement s = (Statement) conn.createStatement();
//		ResultSet rs = s.executeQuery("select * from cliente");
//		while (rs.next()) {
//			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
//					+ " " + rs.getString(5) + " " + rs.getDate(6) + " " + rs.getBoolean(7));
//		}
//		rs.close();
//		s.close();
//
//	}

	private static int getSiguienteIdValidoCliente(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) as maximoId " + "from tutorialjavacoches.cliente");

		if (rs.next()) {
			return rs.getInt(1) + 1;
		}

		return 1;
	}

}
