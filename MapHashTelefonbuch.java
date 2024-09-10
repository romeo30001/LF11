import java.util.HashMap;

import java.util.Scanner;

public class MapHashTelefonbuch {

	public static void main(String[] args) {
		Scanner ms = new Scanner(System.in);
		HashMap<String, String> telefonbuch = new HashMap<String, String>();
		boolean weiter = true;
		String eingabe, person, telefonnummer;

		while (weiter) {
			System.out.println("Telefonbuch-Men�: \n[a]Hinzuf�gen\n[b]L�schen\n[c]�berschreiben\n[d]Abfragen\n[e]Auslesen\n[f]Alle Eintr�ge Auslesen\n[g]Alle Eintr�ge L�schen\n[x]Ende");
			eingabe = ms.next();

			switch (eingabe) {
				case "a":
					System.out.println("Geben Sie den Namen der Person ein:");
					person = ms.next();
					System.out.println("Geben Sie die Telefonnummer der Person ein:");
					telefonnummer = ms.next();
					telefonbuch.put(person, telefonnummer);
					System.out.println("Eintrag hinzugefügt.");
					break;

				case "b":
					System.out.println("Geben Sie den Namen der Person ein, deren Eintrag gelöscht werden soll:");
					person = ms.next();
					telefonbuch.remove(person);
					System.out.println("Eintrag gelöscht.");
					break;

				case "c":
					System.out.println("Geben Sie den Namen der Person ein, deren Eintrag überschrieben werden soll:");
					person = ms.next();
					System.out.println("Geben Sie die neue Telefonnummer ein:");
					telefonnummer = ms.next();
					telefonbuch.put(person, telefonnummer);
					System.out.println("Eintrag überschrieben.");
					break;

				case "d":
					System.out.println("Geben Sie den Namen der Person ein, deren Telefonnummer abgefragt werden soll:");
					person = ms.next();
					telefonnummer = telefonbuch.get(person);
					if (telefonnummer != null) {
						System.out.println("Telefonnummer von " + person + ": " + telefonnummer);
					} else {
						System.out.println("Eintrag nicht gefunden.");
					}
					break;

				case "e":
					System.out.println("Geben Sie den Namen der Person ein, deren Telefonnummer ausgegeben werden soll:");
					person = ms.next();
					telefonnummer = telefonbuch.get(person);
					if (telefonnummer != null) {
						System.out.println("Telefonnummer von " + person + ": " + telefonnummer);
					} else {
						System.out.println("Eintrag nicht gefunden.");
					}
					break;

				case "g":
					telefonbuch.clear();
					System.out.println("Alle Einträge gelöscht.");
					break;

				case "x":
					weiter = false;
					System.out.println("Beendet!");
					System.out.println(telefonbuch);
					break;

				default:
					System.out.println("Ungültige Eingabe, bitte wählen Sie eine der Optionen.");
					break;
			}
		}
		ms.close();
	}
}
