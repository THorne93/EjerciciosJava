package capitulo08.centroeducativo.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo08.centroeducativo.controllers.ControllerSexo;
import capitulo08.centroeducativo.entities.Sexo;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class PanelPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfPApellido;
	private JTextField jtfSApellido;
	private JTextField jtfDni;
	private JTextField jtfNombre;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private Runnable runnableMostrarPrimerRegistro;
	private Runnable runnableCargarAnterior;
	private Runnable runnableGetSiguente;
	private Runnable runnableGetUltimo;
	private Runnable runnableGuardar;
	private Runnable runnableNuevo;
	private Runnable runnableDelete;
	private JLabel jLabelTitle;
	private JTextField jtfId;
	protected JComboBox<Sexo> jcbSexo;

	/**
	 * Create the panel.
	 * 
	 * 
	 */

	public PanelPersona() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarPrimerRegistro.run();
			}
		});
		btnPrimero.setIcon(
				new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnPrimero);

		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableCargarAnterior.run();
			}
		});
		btnAnterior.setIcon(
				new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/previous.png")));
		toolBar.add(btnAnterior);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableGetSiguente.run();
			}

		});
		btnSiguiente
				.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/next.png")));
		toolBar.add(btnSiguiente);

		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableGetUltimo.run();
			}
		});
		btnUltimo.setIcon(
				new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnUltimo);

		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableGuardar.run();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelCurso.class.getResource("/capitulo08/res/guardar.png")));
		toolBar.add(btnGuardar);

		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableNuevo.run();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelCurso.class.getResource("/capitulo08/res/nuevo.png")));
		toolBar.add(btnNuevo);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableDelete.run();
			}
		});
		btnDelete.setIcon(new ImageIcon(PanelCurso.class.getResource("/capitulo08/res/eliminar.png")));
		toolBar.add(btnDelete);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		jLabelTitle = new JLabel("New label");
		jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_jLabelTitle = new GridBagConstraints();
		gbc_jLabelTitle.gridwidth = 2;
		gbc_jLabelTitle.insets = new Insets(0, 0, 5, 0);
		gbc_jLabelTitle.gridx = 0;
		gbc_jLabelTitle.gridy = 0;
		panel.add(jLabelTitle, gbc_jLabelTitle);

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Primer Apellido");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfPApellido = new JTextField();
		GridBagConstraints gbc_jtfPApellido = new GridBagConstraints();
		gbc_jtfPApellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPApellido.gridx = 1;
		gbc_jtfPApellido.gridy = 2;
		panel.add(jtfPApellido, gbc_jtfPApellido);
		jtfPApellido.setColumns(10);

		JLabel lblNewLabel = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jtfSApellido = new JTextField();
		jtfSApellido.setColumns(10);
		GridBagConstraints gbc_jtfSApellido = new GridBagConstraints();
		gbc_jtfSApellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSApellido.gridx = 1;
		gbc_jtfSApellido.gridy = 3;
		panel.add(jtfSApellido, gbc_jtfSApellido);

		JLabel lblNewLabel_7 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jcbSexo = new JComboBox<Sexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 4;
		panel.add(jcbSexo, gbc_jcbSexo);

		JLabel lblNewLabel_3 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		panel.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 6;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);

		jtfId = new JTextField();
		jtfId.setVisible(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 11;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		cargarTodosSexos();

	}

	private void cargarTodosSexos() {
		List<Sexo> l = ControllerSexo.getTodos();

		for (Sexo o : l) {
			jcbSexo.addItem(o);
		}
	}

	public void setJLabelTitleText(String text) {
		jLabelTitle.setText(text);
	}

	public Runnable getRunnableMostrarPrimerRegistro() {
		return runnableMostrarPrimerRegistro;
	}

	public void setRunnableMostrarPrimerRegistro(Runnable runnableMostrarPrimerRegistro) {
		this.runnableMostrarPrimerRegistro = runnableMostrarPrimerRegistro;
	}

	public Runnable getRunnableCargarAnterior() {
		return runnableCargarAnterior;
	}

	public void setRunnableCargarAnterior(Runnable runnableCargarAnterior) {
		this.runnableCargarAnterior = runnableCargarAnterior;
	}

	public Runnable getRunnableGetSiguente() {
		return runnableGetSiguente;
	}

	public void setRunnableGetSiguente(Runnable runnableGetSiguente) {
		this.runnableGetSiguente = runnableGetSiguente;
	}

	public Runnable getRunnableGetUltimo() {
		return runnableGetUltimo;
	}

	public void setRunnableGetUltimo(Runnable runnableGetUltimo) {
		this.runnableGetUltimo = runnableGetUltimo;
	}

	public Runnable getRunnableGuardar() {
		return runnableGuardar;
	}

	public void setRunnableGuardar(Runnable runnableGuardar) {
		this.runnableGuardar = runnableGuardar;
	}

	public Runnable getRunnableNuevo() {
		return runnableNuevo;
	}

	public void setRunnableNuevo(Runnable runnableNuevo) {
		this.runnableNuevo = runnableNuevo;
	}

	public Runnable getRunnableDelete() {
		return runnableDelete;
	}

	public void setRunnableDelete(Runnable runnableDelete) {
		this.runnableDelete = runnableDelete;
	}

	public String getPApellido() {
		return jtfPApellido.getText();
	}

	public void setPApellido(String pApellido) {
		this.jtfPApellido.setText(pApellido);
	}

	public String getSApellido() {
		return jtfSApellido.getText();
	}

	public void setSApellido(String sApellido) {
		this.jtfSApellido.setText(sApellido);
	}

	public String getDni() {
		return jtfDni.getText();
	}

	public void setDni(String dni) {
		this.jtfDni.setText(dni);
		;
	}

	public String getTelefono() {
		return jtfTelefono.getText();
	}

	public void setTelefono(String telefono) {
		this.jtfTelefono.setText(telefono);
	}

	public String getNombre() {
		return jtfNombre.getText();
	}

	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}

	public String getDireccion() {
		return jtfDireccion.getText();
	}

	public void setDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);
	}

	public String getEmail() {
		return jtfEmail.getText();
	}

	public void setEmail(String email) {
		this.jtfEmail.setText(email);
		;
	}

	public String getId() {
		return jtfId.getText();
	}

	public void setId(String id) {
		this.jtfId.setText(id);
	}

	public Sexo getSexo() {
		return (Sexo) jcbSexo.getSelectedItem();
	}

	public void setSexo(int idSexo) {

		this.jcbSexo.setSelectedIndex(idSexo);
	}

}
