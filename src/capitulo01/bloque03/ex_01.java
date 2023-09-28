package capitulo01.bloque03;

import javax.swing.JOptionPane;

public class ex_01{


		public static void main(String[] args) {
			String str;
			int nota;
			
			str = JOptionPane.showInputDialog("Introduzca su grado: ");
			nota = Integer.parseInt(str);
			
			
			switch (nota) {
				case 0:
				case 1:
				case 2:
					JOptionPane.showInternalMessageDialog(null, "Muy deficiente");
					break;
				case 3:
				case 4:
					JOptionPane.showInternalMessageDialog(null, "Deficiente");
					break;
				case 5:
					JOptionPane.showInternalMessageDialog(null, "Suficiente");
					break;
				case 6:
					JOptionPane.showInternalMessageDialog(null, "Bien");
					break;
				case 7:
				case 8:
					JOptionPane.showInternalMessageDialog(null, "Notable");
					break;
				case 9:
				case 10:
					JOptionPane.showInternalMessageDialog(null, "Sobresaliente");
					break;
				default:
					JOptionPane.showInternalMessageDialog(null, "El valor no pertenece a ninguna nota");
			}
		}
}
	