package arkanoid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Clase principal, que crea los monstruos
 *
 */
public class Arkanoid {

	private static int FPS = 60;
	private JFrame ventana = null;
	private List<Actor> actores = new ArrayList<Actor>();
	private MiCanvas canvas = null;
	Nave jugador = null;

	
	// Para utilizar un patrón singleton necesitamos la siguiente propiedad estática
	private static Arkanoid instance = null;
	
	/**
	 * Este método representa la principal funcionalidad de un patrón Singleton.
	 * Devuelve la única instancia que puede existir del esta clase. Si no se ha 
	 * inicializado, en la primera llamada a este método se realiza dicha 
	 * inicialización.
	 */
	public static Arkanoid getInstance () {
		if (instance == null) { // Si no está inicializada, se inicializa
			instance = new Arkanoid();
		}
		return instance;
	}
	
	
	/**
	 * Constructor
	 */
	public Arkanoid () {
		ventana = new JFrame("Arkanoid");
		ventana.setBounds(0, 0, 600, 800);
		
		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla) al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());
		
		// Creo una lista de actores que intervendrá en el juego.
		actores = creaActores();
		
		// Creo y agrego un canvas, es un objeto que permitirá dibujar sobre él
		canvas = new MiCanvas(actores);
		
		canvas.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				jugador.mover(e.getX());
			}			
		});
		
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				jugador.keyPressed(e);
			}
			
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				jugador.keyReleased(e);
			}
		});
		
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		// Consigo que la ventana no se redibuje por los eventos de Windows
		ventana.setIgnoreRepaint(true);
		// Hago que la ventana sea visible
		ventana.setVisible(true);
		
		canvas.requestFocus();
		
		// Control del evento de cierre de ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		

		
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// Comienzo un bucle, que consistirá en el juego completo.
		Arkanoid.getInstance().juego();
	}
	
	
	
	
	/**
	 * Al cerrar la aplicación preguntaremos al usuario si está seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	
	

	
	/**
	 * Bucle del juego principal
	 */
	public void juego () {
		int millisPorCadaFrame = 1000 / FPS;
		do {
			// Redibujo la escena tantas veces por segundo como indique la variable FPS
			// Tomo los millis actuales
			long millisAntesDeProcesarEscena = new Date().getTime();
			
			// Redibujo la escena
			canvas.repaint();
			
			// Recorro todos los actores, consiguiendo que cada uno de ellos actúe
			for (Actor a : actores) {
				a.actua();
			}
			
			// Calculo los millis que debemos parar el proceso, generando 60 FPS.
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesDeProcesarEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0)? 0 : millisPausa;
			// "Duermo" el proceso principal durante los milllis calculados.
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private List<Actor> creaActores () {
		List<Actor> actores = new ArrayList<Actor>();
		
		//Construyo un player para este juego y lo agrego a la lista
		jugador = new Nave(10, 700, Nave.IMAGEN_PLAYER);
		actores.add(jugador);
		
		
		int sumarx=0, sumary=0;
		for (int i = 0; i<5; i++) {
			sumarx =0;
			
			for (int j = 0; j<10; j++) {
				int xAleatoria = 20 + sumarx;
				int yAleatoria = 20 + sumary;
				Ladrillo l = new Ladrillo(xAleatoria, yAleatoria, Nave.IMAGEN_PLAYER);
				l.setPuntosVida(Utils.Arrays.getRandomNumber(1, 3));
				actores.add(l);
				sumarx += 55;
			}
			sumary += 40;
		}
	
		
		Pelota p = new Pelota(200,200, Nave.IMAGEN_PLAYER);
		actores.add(p);
		
		// Creo los Monstruos del juego

		
		// Devuelvo la lista con todos los actores del juego
		return actores;
	}

	/**
	 * Obtención de un número aleatorio en unos límites
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	private static int numAleatorio (int minimo, int maximo) {
		return (int) Math.round(Math.random() * (maximo - minimo) + minimo);
	}
	
	public MiCanvas getCanvas() {
		return canvas;
	}
}
