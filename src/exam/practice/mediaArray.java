package exam.practice;

public class mediaArray {

	public static void main(String[] args) {
		
		int array[] = new int[100];
		Utils.Arrays.makeArray(array, -100, 100);
		Utils.Arrays.printArray(array);
		
		int total = 0;
		
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		
		int media = total / array.length;
		
		System.out.println("\nla media es: " +media);
		
		int debajoCount = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < media) {
				debajoCount++;
			}
		}
		System.out.println("la pocentaje de numeros debajo del medio es: " +debajoCount +"%");
	}

}
