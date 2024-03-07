package capitulo03.bloque01;

import javax.swing.JOptionPane;

public class bucleFor{


		public static void main(String[] args) {
			
			for (int i = 0; i < 25; i++) {
				int guest = Utils.Arrays.getRandomNumber(1, 20);
				int ep = 99;
				
				do {
					ep = Utils.Arrays.getRandomNumber(i, i+2);
				} while (ep == 5 || ep == 11 || ep == 15 || ep == 16 || ep == 21 || ep == 24 || ep == 28 || ep == 99);
				
				System.out.print("("+(i+1)+","+ep+","+guest+"),");
				
			}
		}
}
