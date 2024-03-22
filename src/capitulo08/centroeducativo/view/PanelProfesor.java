package capitulo08.centroeducativo.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import capitulo08.centroeducativo.controllers.ControllerProfesor;
import capitulo08.centroeducativo.entities.Profesor;

public class PanelProfesor extends PanelPersona {

	private static final long serialVersionUID = 1L;
	private PanelPersona panelPersona = new PanelPersona();
	byte[] image;

	/**
	 * 
	 */

	public PanelProfesor() {

		setLayout(new BorderLayout(0, 0));
		this.add(panelPersona, BorderLayout.CENTER);

		this.panelPersona.setRunnableMostrarPrimerRegistro(new Runnable() {
			@Override
			public void run() {
				cargarPrimero();
			}
		});

		this.panelPersona.setRunnableCargarAnterior(new Runnable() {
			@Override
			public void run() {
				cargarAnterior();
			}
		});
		this.panelPersona.setRunnableGetSiguente(new Runnable() {
			@Override
			public void run() {
				getSiguente();
			}
		});
		this.panelPersona.setRunnableGetUltimo(new Runnable() {
			@Override
			public void run() {
				getUltimo();
			}
		});
		this.panelPersona.setRunnableGuardar(new Runnable() {
			@Override
			public void run() {
				guardar();
			}
		});
		this.panelPersona.setRunnableNuevo(new Runnable() {
			@Override
			public void run() {
				nuevo();
			}
		});
		this.panelPersona.setRunnableDelete(new Runnable() {
			@Override
			public void run() {
				delete();
			}
		});
		this.panelPersona.setRunnableChooseColour(new Runnable() {
			@Override
			public void run() {
				seleccionaColor();
			}
		});

		modifyLabel(panelPersona);
		cargarPrimero();
	}

	public void modifyLabel(PanelPersona panelPersona) {
		panelPersona.setJLabelTitleText("Gestión de profesor");
	}

	private void cargarAnterior() {
		String strIdActual = String.valueOf(panelPersona.getId());
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Profesor o = ControllerProfesor.getAnterior(idActual);
			muestraEnPantalla(o);
		}

	}

	private void muestraEnPantalla(Profesor o) {

		if (o != null) {

			this.panelPersona.setNombre("" + o.getNombre());
			this.panelPersona.setPApellido(o.getpApellido());
			this.panelPersona.setTelefono(o.getTelefono());
			this.panelPersona.setDni(o.getDni());
			this.panelPersona.setEmail(o.getEmail());
			this.panelPersona.setSApellido(o.getsApellido());
			this.panelPersona.setDireccion(o.getDireccion());
			this.panelPersona.setId(String.valueOf(o.getId()));
			this.panelPersona.setSexo(o.getTipoSexo() - 1);
			this.panelPersona.image = o.getImage();
			
			if (this.panelPersona.image != null && this.panelPersona.image.length > 0) {
				ImageIcon icono = new ImageIcon(this.panelPersona.image);
				JLabel lblIcono = new JLabel(icono);
				this.panelPersona.getScrollPane().setViewportView(lblIcono);
			} else {
				JLabel lblIcono = new JLabel("Sin imagen");
				this.panelPersona.getScrollPane().setViewportView(lblIcono);
			}
			
			try {
				if (o.getColor() != null) {
					Color color = Color.decode(o.getColor());
					this.panelPersona.setColor(o.getColor());

					this.panelPersona.panel.setBackground(color);

				}
				else this.panelPersona.panel.setBackground(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.panelPersona.getColor());

	}

	private void cargarPrimero() {
		Profesor o = ControllerProfesor.getPrimero();
		muestraEnPantalla(o);
	}

	private void getSiguente() {
		String strIdActual = String.valueOf(panelPersona.getId());
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Profesor o = ControllerProfesor.getSiguiente(idActual);
			muestraEnPantalla(o);
		}
	}

	private void getUltimo() {
		Profesor o = ControllerProfesor.getUltimo();
		muestraEnPantalla(o);
	}

	private void guardar() {
		try {
			Profesor o = new Profesor();

			o.setId(-1);
			System.out.println(String.valueOf(panelPersona.getId()));
			if (!String.valueOf(panelPersona.getId()).trim().equals("")) { // El id tiene número

				o.setId(Integer.parseInt(panelPersona.getId()));
			}

			o.setNombre(panelPersona.getNombre());
			o.setpApellido(panelPersona.getPApellido());
			o.setsApellido(panelPersona.getSApellido());
			o.setDireccion(panelPersona.getDireccion());
			o.setEmail(panelPersona.getEmail());
			o.setDni(String.valueOf(panelPersona.getId()));
			o.setTelefono(panelPersona.getTelefono());
			o.setTipoSexo(panelPersona.getSexo().getId());
			o.setImage(panelPersona.getImage());
			o.setColor(panelPersona.getColor());

			// Decido si debo insertar o modificar
			if (o.getId() == -1) { // Inserción
				int nuevoId = ControllerProfesor.insercion(o);
				this.panelPersona.setId(String.valueOf(nuevoId));
			} else {
				ControllerProfesor.modificacion(o);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void seleccionaColor() {
		Color color = JColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			this.panelPersona.setColor(strColor);
			this.panelPersona.setBackground(color);
		}
	}

	private void nuevo() {
		this.panelPersona.setNombre("");
		this.panelPersona.setPApellido("");
		this.panelPersona.setTelefono("");
		this.panelPersona.setDni("");
		this.panelPersona.setEmail("");
		this.panelPersona.setSApellido("");
		this.panelPersona.setDireccion("");
		this.panelPersona.setId("");
		this.panelPersona.image = null;
		if (this.panelPersona.image != null && this.panelPersona.image.length > 0) {
			ImageIcon icono = new ImageIcon(this.panelPersona.image);
			JLabel lblIcono = new JLabel(icono);
			this.panelPersona.getScrollPane().setViewportView(lblIcono);
		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			this.panelPersona.getScrollPane().setViewportView(lblIcono);
		}
	}

	private void delete() {
		try {
			String respuestas[] = new String[] { "Sí", "No" };
			int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar el registro?",
					"Eliminación de profesor", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
					respuestas, respuestas[1]);

			if (opcionElegida == 0) {
				if (!panelPersona.getId().trim().equals("")) {
					int idActual = Integer.parseInt(panelPersona.getId());
					ControllerProfesor.eliminacion(idActual);

					// Decido qué registro voy a mostrar en pantalla.
					// Voy a comprobar si existe un anterior, si existe lo muestro
					// Si no existe anterior compruebo si existe siguiente,
					// si existe lo muestro. En caso contrario, no quedan registros
					// así que muestro en blanco la pantalla
					Profesor aMostrar = ControllerProfesor.getAnterior(idActual);
					if (aMostrar != null) { // Existe un anterior, lo muestro
						muestraEnPantalla(aMostrar);
						;
					} else {
						aMostrar = ControllerProfesor.getSiguiente(idActual);
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
