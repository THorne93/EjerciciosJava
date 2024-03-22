package capitulo08.centroeducativo.view;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import capitulo08.centroeducativo.controllers.ControllerSexo;
import capitulo08.centroeducativo.entities.Sexo;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfPApellido;
	private JTextField jtfSApellido;
	private JTextField jtfDni;
	private JTextField jtfNombre;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JScrollPane scrollPane;
	protected byte[] image;
	private Runnable runnableMostrarPrimerRegistro;
	private Runnable runnableCargarAnterior;
	private Runnable runnableGetSiguente;
	private Runnable runnableGetUltimo;
	private Runnable runnableGuardar;
	private Runnable runnableNuevo;
	private Runnable runnableDelete;
	private Runnable runnableChooseColour;
	private JLabel jLabelTitle;
	private JTextField jtfId;
	protected JComboBox<Sexo> jcbSexo;
	private JTextField jtfColor;
	private JPopupMenu popup = getPopUpMenu();
	protected JPanel panel;

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

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 217, 87, 0 };
		gbl_panel.rowHeights = new int[] { 0, 33, 33, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		jLabelTitle = new JLabel("New label");
		jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_jLabelTitle = new GridBagConstraints();
		gbc_jLabelTitle.gridwidth = 3;
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
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfPApellido.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfSApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSApellido.gridx = 1;
		gbc_jtfSApellido.gridy = 3;
		panel.add(jtfSApellido, gbc_jtfSApellido);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPopup(e);
			}
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
		});
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		JLabel lblNewLabel_7 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jcbSexo = new JComboBox<Sexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 4;
		panel.add(jcbSexo, gbc_jcbSexo);

		JButton btnNewButton = new JButton("Cambiar Imagen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		panel.add(btnNewButton, gbc_btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);

		jtfId = new JTextField();
		jtfId.setVisible(false);

		JLabel lblNewLabel_8 = new JLabel("Color preferido:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 9;
		panel.add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		JButton btnNewButton_1 = new JButton("Cambiar color");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableChooseColour.run();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 9;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 0, 5);
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

	public void setRunnableChooseColour(Runnable runnableChooseColour) {
		this.runnableChooseColour = runnableChooseColour;
	}

	public Runnable getRunnableChooseColour() {
		return runnableChooseColour;
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

	public byte[] getImage() {
		return image;
	}

	public void setImagen(byte[] image) {
		this.image = image;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public String getColor() {
		return jtfColor.getText();
	}

	public void setColor(String colour) {
		this.jtfColor.setText(colour);
	}

	private void seleccionaImagen() {
		JFileChooser jfileChooser = new JFileChooser();

		// Configurando el componente

		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() && (f.getAbsolutePath().toLowerCase().endsWith(".jpg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".jpeg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".png")
						|| f.getAbsolutePath().toLowerCase().endsWith(".gif"))))
					return true;
				return false;
			}
		});

		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();

			if (fichero.isFile()) {
				try {
					this.image = Files.readAllBytes(fichero.toPath());
					BufferedImage img = ImageIO.read(fichero);
					if (img.getHeight() <= 100 && img.getWidth() <= 100) {
						mostrarImagen();
					} else {
						JOptionPane.showMessageDialog(null, "La imagen tiene que ser como maximo 100x100");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public void mostrarImagen() {
		if (image != null && image.length > 0) {
			ImageIcon icono = new ImageIcon(image);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}

	}

	private JPopupMenu getPopUpMenu() {
		JPopupMenu menu = new JPopupMenu();
		if (image != null) {
			System.out.println("not null");
			ImageIcon imagen = new ImageIcon(image);
			menu.add(crearNuevoMenuItem("Dimensiónes: " +imagen.getIconWidth() +"x" +imagen.getIconHeight() + " píxeles" ,false));
		} else {
			menu.add(crearNuevoMenuItem("Dimensiónes: 0x0 píxeles",false));
			System.out.println("null");
		}

		menu.addSeparator();
		menu.add(crearNuevoMenuItem("Cambiar imagen", true));

		return menu;
	}

	private JMenuItem crearNuevoMenuItem(String titulo, boolean button) {
		JMenuItem item = new JMenuItem(titulo);
		if (button == true) {
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					seleccionaImagen();
				}
			});
		}
		;

		return item;
	}

	private void showPopup(MouseEvent e) {
		JPopupMenu popup = getPopUpMenu();
		if (e.isPopupTrigger()) {
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}
