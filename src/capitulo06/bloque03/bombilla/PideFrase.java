package capitulo06.bloque03.bombilla;

public class PideFrase {

	public static void main(String[] args) {

		try {
			String frase = Utils.Arrays.requestString("Escribe una frase (3+ palabras) que contenga la palabra 'bombilla' ");
			System.out.println(fraseToString(frase));
		} catch (NoEspacioBlancoException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (MenosDeTresException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (NoBombillaException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (PalabraOfensivaException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	private static String fraseToString (String frase) throws NoEspacioBlancoException, MenosDeTresException, NoBombillaException, PalabraOfensivaException {
		StringBuffer sb = new StringBuffer();

		
		
		if (! frase.contains(" ") ) {
			throw new NoEspacioBlancoException("Hay que escribir 3 ó más palabras");
		}
		else {
			int countWords = frase.split("\\s").length;
			if (countWords < 3) {
				throw new MenosDeTresException("Hay que escribir 3 ó más palabras");
			}
			else {
				
				if (! frase.contains("bombilla")) {
					throw new NoBombillaException("No has puesto la palabra 'bombilla'");
				}
				else {
					if (frase.contains("tonto") || frase.contains("idiota") || frase.contains("tonta")) {
						throw new PalabraOfensivaException("No puedes utilizar la palabra 'tonto','idiota' o 'tonta'");
					}
					else sb.append(frase);
					
				}
			}
		}
		
		return sb.toString();
	}

}
