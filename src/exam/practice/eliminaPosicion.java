package exam.practice;

public class eliminaPosicion {

	public static void main(String[] args) {
		
		int array[] = new int[10];
		Utils.Arrays.makeArray(array, 0, 100);
		Utils.Arrays.printArray(array);
		
		int posicion = Utils.Arrays.requestNumber("Que posicion quieres eliminar?");
		
		for (int i = posicion-1; i < array.length-1; i++) {
			array[i] = array[i+1];
		}
		
		array[array.length-1] = (int) Math.round(Math.random()*100);
		
		System.out.println();
		Utils.Arrays.printArray(array);
		
	}

}
