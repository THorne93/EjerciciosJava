package capitulo08.centroeducativo.view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import capitulo08.centroeducativo.controllers.ControllerEstudiante;
import capitulo08.centroeducativo.entities.Estudiante;
import capitulo08.centroeducativo.entities.Sexo;

public class PanelEstudiante extends PanelPersona {

	private static final long serialVersionUID = 1L;
	private PanelPersona panelPersona = new PanelPersona();

	/**
	 * 
	 */

	public PanelEstudiante() {

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

		modifyLabel(panelPersona);
		cargarPrimero();
	}

	public void modifyLabel(PanelPersona panelPersona) {
		panelPersona.setJLabelTitleText("Gestión de estudiantes");
	}

	private void cargarAnterior() {
		String strIdActual = String.valueOf(panelPersona.getId());
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Estudiante o = ControllerEstudiante.getAnterior(idActual);
			muestraEnPantalla(o);
		}

	}

	private void muestraEnPantalla(Estudiante o) {

		if (o != null) {

			this.panelPersona.setNombre("" + o.getNombre());
			this.panelPersona.setPApellido(o.getpApellido());
			this.panelPersona.setTelefono(o.getTelefono());
			this.panelPersona.setDni(o.getDni());
			this.panelPersona.setEmail(o.getEmail());
			this.panelPersona.setSApellido(o.getsApellido());
			this.panelPersona.setDireccion(o.getDireccion());
			this.panelPersona.setId(String.valueOf(o.getId()));
			for (int i = 0; i < jcbSexo.getItemCount(); i++) {
				if (this.jcbSexo.getItemAt(i).getId() == o.getTipoSexo()) {
					this.jcbSexo.setSelectedIndex(i);
				}
			}
		}
	}

	private void cargarPrimero() {
		Estudiante o = ControllerEstudiante.getPrimero();
		muestraEnPantalla(o);
	}

	private void getSiguente() {
		String strIdActual = String.valueOf(panelPersona.getId());
		if (!strIdActual.trim().equals("")) {
			int idActual = Integer.parseInt(strIdActual);
			Estudiante o = ControllerEstudiante.getSiguiente(idActual);
			muestraEnPantalla(o);
		}
	}

	private void getUltimo() {
		Estudiante o = ControllerEstudiante.getUltimo();
		muestraEnPantalla(o);
	}

	private void guardar() {
		try {
			Estudiante o = new Estudiante();

			o.setId(-1);
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
			o.setTipoSexo(((Sexo) this.jcbSexo.getSelectedItem()).getId());

			// Decido si debo insertar o modificar
			if (o.getId() == -1) { // Inserción
				int nuevoId = ControllerEstudiante.insercion(o);
				this.panelPersona.setId(String.valueOf(nuevoId));
			} else {
				ControllerEstudiante.modificacion(o);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
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
	}

	private void delete() {
		try {
			String respuestas[] = new String[] { "Sí", "No" };
			int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar el registro?",
					"Eliminación de estudiante", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
					respuestas, respuestas[1]);

			if (opcionElegida == 0) {
				if (!panelPersona.getId().trim().equals("")) {
					int idActual = Integer.parseInt(panelPersona.getId());
					ControllerEstudiante.eliminacion(idActual);

					// Decido qué registro voy a mostrar en pantalla.
					// Voy a comprobar si existe un anterior, si existe lo muestro
					// Si no existe anterior compruebo si existe siguiente,
					// si existe lo muestro. En caso contrario, no quedan registros
					// así que muestro en blanco la pantalla
					Estudiante aMostrar = ControllerEstudiante.getAnterior(idActual);
					if (aMostrar != null) { // Existe un anterior, lo muestro
						muestraEnPantalla(aMostrar);
						;
					} else {
						aMostrar = ControllerEstudiante.getSiguiente(idActual);
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
