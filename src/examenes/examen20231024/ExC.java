package examenes.examen20231024;

import javax.swing.JOptionPane;

public class ExC {

	public static void main(String[] args) {
		// inicializa los integers y strings
		int num1 = 0, num2 = 1;
		int num3 = 0;
		String str;

		// pide el numero que quiere ver y convierte en integer
		str = JOptionPane.showInputDialog("Que numero fibonacci quieres ver?");
		int limit = Integer.parseInt(str);

		//calcula los numeros de fibonacci
		for (int i = 1; i < limit; i++) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
		}
		
		//imprime el numero correcto
		System.out.println(num3);
	}
}