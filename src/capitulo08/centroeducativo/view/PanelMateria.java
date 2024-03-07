package capitulo08.centroeducativo.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo08.centroeducativo.controllers.ControllerCurso;
import capitulo08.centroeducativo.controllers.ControllerMateria;
import capitulo08.centroeducativo.entities.Curso;
import capitulo08.centroeducativo.entities.Materia;

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

public class PanelMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfAcronimo;
	private JTextField jtfNombre;
	private JComboBox<Curso> jcbCurso;

	/**
	 * Create the panel.
	 */
	public PanelMateria() {
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
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		JLabel lblNewLabel_1 = new JLabel("Curso:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbCurso = new JComboBox<Curso>();
		GridBagConstraints gbc_jcbCurso = new GridBagConstraints();
		gbc_jcbCurso.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCurso.gridx = 1;
		gbc_jcbCurso.gridy = 2;
		panel.add(jcbCurso, gbc_jcbCurso);

		JLabel lblNewLabel_3 = new JLabel("Acrónimo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfAcronimo = new JTextField();
		GridBagConstraints gbc_jtfAcronimo = new GridBagConstraints();
		gbc_jtfAcronimo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronimo.gridx = 1;
		gbc_jtfAcronimo.gridy = 3;
		panel.add(jtfAcronimo, gbc_jtfAcronimo);
		jtfAcronimo.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 4;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		// Cargo todos los cursos en el jcombo
		cargarTodosCursos();
		cargarPrimero();
	}

	private void getLast() {
		Materia o = ControllerMateria.getUltimo();
		muestraEnPantalla(o);
	}

	private void cargarTodosCursos() {
		List<Curso> l = ControllerCurso.getTodos();

		for (Curso o : l) {
			jcbCurso.addItem(o);
		}
	}

	/**
	 * 
	 */
	private void cargarPrimero() {
		Materia o = ControllerMateria.getPrimero();
		muestraEnPantalla(o);
	}

	private void getAnterior() {
		String strIdActual = jtfId.getText();
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Materia o = ControllerMateria.getAnterior(idActual);
			muestraEnPantalla(o);
		}
	}

	private void getNext() {
		String strIdActual = jtfId.getText();
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Materia o = ControllerMateria.getSiguiente(idActual);
			muestraEnPantalla(o);
		}
	}

	private void muestraEnPantalla(Materia o) {
		if (o != null) {
			this.jtfId.setText("" + o.getId());
			for (int i = 0; i < jcbCurso.getItemCount(); i++) {
				if (jcbCurso.getItemAt(i).getId() == o.getCursoId()) {
					jcbCurso.setSelectedIndex(i);
				}
			}
			this.jtfAcronimo.setText(o.getAcronimo());
			this.jtfNombre.setText(o.getNombre());
		}
	}

	private void nuevo() {
		this.jtfId.setText("");
		this.jtfNombre.setText("");
		this.jtfAcronimo.setText("");

	}

	private void guardar() {
		try {
			Materia o = new Materia();

			o.setId(-1);
			if (!this.jtfId.getText().trim().equals("")) { // El id tiene número
				o.setId(Integer.parseInt(this.jtfId.getText()));
			}

			o.setNombre(this.jtfNombre.getText());
			o.setAcronimo(this.jtfAcronimo.getText());
			o.setCursoId(((Curso)this.jcbCurso.getSelectedItem()).getId());

			// Decido si debo insertar o modificar
			if (o.getId() == -1) { // Inserción
				int nuevoId = ControllerMateria.insercion(o);
				this.jtfId.setText("" + nuevoId);
			} else {
				ControllerMateria.modificacion(o);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	private void delete() {
		try {
			String respuestas[] = new String[] { "Sí", "No" };
			int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar el registro?",
					"Eliminación de curso", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, respuestas,
					respuestas[1]);

			if (opcionElegida == 0) {
				if (!this.jtfId.getText().trim().equals("")) {
					int idActual = Integer.parseInt(this.jtfId.getText());
					ControllerMateria.eliminacion(idActual);

					// Decido qué registro voy a mostrar en pantalla.
					// Voy a comprobar si existe un anterior, si existe lo muestro
					// Si no existe anterior compruebo si existe siguiente,
					// si existe lo muestro. En caso contrario, no quedan registros
					// así que muestro en blanco la pantalla
					Materia aMostrar = ControllerMateria.getAnterior(idActual);
					if (aMostrar != null) { // Existe un anterior, lo muestro
						muestraEnPantalla(aMostrar);
						;
					} else {
						aMostrar = ControllerMateria.getSiguiente(idActual);
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
