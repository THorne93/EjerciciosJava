package capitulo08.bloque01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {

	public static void main(String[] args) {
		boolean end = false;

		do {
			int selector = Utils.Arrays
					.requestNumber("0 - Salir \n1 - Listar todos los registros \n2 - Crear un nuevo Fabricante"
							+ "\n3 - Modificar un Fabricante \n4 - Eliminar un Fabricante");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				showList();
				break;
			case 2:
				newFabricante();
				break;
			case 3:
				modificar();
				break;
			case 4:
				remove();
				break;
			}

		} while (end == false);

	}

	private static void remove() {

		try {
			Connection conn = Utils.bbdd.getConexion();
			
			int id = Utils.Arrays.requestNumber("Escribe la ID para borrar");

			Statement s = (Statement) conn.createStatement(); 

			int filasAfectadas = s.executeUpdate("Delete from "
					+ "tutorialjavacoches.fabricante "
					+ "where id = " + id);
		   
			System.out.println("Filas afectadas: " + filasAfectadas);
			

			s.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	private static void modificar() {

		try {
			Connection conn = Utils.bbdd.getConexion();
			
			int id = Utils.Arrays.requestNumber("Escribe la ID del fabricante");
			String cif = Utils.Arrays.requestString("Insertar nueva CIF");
			String nombre = Utils.Arrays.requestString("Insertar nuevo Nombre");

			Statement s = (Statement) conn.createStatement();

			int filasAfectadas = s.executeUpdate("update tutorialjavacoches.fabricante "
					+ "set cif = '" + cif + "', "
					+ "nombre = '" + nombre + "'\r\n"
					+ "where id = " + id);
		   
			System.out.println("Filas afectadas: " + filasAfectadas);

			s.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void newFabricante() {

		try {
			Connection conn = Utils.bbdd.getConexion();
			
			String cif = Utils.Arrays.requestString("Insertar CIF");
			String nombre = Utils.Arrays.requestString("Insertar Nombre");

			Statement s = (Statement) conn.createStatement();
			int filasAfectadas = s.executeUpdate(
				    "INSERT INTO tutorialjavacoches.fabricante (id, cif, nombre) VALUES (" +
				    getSiguienteIdValidoFabricante(conn) + ", '" + cif + "', '" + nombre + "')"
				);

			System.out.println("Filas afectadas: " + filasAfectadas);

			s.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void showList() {

		try {
			Connection conn = Utils.bbdd.getConexion();

			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery("select * from fabricante");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			s.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static int getSiguienteIdValidoFabricante(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) as maximoId " + "from tutorialjavacoches.fabricante");

		if (rs.next()) {
			return rs.getInt(1) + 1;
		}

		return 1;
	}

}