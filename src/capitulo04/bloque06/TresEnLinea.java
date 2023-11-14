package capitulo04.bloque06;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TresEnLinea {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int m[][] = new int[][] { { 0, 0, 0, }, { 0, 0, 0, }, { 0, 0, 0, } };

		boolean correctChoice = false;
		int gameVers;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}

		do {
			gameVers = Utils.Arrays.requestNumber("1 para dos jugadores \n2 para facil \n3 para medio \n4 para dificil");
			if (gameVers == 1 || gameVers == 2 || gameVers == 3 || gameVers == 4) {
				correctChoice = true;
			}
		} while (correctChoice == false);

		switch (gameVers) {
		case 1:
			dosJugadores(m);
			break;
		case 2:
			aiFacil(m);
			break;
		case 3:
			aiMedio(m);
			break;
		case 4:
			aiDificil(m);
			break;
		}

	}

	private static void aiFacil(int[][] m) {
		int playCount = 0;

		var test = 0;
		boolean gameOver = false;
		boolean hayGanador = true;
		int playerNumber = 0;
		int winner = 0;
		int x = 0, y = 0;

		
		// prueba si la posicion ha sido elegido antes
		do {
			playerNumber = 1;
			int playerPosition;
			boolean isMatch = true;
			do {
				playerPosition = Utils.Arrays.requestNumber("Que posicion eliges?");

				if (playerPosition < 10) {
					continue;
				}

				x = (playerPosition / 10) - 1;
				y = (playerPosition % 10) - 1;

				if (m[x][y] == 0) {
					isMatch = false;
				}
				if (m[x][y] != 0) {
					System.out.println("Hay que elegir otra posicion!!");
				}
				test = y;

			} while (isMatch == true);

			m[x][y] = 1;
			System.out.println();
			
			//imprime matriz
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + "\t");
				}
				System.out.println();
			}
			playCount++;

			//prueba si haya una combinacion
			gameOver = testEnd(m, playerNumber);
			if (gameOver == true) {
				winner = 1;
				break;
			}
			
			//termina el metodo si todas las posiciones son elegidas
			if (playCount == 9) {
				gameOver = true;
				System.out.println("No ha ganado nadie");
				hayGanador = false;
				break;
			}

			//para simular pensamiento
			System.out.println("La I.A esta pensando...");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}

			playerNumber = 2;

			//para la ia elige una posicion
			isMatch = true;
			do {

				x = (int) Math.floor(Math.random() * 3);
				y = (int) Math.floor(Math.random() * 3);

				if (m[x][y] == 0) {
					isMatch = false;
				}

			} while (isMatch == true);

			m[x][y] = 2;
			test = y;
			System.out.println();

			//imprime matriz
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + "\t");
				}
				System.out.println();
			}

			playCount++;

			gameOver = testEnd(m, playerNumber);
			if (gameOver == true) {
				winner = 2;
				break;
			}

		} while (gameOver != true);

		//imprime quien haya ganado (si hubiese)
		if (hayGanador == true) {

			System.out.println("Ha ganado jugador " + winner + "!");

		}
	}

	private static void aiMedio(int[][] m) {
		//todo igual como la iafacil menos lo que esta comentado
		
		int playCount = 0;

		var test = 0;
		boolean gameOver = false;
		boolean hayGanador = true;
		int playerNumber = 0;
		int winner = 0;
		int x = 0, y = 0;

		do {
			playerNumber = 1;
			int playerPosition;
			boolean isMatch = true;
			do {
				playerPosition = Utils.Arrays.requestNumber("Que posicion eliges?");

				if (playerPosition < 10) {
					continue;
				}

				x = (playerPosition / 10) - 1;
				y = (playerPosition % 10) - 1;

				if (m[x][y] == 0) {
					isMatch = false;
				}
				if (m[x][y] != 0) {
					System.out.println("Hay que elegir otra posicion!!");
				}
				test = y;

			} while (isMatch == true);

			m[x][y] = 1;
			System.out.println();

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + "\t");
				}
				System.out.println();
			}
			playCount++;

			gameOver = testEnd(m, playerNumber);
			if (gameOver == true) {
				winner = 1;
				break;
			}

			System.out.println("La I.A esta pensando...");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}

			if (playCount == 9) {
				gameOver = true;
				System.out.println("No ha ganado nadie");
				hayGanador = false;
			}

			playerNumber = 2;

			isMatch = true;
			boolean heGanado = false;

			//busca posible combinaciones del usuario y intenta fastidiarlo
			impedirGanar(m, playerPosition, heGanado);

			if (heGanado == true) {
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[i].length; j++) {
						System.out.print(m[i][j] + "\t");
					}
					System.out.println();
				}
				break;
			} else
				do {

					x = (int) Math.floor(Math.random() * 3);
					y = (int) Math.floor(Math.random() * 3);

					if (m[x][y] == 0) {
						isMatch = false;
					}

				} while (isMatch == true);

			m[x][y] = 2;
			test = y;
			System.out.println();

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + "\t");
				}
				System.out.println();
			}

			playCount++;
			gameOver = testEnd(m, playerNumber);
			if (gameOver == true) {
				winner = 2;
				break;
			}

			if (playCount == 9) {
				gameOver = true;
				System.out.println("No ha ganado nadie");
				hayGanador = false;
			}

		} while (gameOver != true);

		if (hayGanador == true) {

			System.out.println("Ha ganado jugador " + playerNumber + "!");

		}
	}

	private static void aiDificil(int[][] m) {
		//todo igual que la ia media menos lo que esta comentado
		
		int playCount = 0;

		var test = 0;
		boolean gameOver = false;
		boolean hayGanador = true;
		int playerNumber = 0;
		int winner = 0;
		int x = 0, y = 0;
		int moves;

		do {
			playerNumber = 1;
			int playerPosition;
			boolean isMatch = true;
			do {
				playerPosition = Utils.Arrays.requestNumber("Que posicion eliges?");

				if (playerPosition < 10) {
					continue;
				}

				x = (playerPosition / 10) - 1;
				y = (playerPosition % 10) - 1;

				if (m[x][y] == 0) {
					isMatch = false;
				}
				if (m[x][y] != 0) {
					System.out.println("Hay que elegir otra posicion!!");
				}
				test = y;

			} while (isMatch == true);

			m[x][y] = 1;
			System.out.println();

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + "\t");
				}
				System.out.println();
			}
			playCount++;

			gameOver = testEnd(m, playerNumber);
			if (gameOver == true) {
				winner = 1;
				break;
			}
			if (playCount == 9) {
				gameOver = true;
				System.out.println("No ha ganado nadie");
				hayGanador = false;
				break;
			}

			System.out.println("La I.A esta pensando...");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}

			playerNumber = 2;

			isMatch = true;
			boolean heGanado = false;
			moves = 0;

			//busca combinaciones posibles para ganar, en filas, columnas y diagonal
			heGanado = intentaFila(m, heGanado);

			heGanado = intentaColumna(m, heGanado);
			if (m[0][0] == 2 && m[1][1] == 2 && m[2][2] == 0) {
				m[2][2] = 2;
				heGanado = true;
				break;
			}
			if (m[0][0] == 0 && m[1][1] == 2 && m[2][2] == 2) {
				m[0][0] = 2;
				heGanado = true;
				break;
			}
			if (m[0][0] == 2 && m[1][1] == 0 && m[2][2] == 0) {
				m[1][1] = 2;
				heGanado = true;
				break;
			}
			// reverse diagonal
			if (m[0][2] == 2 && m[1][1] == 2 && m[3][0] == 0) {
				m[3][0] = 2;
				heGanado = true;
				break;
			}
			if (m[0][2] == 0 && m[1][1] == 2 && m[3][0] == 2) {
				m[0][2] = 2;
				heGanado = true;
				break;
			}
			if (m[0][2] == 2 && m[1][1] == 0 && m[3][0] == 2) {
				m[1][1] = 2;
				heGanado = true;
				break;
			}
			
			//si no hay una combinacion para ganar, intenta impedir que ganese el usuario
			heGanado = impedirGanar(m, moves, heGanado);

			//si no, elige aliatoriamente otra posicion
			if (heGanado == false)
				do {

					x = (int) Math.floor(Math.random() * 3);
					y = (int) Math.floor(Math.random() * 3);

					if (m[x][y] == 0) {
						isMatch = false;
					}
					m[x][y] = 2;
				} while (isMatch == true);

			test = y;
			System.out.println();

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + "\t");
				}
				System.out.println();
			}

			playCount++;

			gameOver = testEnd(m, playerNumber);
			if (gameOver == true) {
				winner = 2;
				break;
			}

			if (playCount == 9) {
				gameOver = true;
				System.out.println("No ha ganado nadie");
				hayGanador = false;
			}

		} while (gameOver != true);

		if (hayGanador == true) {

			System.out.println("Ha ganado jugador " + playerNumber + "!");

		}
	}

	private static boolean intentaColumna(int[][] m, boolean heGanado) {
		for (int j = 0; j < m.length; j++) {
			if (m[0][j] == 2 && m[1][j] == 2 && m[2][j] == 0) {
				m[2][j] = 2;
				heGanado = true;
				break;
			} else if (m[1][j] == 2 && m[2][j] == 2 && m[0][j] == 0) {
				m[0][j] = 2;
				heGanado = true;
				break;
			}

			else if (m[0][j] == 2 && m[2][j] == 2 && m[1][j] == 0) {
				m[1][j] = 2;
				heGanado = true;
				break;
			}
		}
		return heGanado;
	}

	private static boolean intentaFila(int[][] m, boolean heGanado) {
		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == 2 && m[i][1] == 2 && m[i][1] == 0) {
				m[i][2] = 2;
				heGanado = true;
				break;
			} else if (m[i][1] == 2 && m[i][2] == 2 && m[i][1] == 0) {
				m[i][0] = 2;
				heGanado = true;
				break;
			}

			else if (m[i][0] == 2 && m[i][2] == 2 && m[i][1] == 0) {
				m[i][1] = 2;
				heGanado = true;
				break;
			}
		}
		return heGanado;
	}

	private static boolean impedirGanar(int[][] m, int moves, boolean heGanado) {
		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == 1 && m[i][1] == 1 && m[i][2] == 0 && moves == 0) {
				m[i][2] = 2;
				heGanado = true;
				moves++;
			} else if (m[i][0] == 0 && m[i][1] == 1 && m[i][2] == 1 && moves == 0) {
				m[i][0] = 2;
				heGanado = true;
				moves++;
			}

			else if (m[i][0] == 1 && m[i][1] == 0 && m[i][2] == 1 && moves == 0) {
				m[i][1] = 2;
				heGanado = true;
				moves++;
			}
		}

		for (int j = 0; j < m.length; j++) {
			if (m[0][j] == 1 && m[1][j] == 1 && m[2][j] == 0 && moves == 0) {
				m[2][j] = 2;
				heGanado = true;
				moves++;
			} else if (m[1][j] == 1 && m[2][j] == 1 && m[0][j] == 0 && moves == 0) {
				m[0][j] = 2;
				heGanado = true;
				moves++;
			}

			else if (m[0][j] == 1 && m[2][j] == 1 && m[1][j] == 0 && moves == 0) {
				m[1][j] = 2;
				heGanado = true;
				moves++;
			}
		}
		if (m[0][0] == 1 && m[1][1] == 1 && m[2][2] == 0 && moves == 0) {
			m[2][2] = 2;
			heGanado = true;
			moves++;
		}
		if (m[0][0] == 0 && m[1][1] == 1 && m[2][2] == 1 && moves == 0) {
			m[0][0] = 2;
			heGanado = true;
			moves++;
		}
		if (m[0][0] == 1 && m[1][1] == 0 && m[2][2] == 1 && moves == 0) {
			m[1][1] = 2;
			heGanado = true;
			moves++;
		}
		// reverse diagonal
		if (m[0][2] == 1 && m[1][1] == 1 && m[2][0] == 0 && moves == 0) {
			m[2][0] = 2;
			heGanado = true;
			moves++;
		}
		if (m[0][2] == 0 && m[1][1] == 1 && m[2][0] == 1 && moves == 0) {
			m[0][2] = 2;
			heGanado = true;
			moves++;
		}
		if (m[0][2] == 1 && m[1][1] == 0 && m[2][0] == 1 && moves == 0) {
			m[1][1] = 2;
			heGanado = true;
			moves++;
		}
		return heGanado;
	}

	private static boolean testEnd(int[][] m, int playerNumber) {
		boolean gameOver = false;
		boolean lineaHorizontal = false;

		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == playerNumber && m[i][1] == playerNumber && m[i][2] == playerNumber) {
				lineaHorizontal = true;
				break;
			}

		}
		if (lineaHorizontal == true) {
			gameOver = true;
		}
		boolean lineaVertical = false;

		for (int j = 0; j < m.length; j++) {
			if (m[0][j] == playerNumber && m[1][j] == playerNumber && m[2][j] == playerNumber) {
				lineaVertical = true;
				break;
			}
		}

		if (lineaVertical == true) {
			gameOver = true;
		}

		boolean lineaDiagonal = false;

		if (m[0][0] == playerNumber && m[1][1] == playerNumber && m[2][2] == playerNumber) {
			lineaDiagonal = true;
		}
		if (m[0][2] == playerNumber && m[1][1] == playerNumber && m[2][0] == playerNumber) {
			lineaDiagonal = true;
		}
		if (lineaDiagonal == true) {
			gameOver = true;
		}

		return gameOver;
	}

	private static void dosJugadores(int[][] m) {
		int playCount = 0;
		int playerPosition = 0;
		boolean gameOver = false;
		boolean hayGanador = true;
		int playerNumber = 0;
		int winner = 0;
		var test = 0;
		int x = 0, y = 0;

		do {

			if (playCount % 2 == 0) {
				playerNumber = 1;
			} else
				playerNumber = 2;
			boolean isMatch = true;

			do {
				playerPosition = Utils.Arrays.requestNumber("Jugador " + playerNumber + " , Que posicion eliges?");

				if (playerPosition < 10) {
					continue;
				}

				x = (playerPosition / 10) - 1;
				y = (playerPosition % 10) - 1;

				if (m[x][y] == 0) {
					isMatch = false;
				}
				if (m[x][y] != 0) {
					System.out.println("Hay que elegir otra posicion!!");
				}

			} while (isMatch == true);

			m[x][y] = playerNumber;
			System.out.println();

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + "\t");
				}
				System.out.println();
			}

			gameOver = testEnd(m, playerNumber);
			playCount++;

			if (playCount == 9) {
				gameOver = true;
				System.out.println("No ha ganado nadie");
				hayGanador = false;
			}

		} while (gameOver != true);

		if (hayGanador == true) {

			if (m[test][test] == 1) {
				winner = 1;
				System.out.println("Ha ganado jugador " + winner + "!");
			}
			if (m[test][test] == 2) {
				winner = 2;
				System.out.println("Ha ganado jugador " + winner + "!");
			}
		}

	}
}
