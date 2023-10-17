package capitulo03.bloque01;

import javax.swing.JOptionPane;

public class bucleForParaProfesionales{
	

	public static void main(String[] args) {
		ex01();
	//	ex02();
//		ex03();
	//	ex04();
	}
		
	public static void ex01 () {
		
	int num = 1;
	int suma = 0;
	int count = 0;
		for (int i = 0; num != 0 ; i++) {
			String str;
			str = JOptionPane.showInputDialog("Introduzca un número");
			num  = Integer.parseInt(str);
				if (num != 0) {
					suma = suma + num;
					count++;
				}
				else {
					JOptionPane.showInternalMessageDialog(null, "El valor de la suma es: " +suma +" y la media de todos es: " +(suma/count));
				}
		}
	}
	
	public static void ex02 () {
		int num = 1;
		int mayor = 0;
		int menor = 0;
			for (int i = 0; num != 0 ; i++) {
				String str;
				str = JOptionPane.showInputDialog("Introduzca un número");
				num  = Integer.parseInt(str);
				if (i == 0) {
					mayor = num;
					menor = num;
				}
				else if (num != 0) {
						if (num > mayor) {
							mayor = num;
						}
						else if (num < menor) {
							menor = num;
						}
					}
					else {
						JOptionPane.showInternalMessageDialog(null, "El valor mayor es: " +mayor +" y el valor menor es: " +menor) ;
					}
			}
	}
	
	public static void ex03 () {
		int num = 1;
			for (int i = 0; num != 0 ; i++) {
				String str;
				str = JOptionPane.showInputDialog("Introduzca un número");
				num  = Integer.parseInt(str);
					if (num != 0) {
						for (int i2 = 0; i2 < 11; i2++)
						System.out.println(num +" por " +i2 +" es " +(num*i2));
					}
					else {
						break;
					}
			}
	}
	
	public static void ex04 () {
		int num = 1;
		int poscount = 0;
		int negcount = 0;
			for (int i = 0; num != 0 ; i++) {
				String str;
				str = JOptionPane.showInputDialog("Introduzca un número");
				num  = Integer.parseInt(str);
					if (num != 0) {
						if (num > 0) {
							poscount++;
						}
						else negcount++;
					}
					else {
						if (poscount > 1) {
							if (negcount > 1)
							JOptionPane.showInternalMessageDialog(null, "Hay " +poscount +" números positivos y " +negcount + " números negativos");
							else JOptionPane.showInternalMessageDialog(null, "Hay " +poscount +" números positivos y " +negcount + " número negativo");
						}
						else if (negcount > 1) {
							JOptionPane.showInternalMessageDialog(null, "Hay " +poscount +" número positivo y " +negcount + " números negativos");
						}
						else JOptionPane.showInternalMessageDialog(null, "Hay " +poscount +" número positivo y " +negcount + " número negativo");
					}
					
					}
			}
	}
