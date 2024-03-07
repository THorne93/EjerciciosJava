package capitulo08.centroeducativo.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo08.centroeducativo.controllers.ControllerEstudiante;
import capitulo08.centroeducativo.controllers.ControllerMateria;
import capitulo08.centroeducativo.controllers.ControllerProfesor;
import capitulo08.centroeducativo.controllers.ControllerValoracion;
import capitulo08.centroeducativo.entities.Estudiante;
import capitulo08.centroeducativo.entities.Materia;
import capitulo08.centroeducativo.entities.Profesor;
import capitulo08.centroeducativo.entities.Valoracion;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelValoracion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Estudiante> jcbEstudiante;
	private JComboBox<Materia> jcbMateria;

	private JTextField jtfValoracion;

	/**
	 * Create the panel.
	 */
	public PanelValoracion() {
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
				getAnterior();
			}
		});
		btnAnterior.setIcon(
				new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/previous.png")));
		toolBar.add(btnAnterior);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNext();
			}

		});
		btnSiguiente
				.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/next.png")));
		toolBar.add(btnSiguiente);

		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getLast();
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
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Gestión de Materia");
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

		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 2;
		panel.add(jcbProfesor, gbc_jcbProfesor);

		JLabel lblNewLabel_3 = new JLabel("Estudiante:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
	
		jcbEstudiante = new JComboBox<Estudiante>();
		GridBagConstraints gbc_jcbEstudiante = new GridBagConstraints();
		gbc_jcbEstudiante.insets = new Insets(0, 0, 5, 0);
		gbc_jcbEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEstudiante.gridx = 1;
		gbc_jcbEstudiante.gridy = 3;
		panel.add(jcbEstudiante, gbc_jcbEstudiante);

		JLabel lblNewLabel_4 = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 4;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_5 = new JLabel(" Valoración:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfValoracion = new JTextField();
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 1;
		gbc_jtfValoracion.gridy = 5;
		panel.add(jtfValoracion, gbc_jtfValoracion);
		jtfValoracion.setColumns(10);

		// Cargo todos los cursos en el jcombo
		cargarTodosProfesores();
		cargarTodosEstudiantes();
		cargarTodosMaterias();
		cargarPrimero();
	}

	private void cargarTodosMaterias() {
		List<Materia> l = ControllerMateria.getTodos();

		for (Materia o : l) {
			jcbMateria.addItem(o);
		}
	}

	private void cargarTodosEstudiantes() {
		List<Estudiante> l = ControllerEstudiante.getTodos();

		for (Estudiante o : l) {
			jcbEstudiante.addItem(o);
		}
	}

	private void getLast() {
		Valoracion o = ControllerValoracion.getUltimo();
		muestraEnPantalla(o);
	}

	private void cargarTodosProfesores() {
		List<Profesor> l = ControllerProfesor.getTodos();

		for (Profesor o : l) {
			jcbProfesor.addItem(o);
		}
	}

	/**
	 * 
	 */
	private void cargarPrimero() {
		Valoracion o = ControllerValoracion.getPrimero();
		muestraEnPantalla(o);
	}

	private void getAnterior() {
		String strIdActual = jtfId.getText();
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Valoracion o = ControllerValoracion.getAnterior(idActual);
			muestraEnPantalla(o);
		}
	}

	private void getNext() {
		String strIdActual = jtfId.getText();
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Valoracion o = ControllerValoracion.getSiguiente(idActual);
			muestraEnPantalla(o);
		}
	}

	private void muestraEnPantalla(Valoracion o) {
		if (o != null) {
			this.jtfId.setText("" + o.getId());
			for (int i = 0; i < jcbProfesor.getItemCount(); i++) {
				if (jcbProfesor.getItemAt(i).getId() == o.getIdProfesor()) {
					jcbProfesor.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < jcbEstudiante.getItemCount(); i++) {
				if (jcbEstudiante.getItemAt(i).getId() == o.getIdEstudiante()) {
					jcbEstudiante.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < jcbMateria.getItemCount(); i++) {
				if (jcbMateria.getItemAt(i).getId() == o.getIdMateria()) {
					jcbMateria.setSelectedIndex(i);
				}
			}
			this.jtfValoracion.setText(Float.toString(o.getValoracion()));
		}
	}

	private void nuevo() {
		this.jtfId.setText("");
		this.jtfValoracion.setText("");

	}

	private void guardar() {
		try {
			Valoracion o = new Valoracion();

			o.setId(-1);
			if (!this.jtfId.getText().trim().equals("")) { // El id tiene número
				o.setId(Integer.parseInt(this.jtfId.getText()));
			}

			o.setIdProfesor(((Profesor)this.jcbProfesor.getSelectedItem()).getId());
			o.setIdEstudiante(((Estudiante)this.jcbEstudiante.getSelectedItem()).getId());
			o.setIdMateria(((Materia)this.jcbMateria.getSelectedItem()).getId());
			o.setValoracion(Float.parseFloat(this.jtfValoracion.getText()));
			// Decido si debo insertar o modificar
			if (o.getId() == -1) { // Inserción
				int nuevoId = ControllerValoracion.insercion(o);
				this.jtfId.setText("" + nuevoId);
			} else {
				ControllerValoracion.modificacion(o);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	private void delete() {
		try {
			String respuestas[] = new String[] { "Sí", "No" };
			int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar el registro?",
					"Eliminación de valoracion", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, respuestas,
					respuestas[1]);

			if (opcionElegida == 0) {
				if (!this.jtfId.getText().trim().equals("")) {
					int idActual = Integer.parseInt(this.jtfId.getText());
					ControllerValoracion.eliminacion(idActual);

					// Decido qué registro voy a mostrar en pantalla.
					// Voy a comprobar si existe un anterior, si existe lo muestro
					// Si no existe anterior compruebo si existe siguiente,
					// si existe lo muestro. En caso contrario, no quedan registros
					// así que muestro en blanco la pantalla
					Valoracion aMostrar = ControllerValoracion.getAnterior(idActual);
					if (aMostrar != null) { // Existe un anterior, lo muestro
						muestraEnPantalla(aMostrar);
						;
					} else {
						aMostrar = ControllerValoracion.getSiguiente(idActual);
						if (aMostrar != null) { // Existe un siguiente
							muestraEnPantalla(aMostrar);
						} else { // No quedan registros en la tabla
							nuevo();
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
