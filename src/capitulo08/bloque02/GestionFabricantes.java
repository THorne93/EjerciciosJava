package capitulo08.bloque02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GestionFabricantes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionFabricantes frame = new GestionFabricantes();
					frame.setVisible(true);
					frame.cargarPrimero();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionFabricantes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Gestion de fabricantes");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridwidth = 4;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 1;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CIF:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 2;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfCif = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.gridwidth = 4;
		gbc_jtfCif.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.gridx = 2;
		gbc_jtfCif.gridy = 2;
		contentPane.add(jtfCif, gbc_jtfCif);
		jtfCif.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridwidth = 4;
		gbc_jtfNombre.anchor = GridBagConstraints.NORTH;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 3;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		/**
		 * GET FIRST
		 */
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					conn = ConnectionManager.getConexion();
					Fabricante f = GestionFabricante.getPrimero(conn);
					cargaFabricanteEnPantalla(f);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnPrimero.setIcon(new ImageIcon(GestionFabricantes.class.getResource("/capitulo08/res/gotostart.png")));
		GridBagConstraints gbc_btnPrimero = new GridBagConstraints();
		gbc_btnPrimero.anchor = GridBagConstraints.EAST;
		gbc_btnPrimero.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrimero.gridx = 0;
		gbc_btnPrimero.gridy = 4;
		contentPane.add(btnPrimero, gbc_btnPrimero);
		
		/**
		 * GET PREVIOUS
		 */
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPrevious();
			}
			
		});
		btnBack.setIcon(new ImageIcon(GestionFabricantes.class.getResource("/capitulo08/res/previous.png")));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 4;
		contentPane.add(btnBack, gbc_btnBack);
		
		/**
		 * GET NEXT
		 */
		JButton btnForward = new JButton("");
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String strIdActual = jtfId.getText();
					if (! strIdActual.trim().equals("")) {
						int idActual = Integer.parseInt(strIdActual);
					Connection conn = ConnectionManager.getConexion();
					Fabricante f = GestionFabricante.getNext(conn,idActual);
					cargaFabricanteEnPantalla(f);
				}
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
		});
		

		btnForward.setIcon(new ImageIcon(GestionFabricantes.class.getResource("/capitulo08/res/next.png")));
		GridBagConstraints gbc_btnForward = new GridBagConstraints();
		gbc_btnForward.insets = new Insets(0, 0, 5, 5);
		gbc_btnForward.gridx = 2;
		gbc_btnForward.gridy = 4;
		contentPane.add(btnForward, gbc_btnForward);
		
		/**
		 * GET LAST
		 */
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = ConnectionManager.getConexion();
					Fabricante f = GestionFabricante.getUltimo(conn);
					cargaFabricanteEnPantalla(f);
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
				
			
		});
		
		btnLast.setIcon(new ImageIcon(GestionFabricantes.class.getResource("/capitulo08/res/gotoend.png")));
		GridBagConstraints gbc_btnLast = new GridBagConstraints();
		gbc_btnLast.insets = new Insets(0, 0, 5, 5);
		gbc_btnLast.gridx = 3;
		gbc_btnLast.gridy = 4;
		contentPane.add(btnLast, gbc_btnLast);
		
		JButton btnNew = new JButton("");
		btnNew.setIcon(new ImageIcon(GestionFabricantes.class.getResource("/capitulo08/res/nuevo.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew.gridx = 4;
		gbc_btnNew.gridy = 4;
		contentPane.add(btnNew, gbc_btnNew);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnSave.setIcon(new ImageIcon(GestionFabricantes.class.getResource("/capitulo08/res/guardar.png")));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 5;
		gbc_btnSave.gridy = 4;
		contentPane.add(btnSave, gbc_btnSave);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setIcon(new ImageIcon(GestionFabricantes.class.getResource("/capitulo08/res/eliminar.png")));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.WEST;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 6;
		gbc_btnDelete.gridy = 4;
		contentPane.add(btnDelete, gbc_btnDelete);
	}

	private void cargaFabricanteEnPantalla(Fabricante f) {
		if (f != null) {
			jtfId.setText("" + f.getId());
			jtfNombre.setText(f.getNombre());
			jtfCif.setText(f.getCif());
		}

	}
	
	private void cargarPrimero() throws SQLException {
		
		Connection conn = ConnectionManager.getConexion();
		Fabricante f = GestionFabricante.getPrimero(conn);
		cargaFabricanteEnPantalla(f);
	}
	
	private void getPrevious() {
		try {
			String strIdActual = jtfId.getText();
			if (! strIdActual.trim().equals("")) {
				int idActual = Integer.parseInt(strIdActual);
				Connection conn = ConnectionManager.getConexion();
				Fabricante f = GestionFabricante.getPrevious(conn,idActual);
				cargaFabricanteEnPantalla(f);
			}

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	private void nuevo() {
		this.jtfId.setText("");
		this.jtfCif.setText("");
		this.jtfNombre.setText("");
	}
	
	private void guardar() {
		try {
			Fabricante f = new Fabricante();
			
			f.setId(-1);
			if (!this.jtfId.getText().trim().equals("")) { // El id tiene número
				f.setId(Integer.parseInt(this.jtfId.getText()));			
			}
			f.setCif(this.jtfCif.getText());
			f.setNombre(this.jtfNombre.getText());

			// Decido si debo insertar o modificar
			Connection conn = ConnectionManager.getConexion();
			if (f.getId() == -1) { // Inserción
				int nuevoId = GestionFabricante.insercion(f, conn);
				this.jtfId.setText("" + nuevoId);
			}
			else {
				GestionFabricante.modificacion(f, conn);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
		
		
		
	
	
	private void delete () {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de fabricante", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);
		    
			if(opcionElegida == 0) {
		      if (!this.jtfId.getText().trim().equals("")) {
		    	  int id = Integer.parseInt(this.jtfId.getText());
		    	  Connection conn = ConnectionManager.getConexion();
		    	  GestionFabricante.eliminacion(id, ConnectionManager.getConexion());
		    	  
		    	  Fabricante fabriAMonstrar = GestionFabricante.getPrevious(conn, id);
		    	  if (fabriAMonstrar != null) {
		    		  cargaFabricanteEnPantalla(fabriAMonstrar);
		    	  }
		    	  else {
					fabriAMonstrar = GestionFabricante.getNext(conn, id);
					if (fabriAMonstrar != null) {
						cargaFabricanteEnPantalla(fabriAMonstrar);
					}
					else {
						nuevo();
					}
				}

		      }
				
			
		    }			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
 	
}