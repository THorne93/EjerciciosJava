package capitulo03.bloque01;
import javax.swing.JOptionPane;
public class bucleWhileDoWhile{
	

	public static void main(String[] args) {
	//	ex01();
	//	ex02();
	//	ex03();
	//	ex04();
		ex05();
	}
		
	public static void ex01 () {
		int num =1 ;
		int i = 2;	
		boolean esPrimo = true;
		
		String str;
		
		while (num != 0) {
		
			
			str = JOptionPane.showInputDialog("Introduzca un número");
			num  = Integer.parseInt(str);
			
			
				while (i < num) {
					if (num % i == 0) {
						esPrimo = false;
					}
					i++;
				}
			
				if (esPrimo == true) {						
					System.out.println("el número " +num +" es Primo");				
				}
				else System.out.println("el número " +num +" no es Primo");	

				esPrimo = true;
				i = 2;	
			
		}
	}
	public static void ex02 () {		//esto me costaba mucho
		int count =1;
		int num1 =1 ;
		int num2 =1;
		int i = 2;	
		boolean esPrimo = true;
		
		String str;
		str = JOptionPane.showInputDialog("Introduzca el limite inferior");
		num1  = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduzca el limite superior");
		num2  = Integer.parseInt(str);
		count= num1;
		
		while (num1 <= count && count <= num2) {	
			
			while (i < count) {
				if (count % i == 0) {
					esPrimo = false;
				}
				i++;
			}
		
			if (esPrimo == true) {						
				System.out.println("El número " +count +" es Primo");				
			}

			esPrimo = true;
			i = 2;	
			count++;
				
		}
	}
	public static void ex03 () {
		int i;
		int count =1;
		i = 1;	
	
		do {
				
			do {
			System.out.println(count +" x " +i +" = " +(count*i));
			i++;
			} while (i < 13);
			
		i = 1;	
		count++;
		} while (count < 16);
	}
	
	public static void ex04 () {
		String str;
		int num = 1;
		
		while (num != 0) {
			str = JOptionPane.showInputDialog("Introduzca un número (0 para terminar)");
			num  = Integer.parseInt(str);
			System.out.println(Integer.toBinaryString(num));
		}
	}
	
	public static void ex05 () {
		String str;
		int factorial = 1;
		
		while (factorial != 0) {
			str = JOptionPane.showInputDialog("Introduzca un número (0 para terminar)");
			factorial  = Integer.parseInt(str);
			int count = factorial;
			int i = 1;
				while ( i < count) {
					factorial = factorial * i;
					i++;
				}
			System.out.println("El factorial es: " +factorial);
		}
	}
	
	
}


