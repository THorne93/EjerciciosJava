package examenes.examen20231123;

public class Ex02_CombinacionDeArrays {

	public static void main(String[] args) {
		char array1[] = new char[] {'A','B','c','g'};
		char array2[] = new char[] {'d','e','F','l'};

		System.out.println(enManiscula(combinarArray(array1,array2)));
		
	}
	
	public static char[] combinarArray (char array1[], char array2[]) {
		char array3[] = new char[array1.length+array2.length];
		int count = 0;
		
		for (int i = 0, j = 0; i < array3.length;) {
			array3[i] = array1[j];
			i += 2;
			j++;
		}
		for (int i = 0, j = 0; i < array3.length;) {
			array3[i+1] = array2[j];
			i += 2;
			j++;
		}
		
		return array3;
	}
	
	public static char[] enManiscula (char array[]) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= 90 && array[i] >= 65) {
				array[i] += 32;
			}
		}
	return array;
	}	

}
