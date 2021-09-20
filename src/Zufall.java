import java.util.Random;

/**
 * 
 * @author yasir, Klasse zur Erzeugen von zuf�lliger Reihe, wobei eine Zahl nur
 *         einaml vorkommen darf
 */

public class Zufall {

	Random random = new Random();

	public Zufall() {

	}

	public int[] createRandomOrder(int orderCount) { // Gr�sse der Reihe wird durch die Anzahl der Fragen bestimmt
		int randomOrder[] = new int[orderCount];
		for (int i = 0; i < randomOrder.length; i++) {
			randomOrder[i] = 999; // 999 ist nur ein Platzhalter f�r meine While-Bedingung, es wird ins Array
									// solange zuf�llig hineingegriffen bis Tasche den Wert 999 hat, dann wird der
									// Wert i in die Tasche zugewiesen
		}
		for (int i = 0; i < randomOrder.length; i++) {

			int temp = random.nextInt(randomOrder.length); // Startwert f�r mein Random
			while (randomOrder[temp] != 999) { // �berpr�fung auf mein Platzhalterwert
				temp = random.nextInt(randomOrder.length); // berechnet solange ein Randomwert bis ein Platzhalter
															// gefunden wird
			}
			randomOrder[temp] = i; // wenn ja, da schreibe den Wert i in mein Array
		}
		return randomOrder;
	}

}
