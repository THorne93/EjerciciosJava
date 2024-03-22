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
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelValoracion extends JPanel {

	private static final long serialVersionUID = 1L;
	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	JPanel panelEstudiantes;
	List<PanelSlotEvaluacionEstudiante> listaSlotsValoracion = new ArrayList<PanelSlotEvaluacionEstudiante>();


	/**
	 * Create the panel.
	 */
	public PanelValoracion() {
		
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0};
			gridBagLayout.columnWeights = new double[]{1.0};
			setLayout(gridBagLayout);
			
			JPanel panelProfesorMateria = new JPanel();
			GridBagConstraints gbc_panelProfesorMateria = new GridBagConstraints();
			gbc_panelProfesorMateria.insets = new Insets(0, 0, 5, 0);
			gbc_panelProfesorMateria.fill = GridBagConstraints.BOTH;
			gbc_panelProfesorMateria.gridx = 0;
			gbc_panelProfesorMateria.gridy = 0;
			add(panelProfesorMateria, gbc_panelProfesorMateria);
			GridBagLayout gbl_panelProfesorMateria = new GridBagLayout();
			gbl_panelProfesorMateria.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panelProfesorMateria.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panelProfesorMateria.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panelProfesorMateria.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelProfesorMateria.setLayout(gbl_panelProfesorMateria);
			
			JLabel lblNewLabel = new JLabel("Materia:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panelProfesorMateria.add(lblNewLabel, gbc_lblNewLabel);
			
			jcbMateria = new JComboBox<Materia>();
			GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
			gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
			gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcbMateria.gridx = 1;
			gbc_jcbMateria.gridy = 0;
			panelProfesorMateria.add(jcbMateria, gbc_jcbMateria);
			
			JLabel lblNewLabel_1 = new JLabel("Profesor:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			panelProfesorMateria.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			jcbProfesor = new JComboBox<Profesor>();
			GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
			gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
			gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcbProfesor.gridx = 1;
			gbc_jcbProfesor.gridy = 1;
			panelProfesorMateria.add(jcbProfesor, gbc_jcbProfesor);
			
			JButton btnRefrescar = new JButton("Refrescar");
			btnRefrescar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					refrescarEstudiantes();
				}
			});
			GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
			gbc_btnRefrescar.gridx = 2;
			gbc_btnRefrescar.gridy = 2;
			panelProfesorMateria.add(btnRefrescar, gbc_btnRefrescar);
			
			panelEstudiantes = new JPanel();
			GridBagConstraints gbc_panelEstudiantes = new GridBagConstraints();
			gbc_panelEstudiantes.weighty = 1.0;
			gbc_panelEstudiantes.insets = new Insets(0, 0, 5, 0);
			gbc_panelEstudiantes.fill = GridBagConstraints.BOTH;
			gbc_panelEstudiantes.gridx = 0;
			gbc_panelEstudiantes.gridy = 1;
			add(panelEstudiantes, gbc_panelEstudiantes);
			panelEstudiantes.setLayout(new BoxLayout(panelEstudiantes, BoxLayout.Y_AXIS));
			
			JButton btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardar();
				}
			});
			GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
			gbc_btnGuardar.anchor = GridBagConstraints.EAST;
			gbc_btnGuardar.gridx = 0;
			gbc_btnGuardar.gridy = 2;
			add(btnGuardar, gbc_btnGuardar);

			
			cargarTodasMaterias();
			cargarTodProfesores();
		}

		
		private void cargarTodasMaterias() {
			List<Materia> l = ControllerMateria.getTodos();
			for (Materia m : l) {
				this.jcbMateria.addItem(m);
			}
		}
		
		
		private void cargarTodProfesores() {
			List<Profesor> l = ControllerProfesor.getTodos();
			for (Profesor p : l) {
				this.jcbProfesor.addItem(p);
			}
		}
		
		
		
		private void refrescarEstudiantes() {
			List<Estudiante> l = ControllerEstudiante.getTodos();
			Profesor profSeleccionado = (Profesor) this.jcbProfesor.getSelectedItem();
			Materia matSeleccionada = (Materia) this.jcbMateria.getSelectedItem();
			
			this.panelEstudiantes.removeAll();
			this.listaSlotsValoracion.clear();
			
			for(Estudiante e : l) {
				PanelSlotEvaluacionEstudiante slot = 
						new PanelSlotEvaluacionEstudiante(profSeleccionado, e, matSeleccionada);
			
				this.listaSlotsValoracion.add(slot);
				
				this.panelEstudiantes.add(slot);
			}
			this.panelEstudiantes.revalidate();
			this.panelEstudiantes.repaint();
		}
		
		
		/**
		 * 
		 */
		private void guardar() {
			for(PanelSlotEvaluacionEstudiante panel : this.listaSlotsValoracion) {
				panel.guardarNota();
			}
			JOptionPane.showMessageDialog(null, "Actualizado.");
		}
		
		
}
