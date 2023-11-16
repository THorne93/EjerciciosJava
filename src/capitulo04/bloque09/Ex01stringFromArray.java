package capitulo04.bloque09;

public class Ex01stringFromArray {

	public static void main(String[] args) {

		int arrayLength = Utils.Arrays.requestNumber("Cuantos numeros vas a introducir?");
		
		int array[] = new int[arrayLength];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.Arrays.requestNumber("Introduzca numero: (" +(i+1) +")");
		}
		
	//	Utils.Arrays.printArray(array);
		
		System.out.println(stringFromArray(array));
	}
	
	public static StringBuffer stringFromArray(int array[]) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < array.length; i++) {
			 char letra = (char) array[i];
			 sb.append(letra);
		}
		
		return sb;
	}

}
