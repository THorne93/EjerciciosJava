package capitulo08.centroeducativo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import Utils.Apariencia;
import capitulo08.centroeducativo.view.PanelCurso;
import capitulo08.centroeducativo.view.PanelEstudiante;
import capitulo08.centroeducativo.view.PanelMateria;
import capitulo08.centroeducativo.view.PanelProfesor;
import capitulo08.centroeducativo.view.PanelValoracion;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	public Principal() {
		super("Gestión de centro educativo");
		
		this.setBounds(0, 0, 800, 600);
		
		
		PanelCurso panelCurso = new PanelCurso();
		PanelMateria panelMateria = new PanelMateria();
		PanelProfesor panelProfesor = new PanelProfesor();
		PanelEstudiante panelEstudiante = new PanelEstudiante();
		PanelValoracion panelValoracion = new PanelValoracion();
		JTabbedPane panelTabbed = new JTabbedPane();

		panelTabbed.addTab("Cursos", panelCurso);
		panelTabbed.addTab("Materias", panelMateria);
		panelTabbed.addTab("Profesores", panelProfesor);
		panelTabbed.addTab("Estudiantes", panelEstudiante);
		panelTabbed.addTab("Valoración", panelValoracion);
		panelTabbed.setSelectedIndex(0);
		this.getContentPane().add(panelTabbed);



	}


	public static void main(String[] args) {

		Principal ventana = new Principal();
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
	}

	private static void cerrarAplicacion() {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea cerrar la aplicación?", "Salir de la aplicación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}


}