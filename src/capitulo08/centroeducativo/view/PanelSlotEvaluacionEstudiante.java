
package capitulo08.centroeducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import capitulo08.centroeducativo.controllers.ControllerValoracion;
import capitulo08.centroeducativo.entities.Estudiante;
import capitulo08.centroeducativo.entities.Materia;
import capitulo08.centroeducativo.entities.Profesor;
import capitulo08.centroeducativo.entities.Valoracion;

import java.awt.Insets;

public class PanelSlotEvaluacionEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfValoracion;
	private Profesor profesor;
	private Materia materia;
	private Estudiante estudiante;

	/**
	 * Create the panel.
	 */
	public PanelSlotEvaluacionEstudiante(Profesor p, Estudiante e, Materia m) {
		this.profesor = p;
		this.estudiante = e;
		this.materia = m;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNombreEstudiante = new JLabel("New label");
		GridBagConstraints gbc_lblNombreEstudiante = new GridBagConstraints();
		gbc_lblNombreEstudiante.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombreEstudiante.anchor = GridBagConstraints.EAST;
		gbc_lblNombreEstudiante.gridx = 0;
		gbc_lblNombreEstudiante.gridy = 0;
		add(lblNombreEstudiante, gbc_lblNombreEstudiante);

		jtfValoracion = new JTextField();
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 1;
		gbc_jtfValoracion.gridy = 0;
		add(jtfValoracion, gbc_jtfValoracion);
		jtfValoracion.setColumns(10);

		lblNombreEstudiante.setText(this.estudiante.getNombre());
		cargarNotaActual();
	}

	/**
	*
	*/
	private void cargarNotaActual() {
		Valoracion o = ControllerValoracion.findByIdMateriaAndIdProfesorAndIdEstudiante(this.materia.getId(),
				this.profesor.getId(), this.estudiante.getId());

		if (o != null) {
			this.jtfValoracion.setText("" + o.getValoracion());
		}
	}

	public void guardarNota() {

		try {

			Valoracion test = ControllerValoracion.findByIdMateriaAndIdProfesorAndIdEstudiante(this.materia.getId(),
					this.profesor.getId(), this.estudiante.getId());

			String textField = this.jtfValoracion.getText();

			if (test == null) {

				if (textField.equals("")) {
					return;
				} else {
					Valoracion o = new Valoracion();
					o.setIdEstudiante(this.estudiante.getId());
					o.setIdMateria(this.materia.getId());
					o.setIdProfesor(this.profesor.getId());
					o.setValoracion(Float.parseFloat(textField));

					ControllerValoracion.insercion(o);
				}

			} else {

				test.setValoracion(Float.parseFloat(textField));

				ControllerValoracion.modificacion(test);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
