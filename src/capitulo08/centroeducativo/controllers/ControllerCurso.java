package capitulo08.centroeducativo.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import capitulo08.centroeducativo.entities.Curso;


public class ControllerCurso extends SuperController {

	private static String nombreTabla = "centroeducativo.curso";

	
	public static List<Curso> getTodos() {
		List<Curso> l = new ArrayList<Curso>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Curso o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
	
	
	public static Curso getPrimero() {
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
	
	public static int insercion (Curso o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			int nuevoId = nextIdEnTabla("curso");
			PreparedStatement ps = conn.prepareStatement(""
					+ "insert into curso (id, descripcion) "
					+ "values (?, ?)");
			ps.setInt(1, nuevoId);
			ps.setString(2, o.getDescripcion());
			ps.executeUpdate();
			return nuevoId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
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
	
	public static Curso getUltimo() {
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

	
	public static Curso getAnterior(int idActual) {
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

	
	public static Curso getSiguiente(int idActual) {
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

	
	private static Curso getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Curso o = null;
		if (rs.next()) {
			o = getEntidadFromResultSet(rs);
		}
		return o;
	}

	
	
	private static Curso getEntidadFromResultSet (ResultSet rs) throws SQLException {
		Curso o = new Curso();
		o.setId(rs.getInt("id"));
		o.setDescripcion(rs.getString("descripcion"));
		return o;
	}


	public static void modificacion(Curso o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(""
					+ "update curso set descripcion = ? "
					+ "where id = ?");
			ps.setString(1, o.getDescripcion());
			ps.setInt(2, o.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
