package capitulo03.bloque01;

import javax.swing.JOptionPane;

public class bucleFor{


		public static void main(String[] args) {
			String str;
			int sum = 0;
			int pos = 0;
			int neg = 0;
			str = JOptionPane.showInputDialog("Cuántos números vas a pedir?");
			int tot  = Integer.parseInt(str);
			
				for (int i = 0; i < tot; i++) {
					{str = JOptionPane.showInputDialog("Introduzca un número");
					int num = Integer.parseInt(str);

						if (num >= 0) {
							if (num >= 10) {
								sum = sum + num;
								pos++;
							}
							else pos++;
						}
						else neg++;	
						}
					}
				JOptionPane.showInternalMessageDialog(null, "Hay " + pos + " positivos y " + neg +" negativos. El total es: " +sum);
				}
		}
