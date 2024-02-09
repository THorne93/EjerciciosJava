package capitulo08.bloque01;

import java.sql.Connection;
import java.util.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CrudVenta {

	public static void main(Connection conn) throws SQLException, ParseException {
		boolean end = false;

		do {
			int selector = Utils.BBDD
					.requestNumber("0 - Salir \n1 - Listar todos los registros \n2 - Crear un nuevo Venta"
							+ "\n3 - Modificar un Venta \n4 - Eliminar un Venta", "VENTAS");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				showList(conn);
				break;
			case 2:
				newVenta(conn);
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

		Utils.BBDD.consultarTabla(conn, "venta");
		int id = Utils.BBDD.getValidID(conn, "venta", "Escribe la ID para borrar");

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("Delete from " + "tutorialjavacoches.venta " + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void modificar(Connection conn) throws SQLException, ParseException {

		Utils.BBDD.consultarTabla(conn, "venta");

		int id = Utils.BBDD.getValidID(conn, "venta", "Escribe ID");
		Utils.BBDD.consultarTabla(conn, "cliente");

		int idCliente = Utils.BBDD.requestNumber("Insertar nueva ID del Cliente", "VENTAS");
		Utils.BBDD.consultarTabla(conn, "concesionario");
		int idConc = Utils.BBDD.requestNumber("Insertar nueva ID del Concesionario", "VENTAS");
		Utils.BBDD.consultarTabla(conn, "coche");
		int idCoche = Utils.BBDD.requestNumber("Insertar nueva ID del Coche", "VENTAS");
		Utils.BBDD.consultarTablaUnidad(conn, "venta", id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = Utils.BBDD.requestString("Insertar fecha de venta (\"dd/MM/yyyy\")", "VENTAS");
		Date d = sdf2.parse(fecha);
		float precioVenta = Utils.BBDD.requestFloat("Insertar precio de venta", "VENTAS");

		Statement s = (Statement) conn.createStatement();

		int filasAfectadas = s.executeUpdate("update tutorialjavacoches.venta " + "set idCliente = '" + idCliente
				+ "', " + "idConcesionario = '" + idConc + "', " + "idCoche = '" + idCoche + "', " + "fecha = '"
				+ sdf.format(d) + "', " + "precioVenta = '" + precioVenta + "'\r\n" + "where id = " + id);

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void newVenta(Connection conn) throws SQLException, ParseException {
		Utils.BBDD.consultarTabla(conn, "cliente");

		int idCliente = Utils.BBDD.requestNumber("Insertar nueva ID del Cliente", "VENTAS");
		Utils.BBDD.consultarTabla(conn, "concesionario");

		int idConc = Utils.BBDD.requestNumber("Insertar nueva ID del Concesionario", "VENTAS");
		Utils.BBDD.consultarTabla(conn, "coche");

		int idCoche = Utils.BBDD.requestNumber("Insertar nueva ID del Coche", "VENTAS");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = Utils.BBDD.requestString("Insertar fecha de venta (\"dd/MM/yyyy\")", "VENTAS");
		Date d = sdf2.parse(fecha);
		float precioVenta = Utils.BBDD.requestFloat("Insertar precio de venta", "VENTAS");

		Statement s = (Statement) conn.createStatement();
		int filasAfectadas = s.executeUpdate(
				"INSERT INTO tutorialjavacoches.venta (id, idCliente, idConcesionario, idCoche, fecha, precioVenta) VALUES ("
						+ getSiguienteIdValidoVenta(conn) + ", '" + idCliente + "', '" + idConc + "', '" + idCoche
						+ "', '" + fecha + "', '" + precioVenta + "')");

		System.out.println("Filas afectadas: " + filasAfectadas);

		s.close();

	}

	private static void showList(Connection conn) throws SQLException {

		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from venta");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " "
					+ rs.getString(5) + " " + rs.getFloat(6));
		}
		rs.close();
		s.close();

	}

	private static int getSiguienteIdValidoVenta(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) as maximoId " + "from tutorialjavacoches.venta");

		if (rs.next()) {
			return rs.getInt(1) + 1;
		}

		return 1;
	}

}
