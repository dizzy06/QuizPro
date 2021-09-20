import java.util.Scanner;

public class Main {

	static String eingabe;
	static boolean matches;
	static int counter;

	// ################Menü Aufbau########################
	static void menu() {
		matches = false;
		Scanner sc = new Scanner(System.in);
		counter = 0;
		while (!matches) {
			System.out.println("**********Quiz************\n");
			System.out.println("(S) --> Spiel starten");
			System.err.println("(Q) --> Quiz beenden");
			eingabe = sc.next().toUpperCase();

			if (eingabe.equals("S") || eingabe.equals("Q")) {
				matches = true;
			} else {
				System.out.println("Falsche Eingabe du Looser!");
				counter++;
				if (counter == 3) {
					System.out.println(
							"Einmal ist keinmal, zweimal ist zufall, aber beim drittenmal stimmt was nicht bei dir\nSuch dir dringends Hilfe");
					counter = 0;
				}
			}
		}
	}
	//#######################Spielablauf + Fragen################################################################
	static void startGame() {
		Fragen.setCounter(0); // Objekt Counter wird reseted, bei Neustart des Spiels werden die Fragen bzw. Objekte immer wieder neu erschaffen
		Scanner sc = new Scanner(System.in);
		int points = 0; // erreichte Punkte im Spiel
		String eingabe2 = "";
		System.out.println("ACHTUNG: Die Eingabe von sonstigen Zeichen wird als falsche Antwort gewertet!");
		// ################Fragen#########################
		Fragen f1 = new Fragen("Was ist 1+1?\nA)4 B)6 C)2 D)0", "C"); // Frage mit Antwortmöglichkeiten + Löser als Parameter übergeben
		Fragen f2 = new Fragen("Was ist 1+3?\nA)4 B)6 C)2 D)0", "A");
		Fragen f3 = new Fragen("Was ist 1-1?\nA)4 B)6 C)2 D)0", "D");
		Fragen f4 = new Fragen("Was ist die Quadratwurzel aus 144?\nA)13 B)15 C)12 D)11", "C");
		Fragen f5 = new Fragen("Was ist der Sinn des Lebens?\nA)Schlafen B)sinnlos C)42 D)Pommes", "C");
		Fragen f6 = new Fragen("Was kommt nach D?\nA)Z B)E C)2 D)0","B");

		Fragen[] collection = new Fragen[Fragen.getCounter()]; // Anzahl der Fragen/ Objekte bestimmen mein Array-Größe

		collection[0] = f1; // Objekte werden in Array gepackt --> ideal um mit Schleifen zu arbeiten
		collection[1] = f2;
		collection[2] = f3;
		collection[3] = f4;
		collection[4] = f5;
		collection[5] = f6;

		// ###############Logik zur Spielablauf################
		Zufall z = new Zufall();
		int[] zufallsReihe = z.createRandomOrder(collection.length); // Erzeugen einer Zufallsreihe von der Klasse Zufall bestimmt durch die Anzahl der Fragen

		for (int i = 0; i < collection.length; i++) { // Schleife um meine Fragen darzustellen
			System.out.println(collection[zufallsReihe[i]].getQuestion());
			eingabe2 = sc.next().toUpperCase();
			if (eingabe2.equals(collection[zufallsReihe[i]].getSolution())) {
				System.out.println("Richtig!!!");
				points++;
			} else {
				System.out.println("Falsche Antwort");
				System.out.println("GAME OVER!");
				System.out.println("Erreichte Punkte " + points);
				break;
			}
		}
		if (collection.length == points)
			System.out.println("Super alle Fragen richtig beantwortet\nPunkte: " + points);
		boolean matches = false;
		while (!matches) {
			System.out.println("Möchten Sie ein neues Spiel beginnen?\nJ(Ja) N(Nein)");
			eingabe2 = sc.next().toUpperCase();
			if (eingabe2.equals("J") || eingabe2.equals("N")) {
				matches = true;
			} else {
				System.out.println("Falsche Eingabe du Looser!");
			}
		}
		if (eingabe2.equals("J")) {
			startGame(); // Selbstaufruf, auch Rekursion genannt
		}
	}
//###########################################################################################################################################
	public static void main(String[] args) {

		menu();
		if (eingabe.equals("S")) {
			startGame();
		}

	}

}
