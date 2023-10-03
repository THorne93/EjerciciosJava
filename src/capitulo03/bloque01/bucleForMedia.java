package capitulo03.bloque01;

import javax.swing.JOptionPane;

public class bucleForMedia{


	

	public static void main(String[] args) {
	//	ex01();
	//	ex02();
	//	ex03();
		ex04();
	}
		
	public static void ex01 () {
		
	int suma = 0;
	int count = 0;
	
	String str;
	
	str = JOptionPane.showInputDialog("Cuántos números vas a introducir?");
	int imax  = Integer.parseInt(str);
	
		for (int i = 0; i < imax ; i++) {
			
			str = JOptionPane.showInputDialog("Introduzca un número");
			int num  = Integer.parseInt(str);
					suma = suma + num;
					count++;
				}
		JOptionPane.showInternalMessageDialog(null, "La media es: " +(suma/count)) ;
		}
	
	
	public static void ex02 () {
		int mayor = 0;
		int menor = 0;
		String str;
		str = JOptionPane.showInputDialog("Cuántos");
		int count  = Integer.parseInt(str);
		
		for (int i = 0; i < count ; i++) {
				str = JOptionPane.showInputDialog("Introduzca un número");
				int num  = Integer.parseInt(str);
				if(i == 0) {
					mayor = num;
					menor = num;
				}
				else if (num > mayor) {
						mayor = num;
					}
					else if (num < menor) {
						menor = num;	
					}
					else continue;
			}
			JOptionPane.showInternalMessageDialog(null, "El valor mayor es: " +mayor +" y el valor menor es: " +menor) ;
			}
	
	
	public static void ex03 () {
		String str;
		str = JOptionPane.showInputDialog("Introduzca un número");
		int num  = Integer.parseInt(str);
			for (int i = 0; (i * num ) < 100 ; i++) {
						System.out.println(num +" por " +i +" es " +(num*i));
			}			
	}
	
	public static void ex04 () {
		String str;
		str = JOptionPane.showInputDialog("Introduzca un número");
		int num  = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduzca un limite");
		int limit  = Integer.parseInt(str);		
			for (int i = 0; (i * num ) < limit ; i++) {
						System.out.println(num +" por " +i +" es " +(num*i));
			}			
	}
}