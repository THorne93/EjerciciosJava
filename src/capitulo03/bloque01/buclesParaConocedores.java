package capitulo03.bloque01;
import javax.swing.JOptionPane;
public class buclesParaConocedores{
	

	public static void main(String[] args) {
//		ex01();
		ex02();
	//	ex03();
//		ex04();
	//	ex05();
	}
		
	public static void ex01 () {
		String str;
		str = JOptionPane.showInputDialog("Introduzca un número");
		int num  = Integer.parseInt(str);
		int numoriginal = num;
		int million = (num / 1000000);
		num = num % 1000000;
		int cienmil = (num/100000);
		num = num % 100000;
		int diezmil = (num/10000);
		num = num % 10000;
		int mil = (num/1000);
		num = num % 1000;
		int cien = (num/100);
		num = num % 100;
		int diez = (num / 10);
		num = num % 10;
		
		JOptionPane.showInternalMessageDialog(null, "El número original es: " +numoriginal +" y el sumo de los digitos es: " +(million +cienmil +diezmil +mil +cien +diez + num));
		
		
		System.out.println(million);
	}
	
	public static void ex02 () {
		int num1 =0, num2=1;
		String str;
		str = JOptionPane.showInputDialog("Introduzca un limite");
		int limit  = Integer.parseInt(str);
				
			for (int i=0 ; i < limit ; i++) {
				if (i == 0) {
					System.out.println(num1);
					System.out.println(num2);
				}
				else {
					int num3 = num1 + num2;	
					System.out.println(num3);
					num1 = num2;
					num2 = num3;
				}
			}				
	}

	public static void ex04 () {
		int num = 1;
		var answer = Math.floor(Math.random() *100);
		String str;
			while (num !=0) {
				
				str = JOptionPane.showInputDialog("Introduzca un número");
				num  = Integer.parseInt(str);
				
				if (num == answer) JOptionPane.showInternalMessageDialog(null, "Felicidades! Has entontrado el número!");
				else
					if (num > answer) JOptionPane.showInternalMessageDialog(null, "menos...");
					if (num < answer) JOptionPane.showInternalMessageDialog(null, "mas...");
			}
					
	}
}