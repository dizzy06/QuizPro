/**
 * 
 * @author yasir
 * Klasse zur Erzeugung von Fragen f�r das Quiz
 */
public class Fragen {
	
	private String question; // Fragen
	private String solution; // L�ser
	private static int counter = 0; // Instanzenz�hler
	
	// Getter und Setter
	public Fragen(String question, String solution) {
		this.question = question;
		this.solution = solution;
		counter++;
	}
	
	public static int getCounter() {
		return counter;
	}
	
	public static void setCounter(int x) {
		counter = x;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

}
