package capitulo01.bloque03;

import javax.swing.JOptionPane;

public class ex_03{


		public static void main(String[] args) {
			String str;
			int opcion;
			
			str = JOptionPane.showInputDialog("Calculadora: "
					+ "\n1.- Hipotenusa de un triángulo\n2.- Superficie de una circunferencia\n3.- Perímetro de una circunferencia\n4.- Área de un rectángulo\n5.- Área de un triángulo");
			opcion = Integer.parseInt(str);
			
			
			switch (opcion) {
				case 1:
					str = JOptionPane.showInputDialog("Introduzca un longitud (cm)");
					int num1 = Integer.parseInt(str);
					str = JOptionPane.showInputDialog("Introduzca el otro longitud (cm)");
					int num2 = Integer.parseInt(str);
					var num3 = (Math.pow(num1, 2.0) + Math.pow(num2, 2));
					var num4 = Math.sqrt(num3);
					JOptionPane.showInternalMessageDialog(null, "La longitud de la hipotenusa es: " +num4 +" cm");
					break;
				case 2:
					str = JOptionPane.showInputDialog("Introduzca el radio (cm)");
					int num5 = Integer.parseInt(str);
					var num6 = (Math.PI * (Math.pow(num5, 2))); 
				JOptionPane.showInternalMessageDialog(null, "La superficie de la circunferencia es: " +num6 +" cm");
					break;
				case 3:
					str = JOptionPane.showInputDialog("Introduzca el radio (cm)");
					int num7 = Integer.parseInt(str);
					var num8 = (2*(Math.PI * num7)); 
				JOptionPane.showInternalMessageDialog(null, "La longitud del radio de la circunferencia es: " +num8 +" cm");
					break;
				case 4:
					str = JOptionPane.showInputDialog("Introduzca la longitud de la base (cm)");
					int num9 = Integer.parseInt(str);
					str = JOptionPane.showInputDialog("Introduzca la longitud de la altura (cm)");
					int num10 = Integer.parseInt(str);
					var num11 = (num9 * num10); 
				JOptionPane.showInternalMessageDialog(null, "El área del rectángulo es: " +num11 +" cm^2");
					break;
				case 5:
					str = JOptionPane.showInputDialog("Introduzca la longitud de la base (cm)");
					int num12 = Integer.parseInt(str);
					str = JOptionPane.showInputDialog("Introduzca la longitud de la altura (cm)");
					int num13 = Integer.parseInt(str);
					var num14 = (0.5*(num12 * num13)); 
				JOptionPane.showInternalMessageDialog(null, "El área del triangulo es: " +num14 +" cm^2");
					break;
				default:
					JOptionPane.showInternalMessageDialog(null, "Opción incorrecta");
			}
			
		
		}
}
	