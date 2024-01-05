package tresenraya;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class TresEnRaya extends Canvas {

		JFrame ventana = new JFrame("3 en Raya");
		
		private static final int JFRAME_WIDTH=700;
		private static final int JFRAME_HEIGHT=700;
		
		
		List<Cuadro> cuadros = new ArrayList<Cuadro>();
		
		private static TresEnRaya instance = null;
		
		public static int JUGADOR_1 = 1;
		public static int JUGADOR_2 = 2;
		private int turnoActual = JUGADOR_1;
		
		private int matrizJugadas[][] = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
		
		
		public TresEnRaya() {
			
			SoundsRepository.getInstance();
			SpritesRepository.getInstance();
			
			JPanel panel = (JPanel) ventana.getContentPane();
			panel.setLayout(new BorderLayout());
			panel.add(this,BorderLayout.CENTER);
			
			ventana.setBounds(0,0,JFRAME_WIDTH,JFRAME_HEIGHT);
			
			inicializaCuadrosDelTablero();
			
			this.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					if (e.getButton() == MouseEvent.BUTTON1) {
						for(Cuadro cuadro : cuadros) {
							if (cuadro.seHaHechoclicSobreCuadro(e.getX(), e.getY())) {
								cuadro.clic(turnoActual);
								if (turnoActual == JUGADOR_1) {
									SoundsRepository.getInstance().playSound("federer.wav");
									turnoActual = JUGADOR_2;
								}
								else {
									SoundsRepository.getInstance().playSound("nadal.wav");
									turnoActual = JUGADOR_1;
								}
							}
						}
					}
				}
			});
			
			ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			ventana.addWindowListener( new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					cerrarAplicacion();
				}
			});
			ventana.setVisible(true);
		}
		
		public static TresEnRaya getInstance () {
			if (instance == null) {
				instance = new TresEnRaya();
			}
			return instance;
		}
		
		private void inicializaCuadrosDelTablero() {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					this.cuadros.add(new Cuadro(i,j));
				}
			}
		}
		
		
		
		private void cerrarAplicacion() {
			String [] opciones = {"Aceptar","Cancelar"};
			int eleccion = JOptionPane.showOptionDialog(ventana, "Desea cerra la aplicación?", "Salir de la aplicación",
			JOptionPane.YES_NO_OPTION, 
			JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
			if (eleccion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			for (Cuadro cuadro : cuadros) {
				cuadro.paint(g);				
			}
		}
		
		public void checkGame(int[][] matrizJugadas, int jugador) {
			int m[][] = matrizJugadas;
			boolean gameOver = false;
			boolean isDraw = true;
			boolean lineaHorizontal = false;

			for (int i = 0; i < m.length; i++) {
				if (m[i][0] == jugador && m[i][1] == jugador && m[i][2] == jugador) {
					lineaHorizontal = true;
					break;
				}

			}
			if (lineaHorizontal == true) {
				gameOver = true;
			}
			boolean lineaVertical = false;

			for (int j = 0; j < m.length; j++) {
				if (m[0][j] == jugador && m[1][j] == jugador && m[2][j] == jugador) {
					lineaVertical = true;
					break;
				}
			}

			if (lineaVertical == true) {
				gameOver = true;
			}

			boolean lineaDiagonal = false;

			if (m[0][0] == jugador && m[1][1] == jugador && m[2][2] == jugador) {
				lineaDiagonal = true;
			}
			if (m[0][2] == jugador && m[1][1] == jugador && m[2][0] == jugador) {
				lineaDiagonal = true;
			}
			if (lineaDiagonal == true) {
				gameOver = true;
			}

			if (gameOver == true) {
				endGame();
				
			}
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if (m[i][j] == 0) {
						isDraw = false;
						break;
					}
				}
			}
			if (isDraw == true) {
				endGameDraw();
			}
		}
		
		public void endGame() {
			SoundsRepository.getInstance().playSound("cheer.wav");
			String [] opciones = {"¡OLÉ!"};
			int eleccion = JOptionPane.showOptionDialog(ventana, "¡Ha ganado Jugador " +turnoActual +"!", "FIN DE JUEGO",
			JOptionPane.YES_NO_OPTION, 
			JOptionPane.QUESTION_MESSAGE, null, opciones, null);
			if (eleccion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		public void endGameDraw() {
			SoundsRepository.getInstance().playSound("boo.wav");
			String [] opciones = {"Vaya.."};
			int eleccion = JOptionPane.showOptionDialog(ventana, "No ha ganado nadie...", "FIN DE JUEGO",
			JOptionPane.YES_NO_OPTION, 
			JOptionPane.QUESTION_MESSAGE, null, opciones, null);
			if (eleccion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		public int[][] getMatrizJugadas() {
			return matrizJugadas;
		}
		
		public static void main(String[] args) {
			TresEnRaya.getInstance();
		}
}
