package capitulo01.bloque03;

import javax.swing.JOptionPane;

public class ex_02{


		public static void main(String[] args) {
			String str;
			int opcion;
			
			str = JOptionPane.showInputDialog("Calculadora: "
					+ "\n1.- Raizes\n2.- Potencias\n3.- Modulos");
			opcion = Integer.parseInt(str);
			
			
			switch (opcion) {
				case 1:
					str = JOptionPane.showInputDialog("Introduzca un número");
					int num1 = Integer.parseInt(str);
					str = JOptionPane.showInputDialog("Introduzca otro número");
					int num2 = Integer.parseInt(str);
					var num3 = Math.pow(num1, (1.0/num2));
					JOptionPane.showInternalMessageDialog(null, "El raiz "+num2 +"º" + " de " +num1 +" es: " +num3);
					break;
				case 2:
					str = JOptionPane.showInputDialog("Introduzca un número");
					int num4 = Integer.parseInt(str);
					str = JOptionPane.showInputDialog("Introduzca otro número");
					int num5 = Integer.parseInt(str);
					var num6 = Math.pow(num4, num5);
					JOptionPane.showInternalMessageDialog(null, num4 +" potenciado por " +num5 + " es: " +num6);
					break;
				case 3:
					str = JOptionPane.showInputDialog("Introduzca un número");
					int num7 = Integer.parseInt(str);
					str = JOptionPane.showInputDialog("Introduzca otro número");
					int num8 = Integer.parseInt(str);
					var num9 = (num7 / num8);
					JOptionPane.showInternalMessageDialog(null, "El modulo de la division de " +num7 +" entre " +num8 + " son " +num9);
					break;
				
			}
			
		
		}
}
	