package capitulo01.bloque03;

import javax.swing.JOptionPane;

public class ex_04{


		public static void main(String[] args) {
			
			String str;
			
			str = JOptionPane.showInputDialog("Introduzca el importe");
			int importe = Integer.parseInt(str);
			
			str = JOptionPane.showInputDialog("Introduzca la cantidad recibida");
			int cantidad = Integer.parseInt(str);
			
			int vuelta = (cantidad - importe);
			int cien = (vuelta / 100);
			int resto1 = (vuelta % 100);
			
			int cincuenta = (resto1 / 50);
			int resto2 = (resto1 % 50);
			
			int vientecinco = (resto2 / 25);
			int resto3 = (resto2 % 25);
			
			int cinco = (resto3 / 5);
			int resto4 = (resto3 % 5);
			
			JOptionPane.showInternalMessageDialog(null, "El cambio es: " +vuelta +" con las siguentes monedas: " + '\n' +cien +" monedas de 100 = " +(cien *100)
					+ '\n' +cincuenta +" monedas de 50 = " +(cincuenta *50)
					+ '\n' +vientecinco +" monedas de 25 = " +(vientecinco *25)
					+ '\n' +cinco +" monedas de 5 = " +(cinco *5)
					+ '\n' +resto4 +" monedas de 1 = " +(resto4));
			
			System.out.println(resto1);
		}
}
	