package capitulo08.centroeducativo.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import capitulo08.centroeducativo.entities.Estudiante;

public class ControllerEstudiante extends SuperController {

	private static String nombreTabla = "centroeducativo.estudiante";

	public static Estudiante getPrimero() {
		try {
			return getEntidad (ConnectionManager.getConexion(),
					"select * from " + nombreTabla
					+ " order by id asc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public static Estudiante getUltimo() {
		try {
			return getEntidad(ConnectionManager.getConexion(), 
					"select * from " + nombreTabla
					+ " order by id desc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public static Estudiante getAnterior(int idActual) {
		try {
			String sql = "select * from " + nombreTabla + " where id < " + idActual
					+ " order by id desc limit 1";
			return getEntidad (ConnectionManager.getConexion(), sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void eliminacion (int id) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(""
					+ "delete from estudiante where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static Estudiante getSiguiente(int idActual) {
		try {
			return getEntidad (ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " where id > " + idActual
					+ " order by id asc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * @param o
	 * @return
	 */
	public static int insercion (Estudiante o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			int nuevoId = nextIdEnTabla("estudiante");
			PreparedStatement ps = conn.prepareStatement(""
					+ "insert into estudiante (id, nombre, apellido1, apellido2, dni, direccion, email, telefono, id_TipologiaSexo, imagen, colorPreferido) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, nuevoId);
			ps.setString(2, o.getNombre());
			ps.setString(3, o.getpApellido());
			ps.setString(4, o.getsApellido());
			ps.setString(5, o.getDni());
			ps.setString(6, o.getDireccion());
			ps.setString(7, o.getEmail());
			ps.setString(8, o.getTelefono());
			ps.setInt(9, o.getTipoSexo());
			ps.setBytes(10, o.getImage());
			ps.setString(11, o.getColor());
			ps.executeUpdate();
			return nuevoId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * @param o
	 */
	public static void modificacion(Estudiante o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(""
					+ "update estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, "
					+ "direccion = ?, email = ?, telefono = ?, id_TipologiaSexo = ?, imagen = ?, colorPreferido = ? "
					+ "where id = ?");
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getpApellido());
			ps.setString(3, o.getsApellido());
			ps.setString(4, o.getDni());
			ps.setString(5, o.getDireccion());
			ps.setString(6, o.getEmail());
			ps.setString(7, o.getTelefono());
			ps.setInt(8, o.getTipoSexo());
			ps.setBytes(9, o.getImage());
			ps.setString(10, o.getColor());
			ps.setInt(11, o.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Estudiante getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Estudiante o = null;
		if (rs.next()) {
			o = new Estudiante();
			o.setId(rs.getInt("id"));
			o.setNombre(rs.getString("nombre"));
			o.setpApellido(rs.getString("apellido1"));
			o.setsApellido(rs.getString("apellido2"));
			o.setDni(rs.getString("dni"));
			o.setDireccion(rs.getString("direccion"));
			o.setEmail(rs.getString("email"));
			o.setTelefono(rs.getString("telefono"));
			o.setTipoSexo(rs.getInt("id_TipologiaSexo"));
			o.setImage(rs.getBytes("imagen"));
			o.setColor(rs.getString("colorPreferido"));
		}
		return o;
	}
	
	private static Estudiante getEntidadFromResultSet (ResultSet rs) throws SQLException {
		Estudiante o = new Estudiante();
		o.setId(rs.getInt("id"));
		o.setNombre(rs.getString("nombre"));
		o.setpApellido(rs.getString("apellido1"));
		o.setsApellido(rs.getString("apellido2"));
		o.setDni(rs.getString("dni"));
		o.setDireccion(rs.getString("direccion"));
		o.setEmail(rs.getString("email"));
		o.setTelefono(rs.getString("telefono"));
		o.setTipoSexo(rs.getInt("id_TipologiaSexo"));
		o.setImage(rs.getBytes("imagen"));
		o.setImage(rs.getBytes("imagen"));
		o.setColor(rs.getString("colorPreferido"));
		return o;
	}
	
	public static List<Estudiante> getTodos() {
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Estudiante o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
}
