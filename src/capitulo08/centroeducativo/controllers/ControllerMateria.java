package capitulo08.centroeducativo.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import capitulo08.centroeducativo.entities.Materia;

public class ControllerMateria extends SuperController {

	private static String nombreTabla = "centroeducativo.materia";

	public static Materia getPrimero() {
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

	
	public static Materia getUltimo() {
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

	
	public static Materia getAnterior(int idActual) {
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
					+ "delete from curso where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static Materia getSiguiente(int idActual) {
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
	public static int insercion (Materia o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			int nuevoId = nextIdEnTabla("materia");
			PreparedStatement ps = conn.prepareStatement(""
					+ "insert into materia (id, nombre, acronimo, curso_id) "
					+ "values (?, ?, ?, ?)");
			ps.setInt(1, nuevoId);
			ps.setString(2, o.getNombre());
			ps.setString(3, o.getAcronimo());
			ps.setInt(4, o.getCursoId());
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
	public static void modificacion(Materia o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(""
					+ "update materia set nombre = ?, acronimo = ?, curso_id = ? "
					+ "where id = ?");
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getAcronimo());
			ps.setInt(3, o.getCursoId());
			ps.setInt(4, o.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Materia getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Materia o = null;
		if (rs.next()) {
			o = new Materia();
			o.setId(rs.getInt("id"));
			o.setCursoId(rs.getInt("curso_id"));
			o.setAcronimo(rs.getString("acronimo"));
			o.setNombre(rs.getString("nombre"));
		}
		return o;
	}
	
	private static Materia getEntidadFromResultSet (ResultSet rs) throws SQLException {
		Materia o = new Materia();
		o.setId(rs.getInt("id"));
		o.setCursoId(rs.getInt("curso_id"));
		o.setAcronimo(rs.getString("acronimo"));
		o.setNombre(rs.getString("nombre"));
		return o;
	}
	
	public static List<Materia> getTodos() {
		List<Materia> l = new ArrayList<Materia>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Materia o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
}
