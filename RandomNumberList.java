import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomNumberList {

    private List<Integer> myList;
    private static final int LIST_SIZE = 20;
    private static final int MAX_RANDOM_VALUE = 9;

    // Konstruktor, initialisiert die Liste mit 20 zufälligen Zahlen zwischen 1 und 9
    public RandomNumberList() {
        myList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < LIST_SIZE; i++) {
            myList.add(random.nextInt(MAX_RANDOM_VALUE) + 1);
        }
    }

    // Methode zur Ausgabe der Liste
    public void printList() {
        for (int i = 0; i < myList.size(); i++) {
            System.out.printf("myList[%2d] : %3d\n", i, myList.get(i));
        }
    }

    // Methode zur Suche einer Zahl und deren Indices in der Liste
    public void searchAndPrintOccurrences(int number) {
        int count = 0;
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) == number) {
                count++;
                indices.add(i);
            }
        }

        System.out.printf("Die Zahl %d kommt %d mal in der Liste vor.\n", number, count);
        if (count > 0) {
            System.out.println("Die Zahl kommt an folgenden Indices in der Liste vor:");
            for (int index : indices) {
                System.out.printf("myList[%2d] : %3d\n", index, number);
            }
        }
    }

    // Methode zum Löschen aller Vorkommen der Suchzahl
    public void deleteOccurrences(int number) {
        myList.removeIf(n -> n == number);
        System.out.println("Liste nach Löschung von " + number + ":");
        printList();
    }

    // Methode zum Einfügen einer 0 hinter jeder 5
    public void insertZeroAfterFive() {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) == 5) {
                myList.add(i + 1, 0);
                i++; // Damit der Iterator nicht die gerade eingefügte 0 überspringt
            }
        }
        System.out.println("Liste nach Einfügen von 0 hinter jeder 5:");
        printList();
    }

    public static void main(String[] args) {
        // Liste initialisieren und anzeigen
        RandomNumberList randomList = new RandomNumberList();
        System.out.println("Liste mit 20 Zufallszahlen:");
        randomList.printList();

        // Benutzereingabe für die Suchzahl
        Scanner scanner = new Scanner(System.in);
        System.out.print("Eine Zahl zwischen 1 und 9: ");
        int searchNumber = scanner.nextInt();

        // Suchzahl in der Liste suchen und anzeigen
        randomList.searchAndPrintOccurrences(searchNumber);

        // Löschen aller Vorkommen der Suchzahl und Liste anzeigen
        randomList.deleteOccurrences(searchNumber);

        // 0 hinter jeder 5 einfügen und Liste anzeigen
        randomList.insertZeroAfterFive();

        scanner.close();
    }
}
