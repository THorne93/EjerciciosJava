package capitulo08.centroeducativo.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo08.centroeducativo.controllers.ConnectionManager;
import capitulo08.centroeducativo.controllers.ControllerCurso;
import capitulo08.centroeducativo.entities.Curso;
import capitulo08.centroeducativo.controllers.SuperController;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class PanelCurso extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;

	/**
	 * Create the panel.
	 * 
	 * 
	 */
	
	
	
	public PanelCurso() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		btnPrimero.setIcon(
				new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnPrimero);

		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		btnAnterior.setIcon(
				new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/previous.png")));
		toolBar.add(btnAnterior);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSiguente();
			}

		});
		btnSiguiente
				.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/next.png")));
		toolBar.add(btnSiguiente);

		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUltimo();
			}
		});
		btnUltimo.setIcon(
				new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnUltimo);

		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelCurso.class.getResource("/capitulo08/res/guardar.png")));
		toolBar.add(btnGuardar);

		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelCurso.class.getResource("/capitulo08/res/nuevo.png")));
		toolBar.add(btnNuevo);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setIcon(new ImageIcon(PanelCurso.class.getResource("/capitulo08/res/eliminar.png")));
		toolBar.add(btnDelete);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Gestión de Curso");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 2;
		panel.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		cargarPrimero();


	}

	
	/**
	 * 
	 */
	private void cargarPrimero() {
		Curso o = ControllerCurso.getPrimero();
		muestraEnPantalla(o);
	}

	private void cargarAnterior() {
		String strIdActual = jtfId.getText();
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Curso o = ControllerCurso.getAnterior(idActual);
			muestraEnPantalla(o);
		}

	}

	private void getSiguente() {
		String strIdActual = jtfId.getText();
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Curso o = ControllerCurso.getSiguiente(idActual);
			muestraEnPantalla(o);
		}

	}
	
	private void guardar() {
		try {
			Curso o = new Curso();
			
			o.setId(-1);
			if (!this.jtfId.getText().trim().equals("")) { // El id tiene número
				o.setId(Integer.parseInt(this.jtfId.getText()));			
			}
			
			o.setDescripcion(this.jtfDescripcion.getText());

			// Decido si debo insertar o modificar
			if (o.getId() == -1) { // Inserción
				int nuevoId = ControllerCurso.insercion(o);
				this.jtfId.setText("" + nuevoId);
			}
			else {
				ControllerCurso.modificacion(o);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}	
	}

	private void getUltimo() {
		Curso o = ControllerCurso.getUltimo();
		muestraEnPantalla(o);
	}
	
	private void nuevo()  {
		this.jtfId.setText("");
		this.jtfDescripcion.setText("");
	}

	private void muestraEnPantalla(Curso o) {
		if (o != null) {
			this.jtfId.setText("" + o.getId());
			this.jtfDescripcion.setText(o.getDescripcion());
		}
	}
	
	private void delete () {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de curso", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);
		    
			if(opcionElegida == 0) {
		      if (!this.jtfId.getText().trim().equals("")) {
		    	  int idActual = Integer.parseInt(this.jtfId.getText());
		    	  ControllerCurso.eliminacion(idActual);
		    	  
		    	  // Decido qué registro voy a mostrar en pantalla.
		    	  // Voy a comprobar si existe un anterior, si existe lo muestro
		    	  // Si no existe anterior compruebo si existe siguiente, 
		    	  // si existe lo muestro. En caso contrario, no quedan registros
		    	  // así que muestro en blanco la pantalla
		    	  Curso cursoAMostrar = ControllerCurso.getAnterior(idActual);
		    	  if (cursoAMostrar != null) { // Existe un anterior, lo muestro
		    		  muestraEnPantalla(cursoAMostrar);;
		    	  }
		    	  else {
		    		  cursoAMostrar = ControllerCurso.getSiguiente(idActual);
		    		  if (cursoAMostrar != null) { // Existe un siguiente
		    			  muestraEnPantalla(cursoAMostrar);
		    		  }
		    		  else { // No quedan registros en la tabla
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
