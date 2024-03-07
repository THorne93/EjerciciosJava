package capitulo08.centroeducativo.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import capitulo08.centroeducativo.entities.Materia;
import capitulo08.centroeducativo.entities.Valoracion;

public class ControllerValoracion extends SuperController {

	private static String nombreTabla = "centroeducativo.valoracionmateria";

	public static Valoracion getPrimero() {
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

	
	public static Valoracion getUltimo() {
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

	
	public static Valoracion getAnterior(int idActual) {
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
					+ "delete from valoracionmateria where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static Valoracion getSiguiente(int idActual) {
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
	public static int insercion (Valoracion o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			int nuevoId = nextIdEnTabla("valoracionmateria");
			PreparedStatement ps = conn.prepareStatement(""
					+ "insert into valoracionmateria (id, idProfesor, idEstudiante, idMateria, valoracion) "
					+ "values (?, ?, ?, ?,  ?)");
			ps.setInt(1, nuevoId);
			ps.setInt(2, o.getIdProfesor());
			ps.setInt(3, o.getIdEstudiante());
			ps.setInt(4, o.getIdMateria());
			ps.setFloat(5, o.getValoracion());
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
	public static void modificacion(Valoracion o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(""
					+ "update valoracionmateria set idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion = ? "
					+ "where id = ?");
			ps.setInt(1, o.getIdProfesor());
			ps.setInt(2, o.getIdEstudiante());
			ps.setInt(3, o.getIdMateria());
			ps.setFloat(4, o.getValoracion());
			ps.setInt(5, o.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Valoracion getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Valoracion o = null;
		if (rs.next()) {
			o = new Valoracion();
			o.setId(rs.getInt("id"));
			o.setIdProfesor(rs.getInt("idProfesor"));
			o.setIdEstudiante(rs.getInt("idEstudiante"));
			o.setIdMateria(rs.getInt("idMateria"));
			o.setValoracion(rs.getFloat("valoracion"));
		}
		return o;
	}
	

	}
